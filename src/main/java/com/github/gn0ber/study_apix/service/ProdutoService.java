package com.github.gn0ber.study_apix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.gn0ber.study_apix.dto.ProdutoRequestCreate;
import com.github.gn0ber.study_apix.model.Produto;
import com.github.gn0ber.study_apix.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(ProdutoRequestCreate dto) {

        Produto produto = new Produto();
        produto.setNome(dto.getNome());

        return produtoRepository.save(produto);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public Boolean deleteById(Long id){
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    } 
}
