package com.fernandoangeli.cursomc.dto;

import com.fernandoangeli.cursomc.domain.Categoria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO {

    private Integer id;
    private String nome;

    public CategoriaDTO(){
    }

    public CategoriaDTO(Categoria obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
    }

}
