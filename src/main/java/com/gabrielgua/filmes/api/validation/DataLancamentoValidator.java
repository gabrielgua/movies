package com.gabrielgua.filmes.api.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.OffsetDateTime;

public class DataLancamentoValidator implements ConstraintValidator<DataLancamento, String> {
    @Override
    public boolean isValid(String dataLancamento, ConstraintValidatorContext context) {

        if (!dataLancamento.matches("^(?:[1-9]\\d{3}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1\\d|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[1-9]\\d(?:0[48]|[2468][048]|[13579][26])|(?:[2468][048]|[13579][26])00)-02-29)T(?:[01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d(?:Z|[+-][01]\\d:[0-5]\\d)$")) {
            return false;
        }

        var lancamento = OffsetDateTime.parse(dataLancamento);

        var maxDate = OffsetDateTime.parse("9999-12-31T00:00Z");
        var minDate = OffsetDateTime.parse("1600-01-01T00:00Z");

        return lancamento.isBefore(maxDate) && lancamento.isAfter(minDate);
    }
}
