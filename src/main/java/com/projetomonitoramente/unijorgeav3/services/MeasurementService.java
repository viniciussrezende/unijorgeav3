package com.projetomonitoramente.unijorgeav3.services;

import com.projetomonitoramente.unijorgeav3.dtos.request.MeasurementRequestDTO;
import com.projetomonitoramente.unijorgeav3.dtos.response.MeasurementResponseDTO;
import com.projetomonitoramente.unijorgeav3.models.Measurement;
import com.projetomonitoramente.unijorgeav3.models.Sensor;
import com.projetomonitoramente.unijorgeav3.repositories.MeasurementRepository;
import com.projetomonitoramente.unijorgeav3.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepository measurementRepository;

    @Autowired
    private SensorRepository sensorRepository;

    public MeasurementResponseDTO createMeasurement(MeasurementRequestDTO dto) {
        Sensor sensor = sensorRepository.findById(dto.sensorId())
                .orElseThrow(() -> new RuntimeException("Sensor not found"));

        Measurement measurement = new Measurement();
        measurement.setValue(dto.value());
        measurement.setSensor(sensor);
        measurement.setTimestamp(LocalDateTime.now());

        measurement = measurementRepository.save(measurement);
        return toResponseDTO(measurement);
    }

    public List<MeasurementResponseDTO> getAllMeasurements() {
        List<Measurement> list = measurementRepository.findAll();
        return list.stream().map(this::toResponseDTO).toList();
    }

    public MeasurementResponseDTO getMeasurementById(Long id) {
        Measurement measurement = measurementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Measurement not found"));
        return toResponseDTO(measurement);
    }

    public MeasurementResponseDTO updateMeasurement(Long id, MeasurementRequestDTO dto) {
        Measurement measurement = measurementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Measurement not found"));

        Sensor sensor = sensorRepository.findById(dto.sensorId())
                .orElseThrow(() -> new RuntimeException("Sensor not found"));

        measurement.setValue(dto.value());
        measurement.setSensor(sensor);
        measurement.setTimestamp(LocalDateTime.now());

        measurement = measurementRepository.save(measurement);
        return toResponseDTO(measurement);
    }

    public void deleteMeasurement(Long id) {
        if(!measurementRepository.existsById(id)){
            throw new RuntimeException("Measurement not found");
        }
        measurementRepository.deleteById(id);
    }

    private MeasurementResponseDTO toResponseDTO(Measurement measurement) {
        return new MeasurementResponseDTO(
                measurement.getId(),
                measurement.getValue(),
                measurement.getSensor().getId(),
                measurement.getTimestamp()
        );
    }
}
