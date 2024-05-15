package com.gabrielgua.filmes.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashMap;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "filmes")
public class Filme {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private OffsetDateTime dataLancamento;

    private int nota;
    private String genero;
    private String diretor;

    public String getClassificacao() {
        var classificacoes = new HashMap<Integer, String>();
        classificacoes.put(1, "Esse é ruim demais!");
        classificacoes.put(2, "Ok!");
        classificacoes.put(3, "Bom!");
        classificacoes.put(4, "Excelente");
        classificacoes.put(5, "Absolute Cinema!");

        return classificacoes.get(this.nota);
    }
}
