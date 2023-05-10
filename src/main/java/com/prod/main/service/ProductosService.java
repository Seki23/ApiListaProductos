package com.prod.main.service;

import com.prod.main.responsedto.ProductosResponseDto;

public interface ProductosService {
	
	public String RegistrarProducto(ProductosResponseDto producto);
	
	public String ActualizarProducto(ProductosResponseDto producto,Integer id);
	
	public String EliminarProducto(Integer id);
	

}
