package com.example.EJ2_Crud_DTO.content.Person.application.mappers;

import com.example.EJ2_Crud_DTO.content.Person.domain.Persona;
import com.example.EJ2_Crud_DTO.content.Person.infrastructure.controller.dto.input.PersonaInputDTO;
import com.example.EJ2_Crud_DTO.content.Person.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface PersonaMapper {

/* En caso de que el DTO y la entidad tengas campos con nombres y/o tipos diferentes, se debe usar el @Mapping para
    "castearlos".
    @Mappings({
            @Mapping(source = "x", target = "x");
    })*/


    //INPUT MAPPING
    Persona personaInputDTOToPersona(PersonaInputDTO personaInputDTO);
    PersonaInputDTO personaToPersonaInputDTO(Persona persona);

    //OUTPUT MAPPING
    Persona personaOutputDTOToPersona(PersonaOutputDTO personaOutputDTO);
    PersonaOutputDTO personaToPersonaOutputDTO(Persona persona);
}
