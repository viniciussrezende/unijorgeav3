package com.projetomonitoramente.unijorgeav3.dtos.response;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DeviceResponseDTO(
        Long id,
        String name,
        String description,
        String location
) {
}
