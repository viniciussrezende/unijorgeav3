package com.projetomonitoramente.unijorgeav3.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record SensorTypeRequestDTO(
        @NotEmpty
        String name,
        @NotEmpty
        String units
) {
}
