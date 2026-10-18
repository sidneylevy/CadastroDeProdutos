package dev.Java.CadastroDeProdutos.Fornecedor;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fornecedor")
public class FornecedorController {

    // GET -- Mandadr uma requisição para listar os fornecedores
    @GetMapping("/listar")
    public String listarFornecedor() {
        return "fornecedores listados com sucesso";
    }

    // POST -- Mandadr uma requisição para criar os fornecedores
    @PostMapping("/criar")
    public String criarFornecedor() {
        return "fornecedor criado";
    }

    // PUT -- Mandadr uma requisição para alterar os fornecedores
    @PutMapping("/alterar")
    public String alterarFornecedor() {
        return "fornecedor alterado";
    }

    // DELETE -- Mandadr uma requisição para deletar os fornecedores
    @DeleteMapping("/deletar")
    public String deletarFornecedor() {
        return "fornecedor deletado";
    }

}
