package dev.Java.CadastroDeProdutos.Produtos;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {


    private produtoRepository produtoRepository;
    private ProdutoMapper produtoMapper;

    public ProdutoService(produtoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    // Listar todos os meus produtos
    public List<ProdutoDTO>  listarProdutos() {
        List<ProdutoModel> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(produtoMapper::map)
                .collect(Collectors.toList());


    }

    // Adicionar um produto
    public ProdutoDTO adcionarProduto(ProdutoDTO produtoDTO) {
        ProdutoModel produto = produtoMapper.map(produtoDTO);
        produto = produtoRepository.save(produto);
        return produtoMapper.map(produto);

    }

    // listar produto por id
    public ProdutoDTO listarProdutosPorID(Long id) {
        Optional<ProdutoModel> produto = produtoRepository.findById(id);
        return produto.map(produtoMapper::map)
                .orElseThrow(() -> new ProdutoNaoEncontradoException("Informo que esse ID não existe"));


    }

    // Altualizar informacoes do produto
    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO  produtoDTO) {
        Optional<ProdutoModel> produtoExistente = produtoRepository.findById(id);
        if (produtoExistente.isPresent()) {
            ProdutoModel produtoAtualizado = produtoMapper.map(produtoDTO);
            produtoAtualizado.setId(id);
            ProdutoModel produtoSalvo = produtoRepository.save(produtoAtualizado);
            return produtoMapper.map(produtoSalvo);
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
