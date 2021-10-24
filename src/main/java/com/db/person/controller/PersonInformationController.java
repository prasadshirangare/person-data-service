package com.db.person.controller;

import com.db.person.model.dto.PersonDTO;
import com.db.person.service.PersonInformationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@CrossOrigin
public class PersonInformationController {

    private final PersonInformationService personInformationService;

    public PersonInformationController(PersonInformationService personInformationService) {
        this.personInformationService = personInformationService;
    }

    /**
     * Returns details of all persons
     *
     * @return - List of Person details
     */
    @GetMapping
    public List<PersonDTO> getAllPersons() {
        return personInformationService.findAll();
    }

    /**
     * Adds new person
     *
     * @param personDTO
     * @return - New person details to be saved
     */
    @PostMapping
    public PersonDTO addPerson(@RequestBody PersonDTO personDTO) {
        return personInformationService.addPerson(personDTO);
    }

}
