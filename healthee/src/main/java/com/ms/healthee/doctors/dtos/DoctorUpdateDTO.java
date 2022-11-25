package com.ms.healthee.doctors.dtos;

import com.ms.healthee.address.dtos.AddressDTO;
import lombok.Data;

@Data
public class DoctorUpdateDTO {
    Long id;
    String name;
    String phone;
    AddressDTO address;
}
