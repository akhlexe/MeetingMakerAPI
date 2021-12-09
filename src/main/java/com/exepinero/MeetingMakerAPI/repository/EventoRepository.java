package com.exepinero.MeetingMakerAPI.repository;

import com.exepinero.MeetingMakerAPI.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento,Integer> {

    Evento findByNombreEvento(String nombreEvento);
}
