package com.puntocom.chat.rest;

import com.puntocom.chat.dto.PersonaDto;
import com.puntocom.chat.dto.Mensaje;
import com.puntocom.chat.model.Persona;
import com.puntocom.chat.service.PersonaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "*")
public class PersonaREST {

    @Autowired
    private PersonaService personaService;


    @GetMapping("/lista")
    private ResponseEntity<List<Persona>> getAllPersonas() {
        List<Persona> list;
        list = personaService.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @GetMapping("/detalleusuario/{usuario}")
    public ResponseEntity<Persona> getByUsuario(@PathVariable("usuario") String usuario){
        if(personaService.getByUsuario(usuario) == null)
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getByUsuario(usuario).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PersonaDto personaDto){
        if(StringUtils.isBlank(personaDto.getUsuario()))
            return new ResponseEntity(new Mensaje("el usuario es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getPassword()))
            return new ResponseEntity(new Mensaje("el password es obligatorio"), HttpStatus.BAD_REQUEST);
        if(personaService.getByUsuario(personaDto.getUsuario()).isPresent())
            return new ResponseEntity(new Mensaje("ese usuario ya existe"), HttpStatus.BAD_REQUEST);
        Persona persona = new Persona(personaDto.getUsuario(), personaDto.getPassword(), personaDto.getNombre());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("persona registrada"), HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody PersonaDto personaDto){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);

        if(personaService.getByUsuario(personaDto.getUsuario()).isPresent() && personaService.getByUsuario(personaDto.getUsuario()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese usuario ya existe"), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(personaDto.getUsuario()))
            return new ResponseEntity(new Mensaje("el usuario es obligatorio"), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(personaDto.getPassword()))
            return new ResponseEntity(new Mensaje("el password es obligatorio"), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Persona persona = personaService.getOne(id).get();
        persona.setNombre(personaDto.getNombre());
        persona.setUsuario(personaDto.getUsuario());
        persona.setPassword(personaDto.getPassword());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }

}
