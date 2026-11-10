package dev.Java.CadastroDeProdutos.Fornecedor;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    Scanner sc = new Scanner(System.in);

    private FornecedorService  fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    // GET -- Mandadr uma requisição para listar os fornecedores
    @GetMapping("/listarTodos")
    public List<FornecedorModel> listarFornecedor() {
        return fornecedorService.listarFornecedores();
    }

    @GetMapping("/listarPorID/{id}")
    public ResponseEntity<?> listarFornecedorPorID(@PathVariable Long id) {
        try {
            FornecedorModel fornecedor =  fornecedorService.listarFornecedoresPorID(id);
            return ResponseEntity.ok().body(fornecedor);
        }catch (ForcedorNaoEncontrado e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // POST -- Mandadr uma requisição para criar os fornecedores
    @PostMapping("/criar")
    public FornecedorModel criarFornecedor(@RequestBody FornecedorModel fornecedorModel) {
        return fornecedorService.AdicionarFornecedor(fornecedorModel);
    }

    // PUT -- Mandadr uma requisição para alterar os fornecedores
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarFornecedor(Long id, @RequestBody FornecedorModel fornecedorModel) {
        try{
            FornecedorModel fornecedorModelAtualiza =  fornecedorService.atualizarFornecedor(id,  fornecedorModel);
            return ResponseEntity.ok().body(fornecedorModelAtualiza);
        }catch(ForcedorNaoEncontrado e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // DELETE -- Mandadr uma requisição para deletar os fornecedores
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarFornecedor(@PathVariable Long id) {
        try{
         FornecedorModel fornecedorModel = fornecedorService.deletarFornecedor(id);
         return ResponseEntity.ok().body(fornecedorModel);

        }catch (ForcedorNaoEncontrado e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

}
