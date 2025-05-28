package br.com.ulbra.ap2poo.repository;

import br.com.ulbra.ap2poo.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    List<Product> produtos = new ArrayList<Product>();

    public ProductRepository() { }

    public List<Product> listarTodos() {
        return this.produtos;
    }

    public Product listarProduto(int id) {
        return this.produtos.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    public ResponseEntity<Product> adicionarProduto(Product product) {
        Product novoProduto = new Product(this.produtos.size(), product.getNome(), product.getPreco());
        this.produtos.add(novoProduto);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    public ResponseEntity<Product> atualizarProduto(int id, Product product) {
        Product patchProduto = new Product(id, product.getNome(), product.getPreco());
        this.produtos.set(id, patchProduto);
        return ResponseEntity.status(204).body(null);
    }

    public ResponseEntity<Product> removerProduto(int id) {
        this.produtos.remove(id);
        return ResponseEntity.status(204).body(null);
    }
}