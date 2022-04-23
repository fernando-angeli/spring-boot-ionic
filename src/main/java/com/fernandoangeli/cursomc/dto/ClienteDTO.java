package com.fernandoangeli.cursomc.dto;

import com.fernandoangeli.cursomc.domain.Cliente;
import com.fernandoangeli.cursomc.services.validation.ClienteUpdate;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ClienteUpdate
public class ClienteDTO {

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min=5, max=120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    public ClienteDTO(){
    }

    public ClienteDTO(Cliente obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
    }
}
