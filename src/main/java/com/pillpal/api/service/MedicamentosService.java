package com.pillpal.api.service;

import com.pillpal.api.model.Medicamentos;
import com.pillpal.api.repository.PillpalRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentosService {
    @Autowired
    private PillpalRepository pillpalRepository;

    //Create
    public Medicamentos criarMedicamentos(Medicamentos medicamentos){
        return pillpalRepository.save(medicamentos);
    }

    //Read
    public Optional<Medicamentos> buscarPorIdOptional(Long id){
        return pillpalRepository.findById(id);
    }

    public List<Medicamentos> listarTodos(){
        return pillpalRepository.findAll();
    }

    //Update
    public Medicamentos AtualizarMedicamentos(Medicamentos medicamentos){
        return pillpalRepository.save(medicamentos);
    }

    //Delete
    public void deletarPorId(Long id){
        pillpalRepository.deleteById(id);
    }
}
