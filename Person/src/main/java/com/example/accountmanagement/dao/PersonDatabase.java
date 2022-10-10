package com.example.accountmanagement.dao;

import com.example.accountmanagement.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDatabase extends JpaRepository<Person, Long> {
}
