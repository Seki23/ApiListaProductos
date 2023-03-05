package com.prod.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.prod.main.entity.Productos;

public interface ProductosRepository  extends JpaRepository<Productos,Long>{

	List<Productos> findAll();
	
}
