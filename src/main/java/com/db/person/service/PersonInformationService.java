package com.db.person.service;

import com.db.person.model.dto.PersonDTO;
import com.db.person.model.entity.PersonEntity;
import com.db.person.repository.PersonInformationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonInformationService {

    private final PersonInformationRepository repository;

    public PersonInformationService(PersonInformationRepository repository) {
        this.repository = repository;
    }

    public List<PersonDTO> findAll() {
        List<PersonEntity> personEntityList = repository.findAll();
        List<PersonDTO> resultRows = new ArrayList<>();
        personEntityList.stream().map(personEntity -> new PersonDTO(personEntity.getId(), personEntity.getName(), personEntity.getAge(),
                personEntity.getContactNumber(), personEntity.getAddress(), personEntity.getPinCode())).forEach(resultRows::add);
        return resultRows;
    }

    public PersonDTO addPerson(PersonDTO personDTO) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(personDTO.getName());
        personEntity.setAge(personDTO.getAge());
        personEntity.setContactNumber(personDTO.getContactNumber());
        personEntity.setAddress(personDTO.getAddress());
        personEntity.setPinCode(personDTO.getPinCode());
        repository.save(personEntity);
        personDTO.setId(personDTO.getId());
        return personDTO;
    }

}
