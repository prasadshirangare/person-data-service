package com.db.person.model.dto;

import lombok.Data;

@Data
public class PersonDTO {

    private Long id;
    private String name;
    private Integer age;
    private Long contactNumber;
    private String address;
    private Integer pinCode;

    public PersonDTO(Long id, String name, Integer age, Long contactNumber, String address, Integer pinCode) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.address = address;
        this.pinCode = pinCode;
    }
}
