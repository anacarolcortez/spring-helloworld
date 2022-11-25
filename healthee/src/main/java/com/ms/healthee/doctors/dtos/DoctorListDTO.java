package com.ms.healthee.doctors.dtos;

import com.ms.healthee.doctors.enums.Specialty;
import com.ms.healthee.doctors.models.Doctor;
import lombok.Data;

@Data
public class DoctorListDTO {

    private Long id;
    private String name;
    private String email;
    private String crm;
    private String specialization;

    public DoctorListDTO(Long id, String name, String email, String crm, Specialty specialization) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.crm = crm;
        this.specialization = String.valueOf(specialization);
    }

    public DoctorListDTO(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialization());
    }


}
