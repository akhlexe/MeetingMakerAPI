package com.exepinero.MeetingMakerAPI.model;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "El creador no puede ser nulo")
    @Size(min = 1, max = 100, message = "Maximo 100 caracteres")
    private String creador;

    @NotNull(message = "Todo evento necesita tener una fecha pactada.")
    @Future
    private LocalDate fecha;

    @NotNull(message = "El nombre del evento no puede ser nulo")
    @Size(min = 1, max = 100)
    private String nombreEvento;
    private String summary;

    @ElementCollection
    @JoinTable(name = "participantesPorEvento")
    private List<String> participantes;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }
}
