package com.example.EJ2_Crud_DTO.content.Person.application;

import com.example.EJ2_Crud_DTO.content.Person.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
