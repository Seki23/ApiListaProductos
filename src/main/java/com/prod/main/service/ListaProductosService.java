package com.prod.main.service;

import java.util.List;

import com.prod.main.responsedto.CategoriasResponseDto;
import com.prod.main.responsedto.ListaProductoResponseDto;
import com.prod.main.responsedto.ProductosResponseDto;

public interface ListaProductosService {

	public List<ListaProductoResponseDto> ListaProductos ();
	
	public List<CategoriasResponseDto> ListaCategorias();
	
	public List<ProductosResponseDto> ListaProductosCategoria(Integer Id);
	
}
