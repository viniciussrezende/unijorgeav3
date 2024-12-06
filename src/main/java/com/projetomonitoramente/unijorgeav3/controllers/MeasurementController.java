package com.projetomonitoramente.unijorgeav3.controllers;

import com.projetomonitoramente.unijorgeav3.dtos.request.MeasurementRequestDTO;
import com.projetomonitoramente.unijorgeav3.dtos.response.MeasurementResponseDTO;
import com.projetomonitoramente.unijorgeav3.services.MeasurementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("measurements")
public class MeasurementController {

    @Autowired
    private MeasurementService measurementService;

    @PostMapping
    public ResponseEntity<MeasurementResponseDTO> createMeasurement(@Valid @RequestBody MeasurementRequestDTO requestDTO){
        MeasurementResponseDTO response = measurementService.createMeasurement(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<MeasurementResponseDTO>> getAllMeasurements(){
        List<MeasurementResponseDTO> list = measurementService.getAllMeasurements();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeasurementResponseDTO> getMeasurementById(@PathVariable Long id){
        MeasurementResponseDTO response = measurementService.getMeasurementById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MeasurementResponseDTO> updateMeasurement(@PathVariable Long id, @Valid @RequestBody MeasurementRequestDTO requestDTO){
        MeasurementResponseDTO response = measurementService.updateMeasurement(id, requestDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeasurement(@PathVariable Long id){
        measurementService.deleteMeasurement(id);
        return ResponseEntity.noContent().build();
    }

}

