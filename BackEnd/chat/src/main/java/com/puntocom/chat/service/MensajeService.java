package com.puntocom.chat.service;

import com.puntocom.chat.model.Mensaje;
import com.puntocom.chat.model.Persona;
import com.puntocom.chat.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeService{

    @Autowired
    private MensajeRepository mensajeRepository;

    public List<Mensaje> list(){
        return mensajeRepository.findAll();
    }

}
