package com.pillpal.api.controller;

import com.pillpal.api.model.Medicamentos;
import com.pillpal.api.service.MedicamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentosController {

    @Autowired
    private MedicamentosService medicamentosService;

    // Create
    @PostMapping
    public Medicamentos criarMedicamento(@RequestBody Medicamentos medicamento) {
        return medicamentosService.criarMedicamentos(medicamento);
    }

    // Read
    @GetMapping("/{id}")
    public ResponseEntity<Medicamentos> buscarPorId(@PathVariable Long id) {
        return medicamentosService.buscarPorIdOptional(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Medicamentos> listarTodos() {
        return medicamentosService.listarTodos();
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Medicamentos> atualizarMedicamento(@PathVariable Long id, @RequestBody Medicamentos medicamento) {
        if (!medicamentosService.buscarPorIdOptional(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        medicamento.setId(id);
        return ResponseEntity.ok(medicamentosService.AtualizarMedicamentos(medicamento));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMedicamento(@PathVariable Long id) {
        if (!medicamentosService.buscarPorIdOptional(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        medicamentosService.deletarPorId(id);
        return ResponseEntity.ok().build();
    }
}
