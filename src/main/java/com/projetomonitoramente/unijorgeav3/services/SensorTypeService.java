package com.projetomonitoramente.unijorgeav3.services;

import com.projetomonitoramente.unijorgeav3.dtos.request.SensorTypeRequestDTO;
import com.projetomonitoramente.unijorgeav3.dtos.response.SensorTypeResponseDTO;
import com.projetomonitoramente.unijorgeav3.models.SensorType;
import com.projetomonitoramente.unijorgeav3.repositories.SensorTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorTypeService {

    @Autowired
    private SensorTypeRepository sensorTypeRepository;

    public SensorTypeResponseDTO createSensorType(SensorTypeRequestDTO dto) {
        SensorType sensorType = new SensorType();
        sensorType.setName(dto.name());
        sensorType.setUnits(dto.units());

        sensorType = sensorTypeRepository.save(sensorType);
        return toResponseDTO(sensorType);
    }

    public List<SensorTypeResponseDTO> getAllSensorTypes() {
        List<SensorType> list = sensorTypeRepository.findAll();
        return list.stream().map(this::toResponseDTO).toList();
    }

    public SensorTypeResponseDTO getSensorTypeById(Long id) {
        SensorType sensorType = sensorTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SensorType not found"));
        return toResponseDTO(sensorType);
    }

    public SensorTypeResponseDTO updateSensorType(Long id, SensorTypeRequestDTO dto) {
        SensorType sensorType = sensorTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SensorType not found"));

        sensorType.setName(dto.name());
        sensorType.setUnits(dto.units());

        sensorType = sensorTypeRepository.save(sensorType);
        return toResponseDTO(sensorType);
    }

    public void deleteSensorType(Long id) {
        if(!sensorTypeRepository.existsById(id)){
            throw new RuntimeException("SensorType not found");
        }
        sensorTypeRepository.deleteById(id);
    }

    private SensorTypeResponseDTO toResponseDTO(SensorType sensorType) {
        return new SensorTypeResponseDTO(
                sensorType.getId(),
                sensorType.getName(),
                sensorType.getUnits()

        );
    }
}

