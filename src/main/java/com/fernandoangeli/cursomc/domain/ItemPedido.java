package com.fernandoangeli.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

@Getter
@Setter
@Entity
public class ItemPedido {

    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public ItemPedido(){
    }

    public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
        super();
        id.setPedido(pedido);
        id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public double getSubTotal(){
        return (preco - desconto) * quantidade;
    }

    @JsonIgnore
    public Pedido getPedido(){
        return id.getPedido();
    }

    public void setPedido(Pedido pedido){
        id.setPedido(pedido);
    }

    public Produto getProduto(){
        return id.getProduto();
    }

    public void setProduto(Produto produto){
        id.setProduto(produto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        final StringBuilder sb = new StringBuilder();
        sb.append(getProduto().getNome());
        sb.append(", Qte: ");
        sb.append(getQuantidade());
        sb.append(", Preço unitário: ");
        sb.append(nf.format(getPreco()));
        sb.append(", Subtotal: ");
        sb.append(nf.format(getSubTotal()));
        sb.append("\n");
        return sb.toString();
    }
}
