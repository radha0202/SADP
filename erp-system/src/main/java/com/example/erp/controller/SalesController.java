package com.example.erp.controller;

import com.example.erp.model.Sale;
import com.example.erp.service.SalesService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {
    private final SalesService service;
    public SalesController(SalesService service) { this.service = service; }

    @GetMapping
    public List<Sale> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sale> create(@Valid @RequestBody Sale sale) {
        Sale saved = service.save(sale);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sale> update(@PathVariable Long id, @Valid @RequestBody Sale updated) {
        return service.findById(id).map(s -> {
            s.setCustomerName(updated.getCustomerName());
            s.setItemName(updated.getItemName());
            s.setQuantity(updated.getQuantity());
            s.setTotalAmount(updated.getTotalAmount());
            Sale saved = service.save(s);
            return ResponseEntity.ok(saved);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.findById(id).map(s -> {
            service.delete(s);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
