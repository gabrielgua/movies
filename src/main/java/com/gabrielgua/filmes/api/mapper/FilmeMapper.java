package com.gabrielgua.filmes.api.mapper;

import com.gabrielgua.filmes.api.model.FilmeRequest;
import com.gabrielgua.filmes.api.model.FilmeResponse;
import com.gabrielgua.filmes.domain.model.Filme;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FilmeMapper {

    private final ModelMapper mapper;


    public FilmeResponse toResponse(Filme filme) {
        return mapper.map(filme, FilmeResponse.class);
    }

    public List<FilmeResponse> toCollectionResponse(List<Filme> filmes) {
        return filmes.stream()
                .map(this::toResponse)
                .toList();
    }

    public Filme toEntity(FilmeRequest request) {
        var filme = mapper.map(request, Filme.class);

        filme.setDataLancamento(OffsetDateTime.parse(request.getDataLancamento()));

        return filme;
    }
}
