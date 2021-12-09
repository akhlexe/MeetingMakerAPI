package com.exepinero.MeetingMakerAPI.controllers;

import com.exepinero.MeetingMakerAPI.model.Evento;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventosController {


    @GetMapping
    public Evento homepage(){

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

        return evento1;
    }

}
