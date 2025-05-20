package com.edutech.msnotificaciones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.msnotificaciones.model.Notificacion;
import com.edutech.msnotificaciones.repository.NotificacionRepository;

@Service
public class NotificacionService {
    @Autowired
    private NotificacionRepository notificacionRepository;

    public List<Notificacion> findAll() {
        return notificacionRepository.findAll();
    }
    
    public Notificacion findById(int idNotificacion) {
        return notificacionRepository.findById(idNotificacion);
    }

    public Notificacion save(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }
}
