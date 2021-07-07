package br.com.zup.api.comic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import br.com.zup.api.exceptions.TitleNotFoundException;
import br.com.zup.api.exceptions.ComicAutorNotFoundException;
import br.com.zup.api.exceptions.ComicISBNNotFoundException;
import br.com.zup.api.exceptions.PriceNotFoundException;
import br.com.zup.api.comic.ComicEntity;
import br.com.zup.api.comic.ComicService;


@RestController
@RequestMapping("/comics")
public class ComicController {

    @Autowired
    private ComicService comicService;

    @PostMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ComicEntity saveComic(@RequestBody ComicEntity comic, @PathVariable("id") Integer id) throws TitleNotFoundException,
                ComicAutorNotFoundException, ComicISBNNotFoundException, PriceNotFoundException {
        return comicService.saveComic(comic, id);
    }
}
