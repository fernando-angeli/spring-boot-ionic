package com.fernandoangeli.cursomc.services;

import com.fernandoangeli.cursomc.domain.Estado;
import com.fernandoangeli.cursomc.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repo;

    public List<Estado> findAll(){
        return repo.findAllByOrderByNome();
    }
}
