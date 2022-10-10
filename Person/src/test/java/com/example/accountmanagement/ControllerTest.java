package com.example.accountmanagement;


import com.example.accountmanagement.controller.PersonController;
import com.example.accountmanagement.dao.PersonDatabase;
import com.example.accountmanagement.model.Person;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.List;

import static java.lang.reflect.Array.get;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PersonController.class)
public class ControllerTest {

    @MockBean
    PersonDatabase personDatabase;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testfindAll() throws Exception {
        Person person = new Person(03L,"John Book","Jakarta, Indonesia",3000,35, "Engineer", "js@email.com", 3234564);
        List<Person> persons = Arrays.asList(person);



        Mockito.when(personDatabase.findAll()).thenReturn(persons);

        mockMvc.perform((RequestBuilder) get("/persons",1))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", Matchers.hasSize(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].name", Matchers.is("John Book")));
    }


}

