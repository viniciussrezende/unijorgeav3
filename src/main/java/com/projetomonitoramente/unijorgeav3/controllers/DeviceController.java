package com.projetomonitoramente.unijorgeav3.controllers;


import com.projetomonitoramente.unijorgeav3.dtos.request.DeviceRequestDTO;
import com.projetomonitoramente.unijorgeav3.dtos.response.DeviceResponseDTO;
import com.projetomonitoramente.unijorgeav3.services.DeviceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;


    @PostMapping
    public ResponseEntity<DeviceResponseDTO> createDevice(@Valid @RequestBody DeviceRequestDTO deviceRequestDTO){
        DeviceResponseDTO deviceResponseDTO = deviceService.createDevice(deviceRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(deviceResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<DeviceResponseDTO>> getAllDevices(){
        List<DeviceResponseDTO> deviceResponseDTOS = deviceService.getAllDevices();
        return ResponseEntity.status(HttpStatus.CREATED).body(deviceResponseDTOS);
    }

}
