package com.prod.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.prod.main.entity.Categorias;


public interface CategoriaRepository extends JpaRepository<Categorias,Long> {


	List<Categorias> findAll();
	
}
