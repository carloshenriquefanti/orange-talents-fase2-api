package br.com.zup.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Não encontramos esse preço... Vamos tentar outro?")
public class PriceNotFoundException extends Exception {
    public PriceNotFoundException() {
        super();
    }
}

