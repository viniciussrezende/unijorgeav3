package com.projetomonitoramente.unijorgeav3.controllers;

import com.projetomonitoramente.unijorgeav3.dtos.request.SensorRequestDTO;
import com.projetomonitoramente.unijorgeav3.dtos.response.SensorResponseDTO;
import com.projetomonitoramente.unijorgeav3.services.SensorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sensors")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @PostMapping
    public ResponseEntity<SensorResponseDTO> createSensor(@Valid @RequestBody SensorRequestDTO requestDTO){
        SensorResponseDTO response = sensorService.createSensor(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<SensorResponseDTO>> getAllSensors(){
        List<SensorResponseDTO> list = sensorService.getAllSensors();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensorResponseDTO> getSensorById(@PathVariable Long id){
        SensorResponseDTO response = sensorService.getSensorById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SensorResponseDTO> updateSensor(@PathVariable Long id, @Valid @RequestBody SensorRequestDTO requestDTO){
        SensorResponseDTO response = sensorService.updateSensor(id, requestDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensor(@PathVariable Long id){
        sensorService.deleteSensor(id);
        return ResponseEntity.noContent().build();
    }

}

