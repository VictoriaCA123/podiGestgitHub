package com.podiGest.backend.model;

import com.podiGest.backend.model.Item;
import com.podiGest.backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/items") // La URL base de esta API será /api/items
public class ItemController {

    @Autowired // Spring inyecta automáticamente el servicio
    private ItemService itemService;

    @GetMapping // Maneja peticiones GET a /api/items
    public List<Item> getAllItems() {
        return itemService.findAll(); // Llama al servicio para obtener los datos
    }
}