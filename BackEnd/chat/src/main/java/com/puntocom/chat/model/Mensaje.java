package com.puntocom.chat.model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mensaje;
    @ManyToOne
    @JoinColumn (name="id_persona_remitente", referencedColumnName = "id")
    private Persona usuarioremitente;
    @ManyToOne
    @JoinColumn (name="id_persona_destinatario", referencedColumnName = "id")
    private Persona usuariodestinatario;
    private Date fechaenviado;
    private Date fechaleido;
    private Boolean leido;

    public Mensaje() {

    }

    public Mensaje(String mensaje, Persona usuarioremitente, Persona usuariodestinatario, Date fechaenviado, Date fechaleido, Boolean leido) {
        this.mensaje = mensaje;
        this.usuarioremitente = usuarioremitente;
        this.usuariodestinatario = usuariodestinatario;
        this.fechaenviado = fechaenviado;
        this.fechaleido = fechaleido;
        this.leido = leido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
