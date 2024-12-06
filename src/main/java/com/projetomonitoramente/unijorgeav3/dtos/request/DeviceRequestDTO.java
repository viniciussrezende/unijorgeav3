package com.projetomonitoramente.unijorgeav3.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record DeviceRequestDTO(

        @NotEmpty(message = "Name cannot be empty")
        @Size(min = 5, max = 20, message = "Name must be between 5 and 20 characters")
        String name,

        @NotEmpty(message = "Description cannot be empty")
        @Size(min = 5, max = 100, message = "Description must be between 5 and 100 characters")
        String description,

        @NotEmpty(message = "Location cannot be empty")
        @Size(min = 5, max = 50, message = "Location must be between 5 and 50 characters")
        String location
) {
}
