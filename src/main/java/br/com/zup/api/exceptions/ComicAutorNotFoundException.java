package br.com.zup.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Não encontramos esse autor... Vamos tentar outro?")
public class ComicAutorNotFoundException extends Exception {
    public ComicAutorNotFoundException() {
        super();
    }
}