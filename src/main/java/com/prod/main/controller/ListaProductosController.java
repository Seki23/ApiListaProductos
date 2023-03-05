package com.prod.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prod.main.responsedto.ListaProductoResponseDto;
import com.prod.main.service.ListaProductosService;


@RestController
@RequestMapping("/listaProductos")
public class ListaProductosController {

	@Autowired
	ListaProductosService productosService;
	
	@CrossOrigin
	@GetMapping
	public List<ListaProductoResponseDto> ListarProductos() {
				return productosService.ListaProductos();
	}
	
}
