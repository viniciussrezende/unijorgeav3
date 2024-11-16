package com.projetomonitoramente.unijorgeav3.repositories;

import com.projetomonitoramente.unijorgeav3.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
