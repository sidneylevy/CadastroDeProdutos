package dev.Java.CadastroDeProdutos.Produtos;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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



    // Adicionar um produto
    public ProdutoModel  adcionarProduto(ProdutoModel produto) {
        return   produtoRepository.save(produto);
    }

    // listar produto por id
    public ProdutoModel listarProdutosPorID(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException("Esse id não esta cadastrado"));
    }
}
