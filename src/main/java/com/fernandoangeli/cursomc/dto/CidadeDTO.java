package com.fernandoangeli.cursomc.dto;

import com.fernandoangeli.cursomc.domain.Cidade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeDTO {

    private Integer id;
    private String nome;

    public CidadeDTO(){
    }

    public CidadeDTO(Cidade obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
    }
}
