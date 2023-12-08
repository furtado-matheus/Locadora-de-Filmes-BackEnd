package com.example.locadoradefilmesbackend.controller;

import com.example.locadoradefilmesbackend.model.Filme;
import com.example.locadoradefilmesbackend.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping
    public List<Filme> listarFilmes() {
        return filmeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Filme detalhesFilme(@PathVariable Long id) {
        return filmeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Filme cadastrarFilme(@RequestBody Filme filme) {
        return filmeRepository.save(filme);
    }

    @PutMapping("/{id}")
    public Filme atualizarFilme(@PathVariable Long id, @RequestBody Filme filmeAtualizado) {
        Filme filmeExistente = filmeRepository.findById(id).orElse(null);

        if (filmeExistente != null) {
            filmeExistente.setTitulo(filmeAtualizado.getTitulo());
            filmeExistente.setDescricao(filmeAtualizado.getDescricao());
            filmeExistente.setGenero(filmeAtualizado.getGenero());
            filmeExistente.setAlugado(filmeAtualizado.isAlugado());

            return filmeRepository.save(filmeExistente);
        } else {
            return null; // Ou lançar uma exceção, dependendo da lógica desejada
        }
    }

    @DeleteMapping("/{id}")
    public void excluirFilme(@PathVariable Long id) {
        filmeRepository.deleteById(id);
    }
}
