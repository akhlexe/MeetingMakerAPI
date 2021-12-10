package com.exepinero.MeetingMakerAPI.service;

import com.exepinero.MeetingMakerAPI.model.Evento;
import com.exepinero.MeetingMakerAPI.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    EventoRepository eventoRepository;


    public Evento getEvento(Integer id) {
        Optional<Evento> evento= eventoRepository.findById(id);
        return evento.orElse(null);
    }

    public void nuevoEvento(Evento evento) {
        eventoRepository.save(evento);
    }

    public List<Evento> getEventos() {
        List<Evento> allEventos = eventoRepository.findAll();
        return allEventos;
    }

    public void deleteEvento(Integer id) {
        Optional<Evento> optionalEvento = eventoRepository.findById(id);
        optionalEvento.ifPresent(evento -> eventoRepository.delete(evento));
    }
}
