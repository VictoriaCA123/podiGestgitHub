package com.podiGest.backend.model;


import lombok.Data; // Importa las anotaciones de Lombok

@Data // Genera automáticamente getters, setters, toString, etc.
public class Item {
    private int id;
    private String nombre;
    private String autor;
    private int duracion; // Duración en minutos
}