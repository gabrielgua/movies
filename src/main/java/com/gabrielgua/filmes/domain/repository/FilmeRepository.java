package com.gabrielgua.filmes.domain.repository;

import com.gabrielgua.filmes.domain.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    List<Filme> findAllByDiretor(String diretor);
    List<Filme> findAllByNome(String nome);
    List<Filme> findAllByGenero(String genero);
    List<Filme> findAllByNota(int nota);
    List<Filme> findAllByDataLancamentoBetween(OffsetDateTime dataInicio, OffsetDateTime dataFim);

}
