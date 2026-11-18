package dev.Java.CadastroDeProdutos.Produtos;


import dev.Java.CadastroDeProdutos.Fornecedor.FornecedorModel;
import jakarta.persistence.*;
import lombok.*;


// Entity transforma uma classe em uma entidade do DB
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "fornecedor")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Produto")
    private Long id;// git commit --amend -> serve para refatorar uma modificação feita no ultimo commit

    @Column(name = "nome")
    private String nome;

    @Column(name = "imagem")
    private String imagem;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private double preco;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(unique = true) // Usar para dados unicos
    private String serialnamber;

    @Column(name = "marca")
    private String marca;

    // @ManyToOne - um produto tem apenas um fornecedor
    @ManyToOne
    @JoinColumn(name = "fornecedor_id") // Foreing Key ou chave estrangeira
    private FornecedorModel fornecedor;
}
