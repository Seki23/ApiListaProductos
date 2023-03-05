package com.prod.main.serviceImpl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import com.prod.main.entity.Categorias;
import com.prod.main.entity.Productos;
import com.prod.main.repository.CategoriaRepository;
import com.prod.main.repository.ProductosRepository;
import com.prod.main.responsedto.ListaProductoResponseDto;
import com.prod.main.responsedto.ProductosResponseDto;
import com.prod.main.service.ListaProductosService;

@Service
public class ListaProductosServiceImpl implements ListaProductosService {

	@Autowired
	CategoriaRepository categoria;

	@Autowired
	ProductosRepository productos;
	

	@Override
	public List<ListaProductoResponseDto> ListaProductos() {
		ArrayList<ListaProductoResponseDto> listaProductos = new ArrayList<>();
        String path="C:\\Portables\\Images\\";
		List<Categorias> ListCategorias = new ArrayList<>();
		List<Productos> ListProductos = new ArrayList<>();

		ListCategorias = categoria.findAll();
		ListProductos = productos.findAll();

		for (Categorias cat : ListCategorias) {
			ListaProductoResponseDto categoria = new ListaProductoResponseDto();
			ArrayList<ProductosResponseDto> Listproducto = new ArrayList<ProductosResponseDto>();

			
			categoria.setCategoria(cat.getCatNombre());
			
			if(!cat.getCatImagen().isEmpty()) {
				try {
					Path fileName = Paths.get(path,cat.getCatImagen());
					byte[] imageBytes=Files.readAllBytes(fileName);
					String base64 = Base64.getEncoder().encodeToString(imageBytes);
					
					String imagen=path+cat.getCatImagen();
					//System.out.println(":"+base64);
					categoria.setImagenCat(imagen);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			

			for (Productos prod : ListProductos) {
				if (cat.getCatId() == prod.getCatId().getCatId()) {
					
					if(!prod.getPrdImagen().isEmpty()) {
						try {
							Path fileName = Paths.get(path,prod.getPrdImagen());
							byte[] imageBytes=Files.readAllBytes(fileName);
							String base64 = Base64.getEncoder().encodeToString(imageBytes);
							
							String imagen=path+prod.getPrdImagen();
							//System.out.println(":"+base64);
							Listproducto.add(new ProductosResponseDto(prod.getPrdNombre(), prod.getPrdDescripcion(),
									prod.getPrdPrecio(),imagen));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
				
				}

			}

			categoria.setListProd(Listproducto);
			listaProductos.add(categoria);
		}
		return listaProductos;
	}

}
