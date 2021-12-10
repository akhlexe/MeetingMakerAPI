package com.exepinero.MeetingMakerAPI.controllers;

import com.exepinero.MeetingMakerAPI.model.Evento;
import com.exepinero.MeetingMakerAPI.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventosController {


    @Autowired
    EventoService eventoService;


    @GetMapping("test")
    public void testData(){

        Evento evento1 = new Evento();
        evento1.setCreador("Exequiel");
        evento1.setFecha(LocalDate.now());
        evento1.setId(1);

        List<String> invitados = new ArrayList<>();
        invitados.add("Nicolas");
        invitados.add("Viviana");
        invitados.add("Zaira");

        evento1.setNombreEvento("Fiesta de cumpleaños");
        evento1.setSummary("Los invito a mi cumpleaños que se festejará en 357 días");

        evento1.setParticipantes(invitados);

        eventoService.nuevoEvento(evento1);
    }

    @GetMapping("/{id}")
    public Evento getEvento(@PathVariable("id") Integer id){
        return eventoService.getEvento(id);
    }

    @PostMapping
    public void crearEvento(@RequestBody Evento evento){
        eventoService.nuevoEvento(evento);
    }

    @GetMapping
    public List<Evento> getEventos(){
        List<Evento> eventos = eventoService.getEventos();
        return eventos;
    }

    @DeleteMapping("/{id}")
    public void deleteEvento(@PathVariable("id") Integer id){
        eventoService.deleteEvento(id);
    }

}
