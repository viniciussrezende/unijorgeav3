package com.projetomonitoramente.unijorgeav3.dtos.request;


import jakarta.validation.constraints.NotEmpty;

public record SensorRequestDTO(
        @NotEmpty
        String description,
        @NotEmpty
        Long deviceId,
        @NotEmpty
        Long sensorTypeId
) {
}
