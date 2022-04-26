package com.fernandoangeli.cursomc.repository;

import com.fernandoangeli.cursomc.domain.Categoria;
import com.fernandoangeli.cursomc.domain.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    // Consulta Query pode ser usando nome search (por exemplo) para este método
    // @Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
    // O método está fazendo a consulta através do nome montado na consulta
    @Transactional(readOnly = true)
    // Com a anotação Transaction é realizada apenas uma consulta, não é necessário fazer transação com o BD
    Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);

}
