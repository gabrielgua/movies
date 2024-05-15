package com.gabrielgua.filmes.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Getter
@Setter
public class FilmeResponse {

    private Long id;
    private String nome;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dataLancamento;

    private int nota;
    private String classificacao;

    private String genero;
    private String diretor;

}
