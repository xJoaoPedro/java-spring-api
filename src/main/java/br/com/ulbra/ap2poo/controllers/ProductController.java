package br.com.ulbra.ap2poo.controllers;

import br.com.ulbra.ap2poo.models.Product;
import br.com.ulbra.ap2poo.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> listarTodos() {
        return this.productService.listarTodos();
    }

    @GetMapping("/{id}")
    public Product listarProduto(@PathVariable int id) {
        return this.productService.listarProduto(id);
    }

    @PostMapping
    public ResponseEntity<Product> adicionarProduto(@RequestBody Product product) {
        return this.productService.adicionarProduto(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> atualizarProduto(@PathVariable int id, @RequestBody Product product) {
        return this.productService.atualizarProduto(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> removerProduto(@PathVariable int id) {
        return this.productService.removerProduto(id);
    }
}
