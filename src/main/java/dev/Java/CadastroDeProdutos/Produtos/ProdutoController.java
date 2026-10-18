package dev.Java.CadastroDeProdutos.Produtos;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Primeira mensagem dessa rota";
    }


    // Adicionar Produto (CREAT)
    @PostMapping("/criar")
    public String criarProduto() {
        return "Criando um produto";
    }

    // Mostrar produto por id (READ)
    @GetMapping("/listarTodos")
    public String todosProduto() {
        return "Todos os produtos";
    }

    // Mostrar todos os produtos (READ)
    @GetMapping("/listarPorID")
    public String mostrarProdutoID() {
        return "Mostrar por ID";
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

}
