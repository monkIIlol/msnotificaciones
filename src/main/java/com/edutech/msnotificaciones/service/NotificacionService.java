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

    public void deleteById(int idNotificacion) {
        notificacionRepository.deleteById(idNotificacion);
    }

    public boolean update(int idNotificacion, Notificacion notificacion) {
        Notificacion not = notificacionRepository.findById(idNotificacion);
        if(not != null) {
            not.setIdNotificacion(notificacion.getIdNotificacion());
            not.setCanal(notificacion.getCanal());
            not.setTipoEvento(notificacion.getTipoEvento());
            not.setTitulo(notificacion.getTitulo());
            not.setMensaje(notificacion.getMensaje());
            not.setFechaEvento(notificacion.getFechaEvento());
            not.setEstado(notificacion.getEstado());

            notificacionRepository.save(not);
            return true;
        }else{
            return false;
        }
    }
}
