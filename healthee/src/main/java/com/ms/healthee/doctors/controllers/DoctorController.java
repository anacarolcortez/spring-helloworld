package com.ms.healthee.doctors.controllers;

import com.ms.healthee.doctors.dtos.DoctorCreateDTO;
import com.ms.healthee.doctors.dtos.DoctorListDTO;
import com.ms.healthee.doctors.dtos.DoctorUpdateDTO;
import com.ms.healthee.doctors.models.Doctor;
import com.ms.healthee.doctors.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public void createDoctor(@RequestBody @Valid DoctorCreateDTO docdata){
        Doctor doctor = new Doctor(docdata);
        doctorRepository.save(doctor);
    }
    @GetMapping
    public Page<DoctorListDTO> list(@PageableDefault(sort={"name"}) Pageable page){
        return doctorRepository.findAll(page).map(DoctorListDTO::new);
    }

    @GetMapping("/active")
    public Page<DoctorListDTO> listActive(@PageableDefault(sort={"name"}) Pageable page){
        return doctorRepository.findAllByActiveTrue(page).map(DoctorListDTO::new);
    }

    @GetMapping("/{id}")
    public Optional<Doctor> findDoctorById(@PathVariable Long id){
        return doctorRepository.findById(id);
    }

    @PutMapping
    @Transactional
    public void updateDoctor(@RequestBody @Valid DoctorUpdateDTO docdata){
        Doctor doctor = doctorRepository.getReferenceById(docdata.getId());
        doctor.updateDataById(docdata);
        //com a anotação Transactional da JPA, o código roda dentro de uma transação,
        //o que significa que ele vai se atualizar sem a necessidade de um método de update
        //de bd do repositoy
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteDoctorById(@PathVariable Long id){
        doctorRepository.deleteById(id);
    }

    //exclusão lógica
    @DeleteMapping("/inactivate/{id}")
    @Transactional
    public void inactivateDoctorById(@PathVariable Long id){
        Doctor doctor = doctorRepository.getReferenceById(id);
        doctor.inactivateDoctor();
    }
}
