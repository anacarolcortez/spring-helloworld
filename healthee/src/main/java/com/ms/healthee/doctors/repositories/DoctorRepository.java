package com.ms.healthee.doctors.repositories;

import com.ms.healthee.doctors.models.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.DoubleStream;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Page<Doctor> findAllByActiveTrue(Pageable page);
    //seguindo o padão de nomenclatura, o spring gera automaticamente as queries de consulta
}
