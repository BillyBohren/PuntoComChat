package com.puntocom.chat.repository;

import com.puntocom.chat.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository  extends JpaRepository<Persona, Integer> {

    Optional<Persona> findByUsuario(String usuario);

}
