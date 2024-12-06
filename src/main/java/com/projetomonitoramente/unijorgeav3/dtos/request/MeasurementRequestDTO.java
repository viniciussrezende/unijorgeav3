package com.projetomonitoramente.unijorgeav3.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record MeasurementRequestDTO(
        @NotNull
        Double value,
        @NotNull
        Long sensorId
) {
}
