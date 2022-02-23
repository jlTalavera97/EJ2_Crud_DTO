package com.example.EJ2_Crud_DTO.content.Person.infrastructure.controller;

import com.example.EJ2_Crud_DTO.content.Person.application.PersonaService;
import com.example.EJ2_Crud_DTO.content.Person.application.PersonaServiceImpl;
import com.example.EJ2_Crud_DTO.content.Person.infrastructure.controller.dto.input.PersonaInputDTO;
import com.example.EJ2_Crud_DTO.content.Person.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class PersonController implements PersonaService {

    @Autowired
    PersonaServiceImpl personaServiceImpl;

    @GetMapping("/getAll")
    public List<PersonaOutputDTO> getAll(){
        return personaServiceImpl.getAll();
    }

    @PostMapping("/addPerson")
    public String addPersona(@RequestBody PersonaInputDTO personaInputDTO){
        return personaServiceImpl.addPersona(personaInputDTO);
    }

    @DeleteMapping("/deletePerson/{id}")
    public String deletePersona(@PathVariable Integer id){
        return personaServiceImpl.deletePersona(id);
    }

    @PutMapping("/editPerson/{id}")
    public String editPersona(@PathVariable Integer id,@RequestBody PersonaInputDTO personaInputDto){
        return personaServiceImpl.editPersona(id,personaInputDto);
    }




}
