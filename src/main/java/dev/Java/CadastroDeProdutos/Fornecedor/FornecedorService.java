package dev.Java.CadastroDeProdutos.Fornecedor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {


    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    // Listar todos os fornecedores
    public List<FornecedorModel> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    // Listar fornecedor por id
    public FornecedorModel listarFornecedoresPorID(Long id) {
        Optional<FornecedorModel> fornecedor = fornecedorRepository.findById(id);
        return fornecedor.orElseThrow(() -> new ForcedorNaoEncontrado("Fornecedor não cadastrado"));
    }

    // Adicionar um novo fornecedor
    public FornecedorModel AdicionarFornecedor(FornecedorModel fornecedorModel) {
        return fornecedorRepository.save(fornecedorModel);
    }


    // Alterar informação do fornecedor
    public FornecedorModel atualizarFornecedor(Long id, FornecedorModel fornecedorModel) {
        if (fornecedorRepository.existsById(id)) {
            fornecedorModel.setId(id);
            return fornecedorRepository.save(fornecedorModel);
        } else {
            System.out.println("O id informado não existe.");
        }
        return null;
    }

    // Deletar um fornecedor
    public FornecedorModel deletarFornecedor(Long id) {
        if (!fornecedorRepository.existsById(id)) {
            throw new ForcedorNaoEncontrado("Fornecedor não encontrado, verifique se o id esta correto.");
        } else {
            fornecedorRepository.deleteById(id);
            System.out.println("Fornecedor removido com sucesso");
        }
        return null;
    }


}