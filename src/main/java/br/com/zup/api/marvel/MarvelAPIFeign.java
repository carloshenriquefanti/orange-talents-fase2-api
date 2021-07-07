package br.com.zup.api.marvel;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import br.com.zup.api.marvel.Titles;
import br.com.zup.api.marvel.Autors;
import br.com.zup.api.marvel.Comic;
import br.com.zup.api.marvel.ComicDetails;

	@FeignClient(name = "consulta", url = "http://gateway.marvel.com/v1/public/comics")
	public interface MarvelAPIFeign {

	    @GetMapping("/comics/titles")
	    List<Titles> getTitles();

	    @GetMapping("/comics/titles/{idTitles}")
	    List<Autors> getAutors(@PathVariable String id);

	    @GetMapping("/comics/titles/{idTitle}/autores/{idAutor}")
	    List<Comic> getIsbns(@PathVariable String idTitle, @PathVariable String idPrice);

	    @GetMapping("/comics/titles/{idTitle}/autores/{idAutor}")
	    ComicDetails getComicDetails(@PathVariable String idTitle);
	}

