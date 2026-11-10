package dev.Java.CadastroDeProdutos.Produtos;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {


    private produtoRepository produtoRepository;
    private ProdutoMapper produtoMapper;

    public ProdutoService(produtoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    // Listar todos os meus produtos
    public List<ProdutoModel>  listarProdutos() {
            return  produtoRepository.findAll();
    }



    // Adicionar um produto
    public ProdutoDTO adcionarProduto(ProdutoDTO produtoDTO) {
        ProdutoModel produto = produtoMapper.map(produtoDTO);
        produto = produtoRepository.save(produto);
        return produtoMapper.map(produto);

    }

    // listar produto por id
    public ProdutoModel listarProdutosPorID(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException("Esse id não esta cadastrado"));
    }

    // Altualizar informacoes do produto
    public ProdutoModel atualizarProduto(Long id, ProdutoModel produtoAtualizado) {
        if(produtoRepository.existsById(id)) {
            produtoAtualizado.setId(id);
            return produtoRepository.save(produtoAtualizado);
        }else {
            System.out.println("Produto não encontrado, verifique se o id esta correto");
        }
        return null;
    }


    // Deletar produto po id
    public ProdutoModel deletarProdutoPorID(Long id) {
        if (produtoRepository.existsById(id)) {
            throw new ProdutoNaoEncontradoException("Esse produto não esta cadastrado");
        }
        else {
          produtoRepository.deleteById(id);
            System.out.println("Produto removido com sucesso");
        }
        return null;
    }
}
