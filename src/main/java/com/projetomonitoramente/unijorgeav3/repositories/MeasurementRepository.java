package com.projetomonitoramente.unijorgeav3.repositories;

import com.projetomonitoramente.unijorgeav3.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
}
