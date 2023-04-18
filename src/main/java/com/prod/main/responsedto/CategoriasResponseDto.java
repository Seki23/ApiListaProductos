package com.prod.main.responsedto;



public class CategoriasResponseDto {

	private Long catId;
	private String catNombre;
	private String catImagen;
	public Long getCatId() {
		return catId;
	}
	public void setCatId(Long catId) {
		this.catId = catId;
	}
	public String getCatNombre() {
		return catNombre;
	}
	public void setCatNombre(String catNombre) {
		this.catNombre = catNombre;
	}
	
	public String getCatImagen() {
		return catImagen;
	}
	public void setCatImagen(String catImagen) {
		this.catImagen = catImagen;
	}
	
	
	
}
