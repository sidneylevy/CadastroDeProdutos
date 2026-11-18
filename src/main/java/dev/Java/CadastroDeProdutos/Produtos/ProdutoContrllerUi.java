package dev.Java.CadastroDeProdutos.Produtos;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/produto/ui")
public class ProdutoContrllerUi {

    private final ProdutoService produtoService;

    public ProdutoContrllerUi(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    @GetMapping("/listarTodos")
    public String listarProduto(Model model) {
        produtoService.listarProdutos();
        model.addAttribute("produtos", produtoService.listarProdutos());
        return "ListarProdutos";
    }

    @GetMapping("/deletar/{id}")
    public String deletarProdutoPorId(@PathVariable Long id) {
        produtoService.deletarProdutoPorID(id);
        return "redirect:/produto/ui/listarTodos";
    }

    @GetMapping("/listarPorID/{id}")
    public String listarProdutoId(@PathVariable Long id, Model model) {
        ProdutoDTO produto =  produtoService.listarProdutosPorID(id);
        if (produto !=null) {
            model.addAttribute("produto", produto);
            return "detalhesproduto";
        } else {
            model.addAttribute("mensagem", "Produto não encontrado");
            return "ListarProdutos";
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarProduto(Model model) {
        model.addAttribute("produto", new ProdutoDTO());
        return "adicionarProduto";
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute ProdutoDTO produto, RedirectAttributes redirectAttributes) {
        produtoService.adcionarProduto(produto);
        redirectAttributes.addFlashAttribute("mensagem", "Produto cadastrado com sucesso!");
        return "redirect:/produto/ui/listarTodos";
    }

}
