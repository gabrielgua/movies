package com.gabrielgua.filmes.domain.exception;

public class EmptyListException extends BusinessException {
    public EmptyListException() {
        super("List is empty");
    }
}
