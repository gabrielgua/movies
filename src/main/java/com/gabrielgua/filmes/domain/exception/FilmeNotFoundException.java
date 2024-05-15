package com.gabrielgua.filmes.domain.exception;

public class FilmeNotFoundException extends BusinessException {
    public FilmeNotFoundException() {
        super("Filme não encontrado.");
    }
}
