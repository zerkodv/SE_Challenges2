package com.example.accountmanagement;

import com.example.accountmanagement.controller.PersonController;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class AccountManagementApplicationTests {

    @Autowired
    PersonController personController;

    @Test
    void contextLoads() {
        Assertions.assertThat(personController);
    }

}
