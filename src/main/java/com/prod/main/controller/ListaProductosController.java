package com.prod.main.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prod.main.responsedto.CategoriasResponseDto;
import com.prod.main.responsedto.ListaProductoResponseDto;
import com.prod.main.responsedto.ProductosResponseDto;
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

	@CrossOrigin
	@GetMapping("/image/{file}")
	public ResponseEntity<byte[]> getImage(@PathVariable("file") String filename) {
		byte[] image = new byte[0];
		String path = "C:\\Images\\";
		try {

			Path fileName = Paths.get(path, filename);
			image = Files.readAllBytes(fileName);			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
	}

	@CrossOrigin
	@GetMapping("/listCate")
	public List<CategoriasResponseDto> ListarCategorias() {
		return productosService.ListaCategorias();
	}

	@CrossOrigin
	@GetMapping("/ListProd/{id}")
	public List<ProductosResponseDto> ListarProductosCategorias(@PathVariable("id") Integer id) {
		return productosService.ListaProductosCategoria(id);
	}

}
