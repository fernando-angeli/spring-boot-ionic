package com.fernandoangeli.cursomc.domain;

import com.fernandoangeli.cursomc.domain.enums.EstadoPagamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@Entity
public class PagamentoComBoleto extends Pagamento{

    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoComBoleto(){
    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(id, estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }
}
