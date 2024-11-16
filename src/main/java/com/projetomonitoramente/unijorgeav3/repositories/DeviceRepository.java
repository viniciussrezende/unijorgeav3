package com.projetomonitoramente.unijorgeav3.repositories;

import com.projetomonitoramente.unijorgeav3.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
