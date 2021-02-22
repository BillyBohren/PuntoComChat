package com.puntocom.chat.repository;

import com.puntocom.chat.model.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Integer> {
    Optional<Mensaje> findByUsuariodestinatario(int idusuario);
}
