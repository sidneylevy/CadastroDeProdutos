package dev.Java.CadastroDeProdutos.Produtos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Adicionar Produto (CREAT)
    @PostMapping("/criar")
    public ResponseEntity<?> criarProduto(@RequestBody ProdutoDTO produto) {
        ProdutoDTO produtoDTO = produtoService.adcionarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Produto cadastrado com sucesso " + produtoDTO.getNome() + " (ID) " + produtoDTO.getId());

    }


    // Mostrar todos os produtos (READ)
    @GetMapping("/listarTodos")
    public ResponseEntity<List<ProdutoDTO>> listarProduto() {
        return ResponseEntity.ok().body(produtoService.listarProdutos());

    }

    // Mostrar produto por id (READ)
    @GetMapping("/listarPorID/{id}")
    public ResponseEntity<?> listarProdutoID(@PathVariable Long id) {
        ProdutoDTO produto = produtoService.listarProdutosPorID(id);
        if (produto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esse ID não existe");

        }else {
            return ResponseEntity.status(HttpStatus.OK).body(produto);
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
                    "Mensagem", "Erro ao atualizar produto! Esse ID não existe"
            ));
        }

    }

    // Deletar produto (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarProdutoPorID(@PathVariable Long id) {
        try {
             produtoService.deletarProdutoPorID(id);
            return ResponseEntity.ok().body("Produto deletado com sucesso!");

        } catch (ProdutoNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe produto com o ID "  + id);
        }

    }

}
