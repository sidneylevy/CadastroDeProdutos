package dev.Java.CadastroDeProdutos.Produtos;

import dev.Java.CadastroDeProdutos.Fornecedor.FornecedorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;
    private String serialnamber;
    private String marca;
    private FornecedorModel fornecedor;
}
