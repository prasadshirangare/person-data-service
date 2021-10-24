package com.db.person.service;

import com.db.person.model.dto.PersonDTO;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@Import(PersonInformationService.class)
class PersonInformationServiceTest {

    @Autowired
    private PersonInformationService unitToTest;

    @Test
    void findAll() {
        List<PersonDTO> personList = unitToTest.findAll();
        assertThat(personList, Matchers.hasSize(3));
    }

    @DirtiesContext
    @Test
    void addPerson() {
        PersonDTO personDTO = new PersonDTO(-1L, "Surya", 25, 761234L, "Pune", 400012);
        PersonDTO savedPerson = unitToTest.addPerson(personDTO);
        List<PersonDTO> personList = unitToTest.findAll();
        assertThat(personList, Matchers.hasSize(4));
    }


}