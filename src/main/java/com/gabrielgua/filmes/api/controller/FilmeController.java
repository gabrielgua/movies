package com.gabrielgua.filmes.api.controller;

import com.gabrielgua.filmes.api.mapper.FilmeMapper;
import com.gabrielgua.filmes.api.model.FilmeRequest;
import com.gabrielgua.filmes.api.model.FilmeResponse;
import com.gabrielgua.filmes.domain.model.Filme;
import com.gabrielgua.filmes.domain.service.FilmeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService service;
    private final FilmeMapper mapper;

    private List<FilmeResponse> list(List<Filme> filmes) {
        return mapper.toCollectionResponse(filmes);
    }

    @GetMapping("/listar")
    public List<FilmeResponse> listAll() {
        return list(service.listAll());
    }

    @GetMapping("/{id}")
    public FilmeResponse findById(@PathVariable Long id) {
        return mapper.toResponse(service.findById(id));
    }

    @GetMapping("/buscar-por-diretor")
    public List<FilmeResponse> findAllByDiretor(@Param("diretor") String diretor) {
        return list(service.findByDiretor(diretor));
    }

    @GetMapping("/buscar-por-nome")
    public List<FilmeResponse> findAllByNome(@Param("nome") String nome) {
        return list(service.findByNome(nome));
    }

    @GetMapping("/buscar-por-genero")
    public List<FilmeResponse> findAllByGenero(@Param("genero") String genero) {
        return list(service.findByGenero(genero));
    }

    @GetMapping("/buscar-por-nota")
    public List<FilmeResponse> findAllByNota(@Param("nota") int nota) {
        return list(service.findByNota(nota));
    }

    @GetMapping("/buscar-por-data-lancamento")
    public List<FilmeResponse> findAllByDataLancamento(
            @Param("dataInicio") OffsetDateTime dataInicio,
            @Param("dataFim") OffsetDateTime dataFim) {

        return list(service.findByDataLancamentoBetween(dataInicio, dataFim));
    }


    @PostMapping("/cadastrar")
    public ResponseEntity<FilmeResponse> create(@Valid @RequestBody FilmeRequest request) {
        var filme = mapper.toEntity(request);
        return new ResponseEntity<>(mapper.toResponse(service.save(filme)), HttpStatus.CREATED);
    }
}
