package com.edutech.msnotificaciones.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notificaciones")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int idNotificacion;

    @Column() //Interaccion
    private int idUsuarioDestino;

    @Column(length = 50, nullable = false)
    private String canal;

    @Column(length = 50, nullable = false)
    private String tipoEvento;

    @Column(length = 50, nullable = false)
    private String titulo;

    @Column(length = 500, nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private LocalDate fechaEvento;

    @Column(length = 50, nullable = false)
    private String estado;

}
