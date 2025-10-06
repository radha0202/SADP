package com.example.erp.controller;

import com.example.erp.model.Finance;
import com.example.erp.service.FinanceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/finance")
public class FinanceController {
    private final FinanceService service;
    public FinanceController(FinanceService service) { this.service = service; }

    @GetMapping
    public List<Finance> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Finance> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Finance> create(@Valid @RequestBody Finance fin) {
        Finance saved = service.save(fin);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Finance> update(@PathVariable Long id, @Valid @RequestBody Finance updated) {
        return service.findById(id).map(f -> {
            f.setTransactionType(updated.getTransactionType());
            f.setDescription(updated.getDescription());
            f.setAmount(updated.getAmount());
            Finance saved = service.save(f);
            return ResponseEntity.ok(saved);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.findById(id).map(f -> {
            service.delete(f);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
