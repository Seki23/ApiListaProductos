package com.prod.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long prdId;

	@Column(length = 50)
	private String prdNombre;
	@Column(length = 200)
	private String prdDescripcion;

	private double prdPrecio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Categorias", referencedColumnName = "catId")
    private Categorias catId;

	@Column(length = 200)
	private String prdImagen;

	public Long getPrdId() {
		return prdId;
	}

	public void setPrdId(Long prdId) {
		this.prdId = prdId;
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

	public Categorias getCatId() {
		return catId;
	}

	public void setCatId(Categorias catId) {
		this.catId = catId;
	}

	public String getPrdImagen() {
		return prdImagen;
	}

	public void setPrdImagen(String prdImagen) {
		this.prdImagen = prdImagen;
	}


	
	
	
}
