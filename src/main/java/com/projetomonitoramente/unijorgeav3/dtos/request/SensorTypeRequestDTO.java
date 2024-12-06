package com.projetomonitoramente.unijorgeav3.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record SensorTypeRequestDTO(
        @NotBlank
        String name,
        @NotBlank
        String units
) {
}
