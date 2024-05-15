package com.gabrielgua.filmes.api.model;

import com.gabrielgua.filmes.api.validation.DataLancamento;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

@Getter
@Setter
public class FilmeRequest {

    @NotBlank
    private String nome;

    @DataLancamento
    private String dataLancamento;

    @NotNull
    @Min(1)
    @Max(5)
    private int nota;

    @NotBlank
    private String genero;

    @NotBlank
    private String diretor;
}
