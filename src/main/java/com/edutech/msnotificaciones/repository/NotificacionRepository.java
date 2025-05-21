package com.edutech.msnotificaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.msnotificaciones.model.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {
    
    List<Notificacion> findAll();

    Notificacion findById(int idNotificacion);

    @SuppressWarnings("unchecked")
    Notificacion save(Notificacion notificacion);

    void deleteById(int idNotificacion);
}
