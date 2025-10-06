
package com.example.erp.service;

import com.example.erp.model.Sale;
import com.example.erp.repository.SalesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesService {
    private final SalesRepository repo;
    public SalesService(SalesRepository repo) { this.repo = repo; }

    public List<Sale> findAll() { return repo.findAll(); }
    public Optional<Sale> findById(Long id) { return repo.findById(id); }
    public Sale save(Sale s) { return repo.save(s); }
    public void delete(Sale s) { repo.delete(s); }
}
