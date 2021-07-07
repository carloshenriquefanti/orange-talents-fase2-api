package br.com.zup.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Não encontramos esse ISBN... Vamos tentar outro?")
public class ComicISBNNotFoundException extends Exception {
    public ComicISBNNotFoundException() {
        super();
    }
}
