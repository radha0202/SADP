
package com.example.erp.service;

import com.example.erp.model.Finance;
import com.example.erp.repository.FinanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinanceService {
    private final FinanceRepository repo;
    public FinanceService(FinanceRepository repo) { this.repo = repo; }

    public List<Finance> findAll() { return repo.findAll(); }
    public Optional<Finance> findById(Long id) { return repo.findById(id); }
    public Finance save(Finance f) { return repo.save(f); }
    public void delete(Finance f) { repo.delete(f); }
}
