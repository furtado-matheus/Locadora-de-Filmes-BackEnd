package com.example.locadoradefilmesbackend.repository;

import com.example.locadoradefilmesbackend.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
