package com.gabrielgua.filmes.domain.service;

import com.gabrielgua.filmes.domain.exception.EmptyListException;
import com.gabrielgua.filmes.domain.exception.FilmeNotFoundException;
import com.gabrielgua.filmes.domain.model.Filme;
import com.gabrielgua.filmes.domain.repository.FilmeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository repository;

    private List<Filme> listOrThrow(List<Filme> filmes) {
        if (filmes.isEmpty()) throw new EmptyListException();

        return filmes;
    }

    @Transactional(readOnly = true)
    public List<Filme> listAll() {
        return listOrThrow(repository.findAll());
    }

    @Transactional(readOnly = true)
    public List<Filme> findByDiretor(String diretor) {
        return listOrThrow(repository.findAllByDiretor(diretor));
    }

    @Transactional(readOnly = true)
    public List<Filme> findByNome(String nome) {
        return listOrThrow(repository.findAllByNome(nome));
    }

    @Transactional(readOnly = true)
    public List<Filme> findByGenero(String genero) {
        return listOrThrow(repository.findAllByGenero(genero));
    }

    @Transactional(readOnly = true)
    public List<Filme> findByDataLancamentoBetween(OffsetDateTime inicio, OffsetDateTime fim) {
        return listOrThrow(repository.findAllByDataLancamentoBetween(inicio, fim));
    }

    @Transactional(readOnly = true)
    public List<Filme> findByNota(int nota) {
        return listOrThrow(repository.findAllByNota(nota));
    }

    @Transactional(readOnly = true)
    public Filme findById(Long id) {
        return repository.findById(id).orElseThrow(FilmeNotFoundException::new);
    }



    @Transactional
    public Filme save(Filme filme) {
        return repository.save(filme);
    }
}
