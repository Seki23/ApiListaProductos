package com.prod.main.responsedto;

public class ProductosResponseDto {
	
	private Long Id;

	private String prdNombre;

	private String prdDescripcion;

	private double prdPrecio;

	private String prdImagen;
	
	
	
	

	public ProductosResponseDto() {
		super();
	}

	public ProductosResponseDto(String prdNombre, String prdDescripcion, double prdPrecio, String prdImagen) {
		super();
		this.prdNombre = prdNombre;
		this.prdDescripcion = prdDescripcion;
		this.prdPrecio = prdPrecio;
		this.prdImagen = prdImagen;
	}
	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}


	public String getPrdNombre() {
		return prdNombre;
	}

	public void setPrdNombre(String prdNombre) {
		this.prdNombre = prdNombre;
	}

	public String getPrdDescripcion() {
		return prdDescripcion;
	}

	public void setPrdDescripcion(String prdDescripcion) {
		this.prdDescripcion = prdDescripcion;
	}

	public double getPrdPrecio() {
		return prdPrecio;
	}

	public void setPrdPrecio(double prdPrecio) {
		this.prdPrecio = prdPrecio;
	}

	public String getPrdImagen() {
		return prdImagen;
	}

	public void setPrdImagen(String prdImagen) {
		this.prdImagen = prdImagen;
	}

	

}
