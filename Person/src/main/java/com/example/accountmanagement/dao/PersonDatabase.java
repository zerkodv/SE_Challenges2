package com.example.accountmanagement.dao;

import com.example.accountmanagement.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDatabase extends JpaRepository<Person, Long> {
}
