package com.example.perfilusuario_one_to_one.repository;

import com.example.perfilusuario_one_to_one.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Integer>
{
}