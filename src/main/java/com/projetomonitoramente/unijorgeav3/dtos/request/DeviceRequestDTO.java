package com.projetomonitoramente.unijorgeav3.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DeviceRequestDTO(
        @NotNull(message = "name cannot be null")
        @NotEmpty(message = "name cannot be empty")
        String name,

        @NotNull(message = "description cannot be null")
        @NotEmpty(message = "description cannot be empty")
        String description,

        @NotNull(message = "location cannot be null")
        @NotEmpty(message = "location cannot be empty")
        String location
) {
}
