package com.example.EJ2_Crud_DTO.content.Person.application;

import com.example.EJ2_Crud_DTO.content.Person.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaService {

    public List<PersonaOutputDTO> getAll();
}
