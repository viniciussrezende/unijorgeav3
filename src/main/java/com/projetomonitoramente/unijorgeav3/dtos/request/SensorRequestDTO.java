package com.projetomonitoramente.unijorgeav3.dtos.request;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record SensorRequestDTO(
        @NotEmpty
        String description,
        @NotNull
        Long deviceId,
        @NotNull
        Long sensorTypeId
) {
}
