package com.fernandoangeli.cursomc.services;

import com.fernandoangeli.cursomc.domain.Cliente;
import com.fernandoangeli.cursomc.domain.Pedido;
import com.fernandoangeli.cursomc.repository.PedidoRepository;
import com.fernandoangeli.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido buscar(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

}