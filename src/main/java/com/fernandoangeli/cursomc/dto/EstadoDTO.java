package com.fernandoangeli.cursomc.dto;

import com.fernandoangeli.cursomc.domain.Estado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoDTO {

    private Integer id;
    private String nome;

    public EstadoDTO(){
    }

    public EstadoDTO(Estado obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
    }
}
