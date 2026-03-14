package com.example.perfilusuario_one_to_one.repository;

import com.example.perfilusuario_one_to_one.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoBBDD extends JpaRepository<Usuario, Integer> {
}
