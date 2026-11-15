package dev.Java.CadastroDeProdutos.Produtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.Java.CadastroDeProdutos.Fornecedor.FornecedorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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

    // Adicionar Produto (CREAT)
    @PostMapping("/criar")
    public ProdutoDTO criarProduto(@RequestBody ProdutoDTO produto) {
        return produtoService.adcionarProduto(produto);}


    // Mostrar todos os produtos (READ)
    @GetMapping("/listarTodos")
    public List<ProdutoDTO> listarProduto() {
        return produtoService.listarProdutos();
    }


    // Mostrar produto por id (READ)
    @GetMapping("/listarPorID/{id}")
    public ResponseEntity<?> listarProdutoID(@PathVariable Long id) {
       try {
           ProdutoDTO produto = produtoService.listarProdutosPorID(id);
           return ResponseEntity.ok().body(produto);
       }
       catch(ProdutoNaoEncontradoException e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
       }

    }
    // Alterar dados do produto (UPDATE)
    @PutMapping("/atualizarID/{id}")
    public ResponseEntity<?> alterarProdutoID(@PathVariable Long id, @RequestBody ProdutoDTO produto) {

        ProdutoDTO produtoAtualizado = produtoService.atualizarProduto(id, produto);

        if (produtoAtualizado != null) {
            return ResponseEntity.ok(Map.of(
                    "Mensagem", "Produto atualizado com sucesso!",
                    "Produto", produtoAtualizado
            ));

        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                    "Mensagem", "Erro ao atualizar produto!"
            ));
        }

    }

    // Deletar produto (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarProdutoPorID(@PathVariable Long id) {

        try {
         ProdutoModel produto = produtoService.deletarProdutoPorID(id);
         return ResponseEntity.ok().body(produto);

        } catch (ProdutoNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    ;
}
