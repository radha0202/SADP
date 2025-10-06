package com.example.erp.controller;

import com.example.erp.model.Inventory;
import com.example.erp.service.InventoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService service;
    public InventoryController(InventoryService service) { this.service = service; }

    @GetMapping
    public List<Inventory> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Inventory> create(@Valid @RequestBody Inventory inv) {
        Inventory saved = service.save(inv);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> update(@PathVariable Long id, @Valid @RequestBody Inventory updated) {
        return service.findById(id).map(inv -> {
            inv.setItemName(updated.getItemName());
            inv.setQuantity(updated.getQuantity());
            inv.setPrice(updated.getPrice());
            Inventory saved = service.save(inv);
            return ResponseEntity.ok(saved);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.findById(id).map(inv -> {
            service.delete(inv);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
