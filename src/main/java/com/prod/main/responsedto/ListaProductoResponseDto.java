package com.prod.main.responsedto;

import java.util.ArrayList;

public class ListaProductoResponseDto {

	private String categoria;
	
	private String imagenCat;
	
	private ArrayList<ProductosResponseDto> listProd;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getImagenCat() {
		return imagenCat;
	}

	public void setImagenCat(String imagenCat) {
		this.imagenCat = imagenCat;
	}

	public ArrayList<ProductosResponseDto> getListProd() {
		return listProd;
	}

	public void setListProd(ArrayList<ProductosResponseDto> listProd) {
		this.listProd = listProd;
	}

	
	
	
}
