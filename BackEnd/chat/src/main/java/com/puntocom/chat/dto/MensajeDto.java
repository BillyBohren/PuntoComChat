package com.puntocom.chat.dto;

import com.puntocom.chat.model.Persona;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class MensajeDto {

    @NotBlank
    private String mensaje;
    @NotBlank
    private Persona usuarioremitente;
    @NotBlank
    private Persona usuariodestinatario;
    @NotBlank
    private Date fechaenviado;
    @NotBlank
    private Date fechaleido;
    @NotBlank
    private Boolean leido;

    public MensajeDto() {
    }

    public MensajeDto(@NotBlank String mensaje, @NotBlank Persona usuarioremitente, @NotBlank Persona usuariodestinatario, @NotBlank Date fechaenviado, @NotBlank Date fechaleido, @NotBlank Boolean leido) {
        this.mensaje = mensaje;
        this.usuarioremitente = usuarioremitente;
        this.usuariodestinatario = usuariodestinatario;
        this.fechaenviado = fechaenviado;
        this.fechaleido = fechaleido;
        this.leido = leido;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Persona getUsuarioremitente() {
        return usuarioremitente;
    }

    public void setUsuarioremitente(Persona usuarioremitente) {
        this.usuarioremitente = usuarioremitente;
    }

    public Persona getUsuariodestinatario() {
        return usuariodestinatario;
    }

    public void setUsuariodestinatario(Persona usuariodestinatario) {
        this.usuariodestinatario = usuariodestinatario;
    }

    public Date getFechaenviado() {
        return fechaenviado;
    }

    public void setFechaenviado(Date fechaenviado) {
        this.fechaenviado = fechaenviado;
    }

    public Date getFechaleido() {
        return fechaleido;
    }

    public void setFechaleido(Date fechaleido) {
        this.fechaleido = fechaleido;
    }

    public Boolean getLeido() {
        return leido;
    }

    public void setLeido(Boolean leido) {
        this.leido = leido;
    }




}
