package br.com.zup.api.comic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.api.exceptions.ComicAutorNotFoundException;
import br.com.zup.api.exceptions.ComicISBNNotFoundException;
import br.com.zup.api.exceptions.PriceNotFoundException;
import br.com.zup.api.exceptions.TitleNotFoundException;
import br.com.zup.api.marvel.Autors;
import br.com.zup.api.marvel.Autors.Autor;
import br.com.zup.api.marvel.Comic;
import br.com.zup.api.marvel.ComicDetails;
import br.com.zup.api.marvel.MarvelAPIFeign;
import br.com.zup.api.marvel.Titles;
import br.com.zup.api.customer.CustomerEntity;
import br.com.zup.api.utils.Utils;
import br.com.zup.api.comic.ComicEntity;
import br.com.zup.api.comic.ComicRepository;


@Service
public class ComicService {

    @Autowired
    private ComicRepository comicRepository;

    @Autowired
    private MarvelAPIFeign marvelAPIFeign;


    public ComicEntity saveComic(ComicEntity comic, Integer id) throws TitleNotFoundException, PriceNotFoundException, ComicAutorNotFoundException {
        Titles titleMarvel = marvelAPIFeign.getTitles()
                .stream()
                .filter(tm -> tm.getNome().equalsIgnoreCase(comic.getTitle()))
                .findFirst()
                .orElseThrow(TitleNotFoundException::new);

        String idTitulo = titleMarvel.getCodigo();

////        Prices.Price price = marvelAPIFeign.getPrices(idPrices).getPrices()
////                .stream()
////                .filter(p -> m.getNome().equalsIgnoreCase(comic.getPrice()))
////                .findFirst()
////                .orElseThrow(PriceNotFoundException::new);
//
//        String idPrice = price.getCodigo();

        Autors comicAutor = marvelAPIFeign.getAutors(idTitulo)
                .stream()
                .filter(a -> a.getAutores().equals(comic.getAutor()))
                .findFirst()
                .orElseThrow(ComicAutorNotFoundException::new);

        String autores = comicAutor.getAutores();
        
//        Autors autorMarvel = marvelAPIFeign.getAutors(idTitulo)
//                .stream()
//                .filter(a -> a.getCodigo().equals(comic.getAutor()))
//                .findFirst()
//                .orElseThrow(ComicISBNNotFoundException::new);
//
//        String isbns = comicISBN.getCodigo();

        ComicDetails comicDetails = marvelAPIFeign.getComicDetails(idTitulo);

        comic.setPrice(comicDetails.getPrice());
        setComicDiscountInfo(comic);

        CustomerEntity customer = new CustomerEntity();
        customer.setId(id);

        comic.setCustomer(customer);
        return comicRepository.save(comic);
    }
    private void setComicDiscountInfo(ComicEntity comic) {
        String dayWeek = "";
        String lastDigitISBN = comic.getIsbn().substring(comic.getIsbn().length() - 1);

        switch (lastDigitISBN) {
            case "0" :
            case "1" :
                dayWeek = "segunda-feira";
                break;

            case "2" :
            case "3" :
                dayWeek = "terça-feira";
                break;

            case "4" :
            case "5" :
                dayWeek = "quarta-feira";
                break;

            case "6" :
            case "7" :
                dayWeek = "quinta-feira";
                break;

            case "8" :
            case "9" :
                dayWeek = "sexta-feira";
                break;
        }

        comic.setDayDiscount(dayWeek);

        if(dayWeek.equals(Utils.getDayWeek())){
            comic.setActiveDiscount(true);
        }
    }
}