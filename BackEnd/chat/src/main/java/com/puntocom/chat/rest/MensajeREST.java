package com.puntocom.chat.rest;


import com.puntocom.chat.model.Mensaje;
import com.puntocom.chat.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensajes/")
@CrossOrigin(origins = "*")
public class MensajeREST {

    @Autowired
    private MensajeService mensajeService;

    @GetMapping("/lista/{usuario}")
    private ResponseEntity<List<Mensaje>> getMensajesUsuario(@PathVariable("usuario") int usuario) {
        return  null;
        //falta
    }

}
