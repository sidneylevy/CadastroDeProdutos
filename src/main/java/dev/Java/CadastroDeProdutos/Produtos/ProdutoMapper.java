package dev.Java.CadastroDeProdutos.Produtos;

import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

        public ProdutoModel map(ProdutoDTO produtoDTO) {

           ProdutoModel produtoModel = new ProdutoModel();
           produtoModel.setId(produtoDTO.getId());
           produtoModel.setNome(produtoDTO.getNome());
           produtoModel.setDescricao(produtoDTO.getDescricao());
           produtoModel.setPreco(produtoDTO.getPreco());
           produtoModel.setQuantidade(produtoDTO.getQuantidade());
           produtoModel.setSerialnamber(produtoDTO.getSerialnamber());
           produtoModel.setMarca(produtoDTO.getMarca());
           produtoModel.setFornecedor(produtoDTO.getFornecedor());

           return produtoModel;

        }

        public ProdutoDTO map(ProdutoModel produtoModel) {
            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO.setId(produtoModel.getId());
            produtoDTO.setNome(produtoModel.getNome());
            produtoDTO.setDescricao(produtoModel.getDescricao());
            produtoDTO.setPreco(produtoModel.getPreco());
            produtoDTO.setQuantidade(produtoModel.getQuantidade());
            produtoDTO.setSerialnamber(produtoModel.getSerialnamber());
            produtoDTO.setMarca(produtoModel.getMarca());
            produtoDTO.setFornecedor(produtoModel.getFornecedor());

            return produtoDTO;
        }
}
