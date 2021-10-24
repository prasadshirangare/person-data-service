package com.db.person.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PERSON")
public class PersonEntity {

    @Id
    @GeneratedValue
    @Column(name = "PERSON_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "CONTACT_NO")
    private Long contactNumber;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PINCODE")
    private Integer pinCode;

}
