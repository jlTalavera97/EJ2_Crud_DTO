package com.example.EJ2_Crud_DTO.content.Person.application;

import com.example.EJ2_Crud_DTO.content.Person.application.mappers.PersonaMapper;
import com.example.EJ2_Crud_DTO.content.Person.domain.Persona;
import com.example.EJ2_Crud_DTO.content.Person.infrastructure.controller.dto.input.PersonaInputDTO;
import com.example.EJ2_Crud_DTO.content.Person.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl {

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    PersonaMapper personaMapper;

    public PersonaOutputDTO converToDto(Persona p) {
        return personaMapper.personaToPersonaOutputDTO(p);
    }

    public List<PersonaOutputDTO> getAll() {
        return personaRepository.findAll()
                .stream()
                .map(this::converToDto)
                .collect(Collectors.toList());
    }

//    public List<PersonaOutputDTO> getAll(){
//
//        List<Persona> getPersonas = personaRepository.findAll();
//
//        return getPersonas.stream()
//                .map( x -> personaMapper.personaToPersonaOutputDTO(new Persona()))
//                .collect(Collectors.toList());
//    }

    public String addPersona(PersonaInputDTO personaInputDTO){
        Persona newPersona = personaMapper.personaInputDTOToPersona(personaInputDTO);

        if(newPersona.getUsuario().length() >= 5){
            personaRepository.save(newPersona);
            return "Persona con id "+newPersona.getId_persona()+" añadida correctamente.";
        }
        return "No se ha podido añadir a la persona";
    }

    public String deletePersona(Integer id){

        if(personaRepository.findById(id)!=null){
            personaRepository.deleteById(id);
        }
        return "Persona con id "+id+" se ha borrado con éxito";
    }

    public String editPersona(int id, PersonaInputDTO personaInputDto) {
        Persona persona = personaRepository.getById(id);
        Persona editedPersona = personaMapper.personaInputDTOToPersona(personaInputDto);

        if (personaInputDto.getUsuario() != null && personaInputDto.getUsuario().length() >= 5) {
            persona.setUsuario(editedPersona.getUsuario());
        }
        if (personaInputDto.getPassword() != null) {
            persona.setPassword(editedPersona.getPassword());
        }
        if (personaInputDto.getName() != null) {
            persona.setName(editedPersona.getName());
        }
        if (personaInputDto.getSurname() != null) {
            persona.setSurname(editedPersona.getSurname());
        }
        if (personaInputDto.getCompany_email() != null) {
            persona.setCompany_email(editedPersona.getCompany_email());
        }
        if (personaInputDto.getPersonal_email() != null) {
            persona.setPersonal_email(editedPersona.getPersonal_email());
        }
        if (personaInputDto.getCity() != null) {
            persona.setCity(editedPersona.getCity());
        }
        if (personaInputDto.getActive() != null) {
            persona.setActive(editedPersona.getActive());
        }
        if (personaInputDto.getCreatedDate() != null) {
            persona.setCreated_date(editedPersona.getCreated_date());
        }
        if (personaInputDto.getImagen_url() != null) {
            persona.setImagen_url(editedPersona.getImagen_url());
        }
        if (personaInputDto.getTermiantionDate() != null) {
            persona.setTermination_date(editedPersona.getTermination_date());
        }

        personaRepository.save(persona);

        return "persona con id "+id+" editada.";
    }

}
