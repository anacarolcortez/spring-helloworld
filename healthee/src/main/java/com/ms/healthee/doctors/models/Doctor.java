package com.ms.healthee.doctors.models;

import com.ms.healthee.address.models.Address;
import com.ms.healthee.doctors.dtos.DoctorCreateDTO;
import com.ms.healthee.doctors.dtos.DoctorUpdateDTO;
import com.ms.healthee.doctors.enums.Specialty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="doctors")
@Entity(name="Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Specialty specialization;
    @Embedded
    private Address address;
    private Boolean active = true;

    public Doctor(DoctorCreateDTO doctorCreateDTO) {
        this.name = doctorCreateDTO.getName();
        this.email = doctorCreateDTO.getEmail();
        this.phone = doctorCreateDTO.getPhone();
        this.crm = doctorCreateDTO.getCrm();
        this.specialization = Specialty.valueOf(doctorCreateDTO.getSpecialization());
        this.address = new Address(doctorCreateDTO.getAddress());
    }

    public void updateDataById(DoctorUpdateDTO doctorUpdateDTO) {
        if (doctorUpdateDTO.getName() != null) {
            this.name = doctorUpdateDTO.getName();
        }
        if (doctorUpdateDTO.getPhone() != null) {
            this.phone = doctorUpdateDTO.getPhone();
        }
        if (doctorUpdateDTO.getAddress() != null) {
            this.address.updateDataByID(doctorUpdateDTO.getAddress());
        }
    }

    public void inactivateDoctor() {
        this.active = false;
    }
}
