package dev.Java.CadastroDeProdutos.Produtos;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {


    private produtoRepository produtoRepository;

    public ProdutoService(produtoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // Listar todos os meus produtos
    public List<ProdutoModel>  listarProdutos() {
            return  produtoRepository.findAll();
    }

    // listar produto por id

    // Adicionar um produto
    public ProdutoModel  adcionarProduto(ProdutoModel produto) {
        return   produtoRepository.save(produto);
    }

    public ProdutoModel listarProdutosPorID(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }
}
