package com.example.locadoradefilmesbackend.repository;

import com.example.locadoradefilmesbackend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
