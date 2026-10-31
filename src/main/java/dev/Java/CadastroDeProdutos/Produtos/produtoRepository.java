package dev.Java.CadastroDeProdutos.Produtos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface produtoRepository extends JpaRepository<ProdutoModel,Long> {
}
