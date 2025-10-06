
package com.example.erp.service;

import com.example.erp.model.Inventory;
import com.example.erp.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    private final InventoryRepository repo;
    public InventoryService(InventoryRepository repo) { this.repo = repo; }

    public List<Inventory> findAll() { return repo.findAll(); }
    public Optional<Inventory> findById(Long id) { return repo.findById(id); }
    public Inventory save(Inventory inv) { return repo.save(inv); }
    public void delete(Inventory inv) { repo.delete(inv); }
}
