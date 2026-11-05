package dev.Java.CadastroDeProdutos.Produtos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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
    public ProdutoModel criarProduto(@RequestBody ProdutoModel produto) {
        return produtoService.adcionarProduto(produto);}


    // Mostrar todos os produtos (READ)
    @GetMapping("/listarTodos")
    public List<ProdutoModel> listarProduto() {
        return produtoService.listarProdutos();
    }


    // Mostrar produto por id (READ)
    @GetMapping("/listarPorID/{id}")
    public ResponseEntity<?> listarProdutoID(@PathVariable Long id) {
       try {
           ProdutoModel produto = produtoService.listarProdutosPorID(id);
           return ResponseEntity.ok().body(produto);
       }
       catch(ProdutoNaoEncontradoException e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
       }

    }

    // Alterar dados do produto (UPDATE)
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
