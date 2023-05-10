package com.prod.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prod.main.responsedto.ProductosResponseDto;
import com.prod.main.service.ProductosService;

@RestController
@RequestMapping("/productos")
public class productosController {
	
	@Autowired
     ProductosService productoS;
	
	@PostMapping("/guardarProducto")
	public String guardarProducto(@RequestBody ProductosResponseDto producto) {
		return productoS.RegistrarProducto(producto);
	}
	
	@PutMapping("/ActualizarProducto/{id}")
	public String ActualizarProducto(@PathVariable("file") Integer id,@RequestBody ProductosResponseDto producto) {
		return productoS.ActualizarProducto(producto,id);
	}
	
	@DeleteMapping("/EliminarProducto/{id}")
	public String EliminarProducto(@PathVariable("file") Integer id) {
		return productoS.EliminarProducto(id);
	}
	
	
}
