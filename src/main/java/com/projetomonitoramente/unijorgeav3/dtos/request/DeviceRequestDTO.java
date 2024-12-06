package com.projetomonitoramente.unijorgeav3.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record DeviceRequestDTO(

        @NotEmpty(message = "Name cannot be empty")
        String name,

        @NotEmpty(message = "Description cannot be empty")
        String description,

        @NotEmpty(message = "Location cannot be empty")
        String location
) {
}
