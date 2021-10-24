package com.db.person.controller;

import com.db.person.model.dto.PersonDTO;
import com.db.person.service.PersonInformationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = PersonInformationController.class)
class PersonInformationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonInformationService personInformationService;

    @DirtiesContext
    @Test
    void getAllPersons() throws Exception {
        Mockito.when(personInformationService.findAll()).thenReturn(Collections.singletonList(getPerson()));

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/person")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":-1,\"name\":\"Surya\",\"age\":25,\"contactNumber\":761234,\"address\":\"Pune\",\"pinCode\":400012}]"))
                .andReturn();


    }

    @DirtiesContext
    @Test
    void addPerson() throws Exception {
        Mockito.when(personInformationService.addPerson(getPerson())).thenReturn(getPerson());

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/person")
                .content(new ObjectMapper().writeValueAsString(getPerson()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":-1,\"name\":\"Surya\",\"age\":25,\"contactNumber\":761234,\"address\":\"Pune\",\"pinCode\":400012}"))
                .andReturn();
    }

    private PersonDTO getPerson() {
        return new PersonDTO(-1L, "Surya", 25, 761234L, "Pune", 400012);
    }

}