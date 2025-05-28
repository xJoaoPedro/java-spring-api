package br.com.ulbra.ap2poo.services;

import br.com.ulbra.ap2poo.models.Product;
import br.com.ulbra.ap2poo.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listarTodos() {
        return this.productRepository.listarTodos();
    }


    public Product listarProduto(int id) {
        return this.productRepository.listarProduto(id);
    }

    public ResponseEntity<Product> adicionarProduto(Product product) {
        return this.productRepository.adicionarProduto(product);
    }

    public ResponseEntity<Product> atualizarProduto(int id, Product product) {
        return this.productRepository.atualizarProduto(id, product);
    }

    public ResponseEntity<Product> removerProduto(int id) {
        return this.productRepository.removerProduto(id);
    }
}
