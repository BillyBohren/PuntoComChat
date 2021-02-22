package com.puntocom.chat.service;


import com.puntocom.chat.model.Persona;
import com.puntocom.chat.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public List<Persona> list(){
        return personaRepository.findAll();
    }

    public Optional<Persona> getOne(int id){
        return personaRepository.findById(id);
    }

    public Optional<Persona> getByUsuario(String usuario){
        return personaRepository.findByUsuario(usuario);
    }

    public void  save(Persona persona){
        personaRepository.save(persona);
    }

    public void delete(int id){
        personaRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return personaRepository.existsById(id);
    }


}
