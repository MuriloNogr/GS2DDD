package com.pillpal.api.repository;

import com.pillpal.api.model.Medicamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PillpalRepository extends JpaRepository <Medicamentos, Long>{
    
}
