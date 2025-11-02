package com.podiGest.backend.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.podiGest.backend.model.Item;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service // Indica que esta clase maneja la lógica de negocio
public class ItemService {

    // Lista en memoria que simula la base de datos
    private final List<Item> items;

    // El constructor carga los datos del JSON al iniciar el servicio
    public ItemService() {
        // Usamos ObjectMapper para leer el archivo JSON
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Item>> typeReference = new TypeReference<>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/items.json");

        try {
            items = mapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            // Si hay un error, inicializa una lista vacía
            throw new RuntimeException("No se pudo cargar el archivo items.json: " + e.getMessage());
        }
    }

    // Método para obtener todos los items (nuestra primera ruta API)
    public List<Item> findAll() {
        return items;
    }
}