package dev.Java.CadastroDeProdutos.Fornecedor;

import dev.Java.CadastroDeProdutos.Produtos.ProdutoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_fornecedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String setor;

    // @OneToMany - um fornecedor pode ter varios produtos
    @OneToMany(mappedBy = "fornecedor")
    private List<ProdutoModel> produto;

}
