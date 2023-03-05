package com.prod.main.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categorias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long catId;

	@Column(length = 50)
	private String catNombre;
	private Integer catOrden;
	@Column(length = 200)
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
	public Integer getCatOrden() {
		return catOrden;
	}
	public void setCatOrden(Integer catOrden) {
		this.catOrden = catOrden;
	}
	public String getCatImagen() {
		return catImagen;
	}
	public void setCatImagen(String catImagen) {
		this.catImagen = catImagen;
	}
	

	
	

	

	

	

}
