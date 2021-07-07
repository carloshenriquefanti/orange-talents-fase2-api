package br.com.zup.api.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Não encontramos esse titulo... Vamos tentar outro?")
public class TitleNotFoundException extends Exception {
    public TitleNotFoundException() {
        super();
    }
}

