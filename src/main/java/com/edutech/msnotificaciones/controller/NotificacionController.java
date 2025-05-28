package com.edutech.msnotificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.msnotificaciones.model.Notificacion;
import com.edutech.msnotificaciones.service.NotificacionService;

@RestController
@RequestMapping("api/v1/notificaciones")
public class NotificacionController {
    @Autowired
    private NotificacionService notificacionService;

    @GetMapping
    public ResponseEntity<List<Notificacion>> getAll() {
        List<Notificacion> notificaciones = notificacionService.findAll();
        if (!notificaciones.isEmpty()) {
            return new ResponseEntity<>(notificaciones, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{idNotificacion}")
    public ResponseEntity<Notificacion> readNotificacion(@PathVariable int idNotificacion) {
        Notificacion buscarNotificacion = notificacionService.findById(idNotificacion);
        if(buscarNotificacion != null) {
            return new ResponseEntity<>(buscarNotificacion, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Notificacion> postReporte(@RequestBody Notificacion notificacion) {
        Notificacion buscar = notificacionService.findById(notificacion.getIdNotificacion());
        if(buscar == null) {
            return new ResponseEntity<>(notificacionService.save(notificacion), HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/{idNotificacion}")
    public ResponseEntity<Notificacion> updateNotificacion(@PathVariable int idNotificacion, @RequestBody Notificacion notificacion) {
        if(notificacionService.update(idNotificacion, notificacion)) {
            return new ResponseEntity<>(notificacion, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idNotificacion}") 
    public ResponseEntity<?> deleteNotificacion(@PathVariable int idNotificacion) {
        Notificacion buscar = notificacionService.findById(idNotificacion);
        if(buscar != null) {
            notificacionService.deleteById(idNotificacion);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
