package com.projetomonitoramente.unijorgeav3.services;

import com.projetomonitoramente.unijorgeav3.dtos.request.SensorRequestDTO;
import com.projetomonitoramente.unijorgeav3.dtos.response.SensorResponseDTO;
import com.projetomonitoramente.unijorgeav3.models.Device;
import com.projetomonitoramente.unijorgeav3.models.Sensor;
import com.projetomonitoramente.unijorgeav3.models.SensorType;
import com.projetomonitoramente.unijorgeav3.repositories.DeviceRepository;
import com.projetomonitoramente.unijorgeav3.repositories.SensorRepository;
import com.projetomonitoramente.unijorgeav3.repositories.SensorTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private SensorTypeRepository sensorTypeRepository;

    public SensorResponseDTO createSensor(SensorRequestDTO dto) {
        Device device = deviceRepository.findById(dto.deviceId())
                .orElseThrow(() -> new RuntimeException("Device not found"));

        SensorType sensorType = sensorTypeRepository.findById(dto.sensorTypeId())
                .orElseThrow(() -> new RuntimeException("SensorType not found"));

        Sensor sensor = new Sensor();
        sensor.setDescription(dto.description());
        sensor.setDevice(device);
        sensor.setSensorType(sensorType);

        sensor = sensorRepository.save(sensor);
        return toResponseDTO(sensor);
    }

    public List<SensorResponseDTO> getAllSensors() {
        List<Sensor> list = sensorRepository.findAll();
        return list.stream().map(this::toResponseDTO).toList();
    }

    public SensorResponseDTO getSensorById(Long id) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor not found"));
        return toResponseDTO(sensor);
    }

    public SensorResponseDTO updateSensor(Long id, SensorRequestDTO dto) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor not found"));

        Device device = deviceRepository.findById(dto.deviceId())
                .orElseThrow(() -> new RuntimeException("Device not found"));

        SensorType sensorType = sensorTypeRepository.findById(dto.sensorTypeId())
                .orElseThrow(() -> new RuntimeException("SensorType not found"));

        sensor.setDescription(dto.description());
        sensor.setDevice(device);
        sensor.setSensorType(sensorType);

        sensor = sensorRepository.save(sensor);
        return toResponseDTO(sensor);
    }

    public void deleteSensor(Long id) {
        if(!sensorRepository.existsById(id)){
            throw new RuntimeException("Sensor not found");
        }
        sensorRepository.deleteById(id);
    }

    private SensorResponseDTO toResponseDTO(Sensor sensor) {
        return new SensorResponseDTO(
                sensor.getId(),
                sensor.getDescription(),
                sensor.getDevice().getId(),
                sensor.getSensorType().getId(),
                sensor.getSensorType().getName()
        );
    }
}

