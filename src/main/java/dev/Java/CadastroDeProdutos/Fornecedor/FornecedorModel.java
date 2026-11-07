package dev.Java.CadastroDeProdutos.Fornecedor;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore // Não gerar de loop de serialização
    private List<ProdutoModel> produto;

}
