package dev.Java.CadastroDeProdutos.Produtos;


import dev.Java.CadastroDeProdutos.Fornecedor.FornecedorModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

// Entity transforma uma classe em uma entidade do DB
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Produto")
    private Long id;// git commit --amend -> serve para refatorar uma modificação feita no ultimo commit

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private double preco;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(unique = true) // Usar para dados unicos
    private String serialnamber;

    // @ManyToOne - um produto tem apenas um fornecedor
    @ManyToOne
    @JoinColumn(name = "fornecedor_id") // Foreing Key ou chave estrangeira
    private FornecedorModel fornecedor;
}
