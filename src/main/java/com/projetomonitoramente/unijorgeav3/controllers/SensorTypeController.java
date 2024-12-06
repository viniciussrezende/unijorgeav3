package com.projetomonitoramente.unijorgeav3.controllers;

import com.projetomonitoramente.unijorgeav3.dtos.request.SensorTypeRequestDTO;
import com.projetomonitoramente.unijorgeav3.dtos.response.SensorTypeResponseDTO;
import com.projetomonitoramente.unijorgeav3.services.SensorTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sensor-types")
public class SensorTypeController {

    @Autowired
    private SensorTypeService sensorTypeService;

    @PostMapping
    public ResponseEntity<SensorTypeResponseDTO> createSensorType(@Valid @RequestBody SensorTypeRequestDTO requestDTO){
        SensorTypeResponseDTO response = sensorTypeService.createSensorType(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<SensorTypeResponseDTO>> getAllSensorTypes(){
        List<SensorTypeResponseDTO> list = sensorTypeService.getAllSensorTypes();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensorTypeResponseDTO> getSensorTypeById(@PathVariable Long id){
        SensorTypeResponseDTO response = sensorTypeService.getSensorTypeById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SensorTypeResponseDTO> updateSensorType(@PathVariable Long id, @Valid @RequestBody SensorTypeRequestDTO requestDTO){
        SensorTypeResponseDTO response = sensorTypeService.updateSensorType(id, requestDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensorType(@PathVariable Long id){
        sensorTypeService.deleteSensorType(id);
        return ResponseEntity.noContent().build();
    }

}
