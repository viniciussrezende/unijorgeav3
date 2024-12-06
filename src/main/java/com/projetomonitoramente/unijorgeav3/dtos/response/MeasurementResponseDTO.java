package com.projetomonitoramente.unijorgeav3.dtos.response;

import java.time.LocalDateTime;

public record MeasurementResponseDTO(
        Long id,
        Double value,
        Long sensorId,
        LocalDateTime timestamp
) {
}
