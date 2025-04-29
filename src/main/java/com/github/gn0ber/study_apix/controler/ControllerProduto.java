package com.github.gn0ber.study_apix.controler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.gn0ber.study_apix.dto.ProdutoRequestCreate;
import com.github.gn0ber.study_apix.dto.ProdutoRequestUpdate;
import com.github.gn0ber.study_apix.dto.ProdutoResponse;
import com.github.gn0ber.study_apix.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ControllerProduto {

    @Autowired
    private ProdutoService produtoService;

    // Métodos POST
    @PostMapping
    public ResponseEntity<ProdutoResponse> create(@RequestBody ProdutoRequestCreate dto) {
        return ResponseEntity.status(201).body(
            new ProdutoResponse()
                .toDto(produtoService.save(dto))
        );
    }

    // Métodos PUT
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> update(@PathVariable Long id, @RequestBody ProdutoRequestUpdate dto) {
        return produtoService.update(id, dto)
            .map(produto -> ResponseEntity.ok(new ProdutoResponse().toDto(produto)))
            .orElse(ResponseEntity.notFound().build());
    }
    
    // Métodos GET
    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> findAll() {
        return ResponseEntity.ok(
            produtoService
            .findAll()
            .stream()
            .map(produto -> new ProdutoResponse().toDto(produto))
            .collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> findById(@PathVariable Long id) {
        return produtoService.findById(id) 
            .map(produto -> ResponseEntity.ok(new ProdutoResponse().toDto(produto)))
            .orElse(ResponseEntity.notFound().build());
    }
    
    // Métodos DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Boolean result = produtoService.deleteById(id);
        if (result) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
