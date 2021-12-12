package com.exepinero.MeetingMakerAPI.controllers;

import com.exepinero.MeetingMakerAPI.exception.ResourceNotFoundException;
import com.exepinero.MeetingMakerAPI.model.Evento;
import com.exepinero.MeetingMakerAPI.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
public class EventoController {


    @Autowired
    EventoService eventoService;


    /**
     * Data para testing...
     */
    @GetMapping("test")
    public void testData(){

        Evento evento1 = new Evento();
        evento1.setCreador("Exequiel");
        evento1.setFecha(LocalDate.now());
        //evento1.setId(1);

        List<String> invitados = new ArrayList<>();
        invitados.add("Nicolas");
        invitados.add("Viviana");
        invitados.add("Zaira");

        evento1.setNombreEvento("Fiesta de cumpleaños");
        evento1.setSummary("Los invito a mi cumpleaños que se festejará en 357 días");

        evento1.setParticipantes(invitados);

        eventoService.nuevoEvento(evento1);
    }

    /**
     * Metodos HTTP para CRUD
     *
     */

    @GetMapping
    public List<Evento> getEventos(){
        List<Evento> eventos = eventoService.getEventos();
        return eventos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEvento(@PathVariable("id") Integer id) throws ResourceNotFoundException {

        Evento evento = eventoService.getEvento(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe evento con id: "+id));

        return new ResponseEntity<>(evento,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Evento> crearEvento(@RequestBody @Valid Evento evento){

        eventoService.nuevoEvento(evento);
        return new ResponseEntity<>(evento, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public void deleteEvento(@PathVariable("id") Integer id){
        Optional<Evento> evento = eventoService.getEvento(id);
        if(evento.isPresent()){
            eventoService.deleteEvento(id);
        }
    }

    @PutMapping("/{id}")
    public Evento updateEvento(@PathVariable("id") Integer id, @RequestBody @Valid Evento evento){
        Optional<Evento> eventoEnDB = eventoService.getEvento(id);
        if(eventoEnDB.isPresent()){
            evento.setId(id);
            return eventoService.updateEvento(evento);
        }
        return null;
    }

}
