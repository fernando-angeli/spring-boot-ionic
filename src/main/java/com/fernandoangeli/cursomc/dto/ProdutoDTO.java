package com.fernandoangeli.cursomc.dto;

import com.fernandoangeli.cursomc.domain.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {

    private Integer id;
    private String nome;
    private Double preco;

    public ProdutoDTO(){
    }

    public ProdutoDTO(Produto obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.preco = obj.getPreco();
    }

}
