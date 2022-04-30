package com.fernandoangeli.cursomc.services;

import com.fernandoangeli.cursomc.domain.Cidade;
import com.fernandoangeli.cursomc.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repo;

    public List<Cidade> findByEstado(Integer estadoId){
        return repo.findCidades(estadoId);
    }
}
