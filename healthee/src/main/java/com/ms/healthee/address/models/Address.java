package com.ms.healthee.address.models;

import com.ms.healthee.address.dtos.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String address;
    private String complement;
    private String city;
    private String state;
    private String zipcode;

    public Address(AddressDTO addressDTO) {
        this.address = addressDTO.getAddress();
        this.complement = addressDTO.getComplement();
        this.city = addressDTO.getCity();
        this.state = addressDTO.getState();
        this.zipcode = addressDTO.getZipcode();
    }

    public void updateDataByID(AddressDTO addressDTO) {
        if (addressDTO.getAddress() != null){
            this.address = addressDTO.getAddress();
        }
        if (addressDTO.getComplement() != null){
            this.complement = addressDTO.getComplement();
        }
        if (addressDTO.getCity() != null){
            this.city = addressDTO.getCity();
        }
        if (addressDTO.getState() != null){
            this.state = addressDTO.getState();
        }
        if (addressDTO.getZipcode() != null){
            this.zipcode = addressDTO.getZipcode();
        }
    }
}
