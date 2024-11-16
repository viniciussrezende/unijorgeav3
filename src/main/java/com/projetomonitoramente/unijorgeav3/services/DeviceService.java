package com.projetomonitoramente.unijorgeav3.services;

import com.projetomonitoramente.unijorgeav3.dtos.request.DeviceRequestDTO;
import com.projetomonitoramente.unijorgeav3.dtos.response.DeviceResponseDTO;
import com.projetomonitoramente.unijorgeav3.models.Device;
import com.projetomonitoramente.unijorgeav3.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;


    public DeviceResponseDTO createDevice(DeviceRequestDTO deviceRequestDTO){
        Device device = dtoToDevice(deviceRequestDTO);
        device = deviceRepository.save(device);
        return deviceToDTO(device);
    }

    public List<Device> getAllDevices(){
        return deviceRepository.findAll();
    }

    private Device dtoToDevice(DeviceRequestDTO deviceRequestDTO){
        Device device = new Device();

        device.setName(deviceRequestDTO.name());
        device.setDescription(deviceRequestDTO.description());
        device.setLocation(deviceRequestDTO.location());

        return device;
    }

    private DeviceResponseDTO deviceToDTO(Device device){
        return new DeviceResponseDTO(
                device.getId(),
                device.getDescription(),
                device.getLocation(),
                device.getName()
        );
    }
}
