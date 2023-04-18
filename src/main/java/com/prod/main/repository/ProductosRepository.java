package com.prod.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prod.main.entity.Productos;
import com.prod.main.responsedto.ProductosResponseDto;

public interface ProductosRepository  extends JpaRepository<Productos,Long>{

	List<Productos> findAll();
	
	@Query (value = "SELECT * FROM productos WHERE categorias=:id", nativeQuery=true)
	List<Productos> findAllbyCategoria(Integer id);
	
}
