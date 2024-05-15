package com.gabrielgua.filmes.api.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class Error {

    private Integer status;
    private Map<String, Object> errors;
}
