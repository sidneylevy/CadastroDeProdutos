package dev.Java.CadastroDeProdutos.Produtos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    Scanner sc = new Scanner(System.in);


    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Primeira mensagem dessa rota";
    }


    // Adicionar Produto (CREAT)
    @PostMapping("/criar")
    public ProdutoModel criarProduto(@RequestBody ProdutoModel produto) {return produtoService.adcionarProduto(produto);}

    // Mostrar produto por id (READ)
    @GetMapping("/listarTodos")
    public List<ProdutoModel> listarProduto() {
        return produtoService.listarProdutos();
    }

    // Mostrar todos os produtos (READ)
    @GetMapping("/listarPorID/{id}")
    public ProdutoModel listarProdutoID(@PathVariable Long id) {return produtoService.listarProdutosPorID(id);
    }

    // Alterar da dados do produto (UPDATE)
    @PutMapping("/alterarID")
    public String alterarProdutoID() {
        return "Alterar o produto po id";
    }

    // Deletar produto (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarProdutoID() {
        return "Deletar o produto po id";
    }

    ;
}
