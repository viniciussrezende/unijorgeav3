package com.projetomonitoramente.unijorgeav3.dtos.response;

public record SensorResponseDTO(
        Long id,
        String description,
        Long deviceId,
        Long sensorTypeId,
        String sensorTypeName
) {
}
