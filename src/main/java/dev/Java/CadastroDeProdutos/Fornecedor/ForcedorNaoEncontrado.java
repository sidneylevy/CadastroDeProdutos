package dev.Java.CadastroDeProdutos.Fornecedor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ForcedorNaoEncontrado extends RuntimeException {
    public ForcedorNaoEncontrado(String message) {
        super(message);
    }
}
