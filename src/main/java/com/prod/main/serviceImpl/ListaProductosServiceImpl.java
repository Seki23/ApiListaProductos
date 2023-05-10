package com.prod.main.serviceImpl;

import java.math.BigDecimal;
import java.math.BigInteger;
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
import com.prod.main.responsedto.CategoriasResponseDto;
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
		String path = "C:\\Images\\";
		List<Categorias> ListCategorias = new ArrayList<>();
		List<Productos> ListProductos = new ArrayList<>();

		ListCategorias = categoria.findAll();
		ListProductos = productos.findAll();

		for (Categorias cat : ListCategorias) {
			ListaProductoResponseDto categoria = new ListaProductoResponseDto();
			ArrayList<ProductosResponseDto> Listproducto = new ArrayList<ProductosResponseDto>();

			categoria.setCategoria(cat.getCatNombre());

			if (!cat.getCatImagen().isEmpty()) {
				try {
					Path fileName = Paths.get(path, cat.getCatImagen());
					byte[] imageBytes = Files.readAllBytes(fileName);
					String base64 = Base64.getEncoder().encodeToString(imageBytes);

					String imagen = path + cat.getCatImagen();
					// System.out.println(":"+base64);
					categoria.setImagenCat(imagen);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			for (Productos prod : ListProductos) {
				if (cat.getCatId() == prod.getCatId()) {

					if (!prod.getPrdImagen().isEmpty()) {
						try {
							Path fileName = Paths.get(path, prod.getPrdImagen());
							byte[] imageBytes = Files.readAllBytes(fileName);
							String base64 = Base64.getEncoder().encodeToString(imageBytes);

							String imagen = path + prod.getPrdImagen();
							// System.out.println(":"+base64);
							Listproducto.add(new ProductosResponseDto(prod.getPrdNombre(), prod.getPrdDescripcion(),
									prod.getPrdPrecio(), imagen));
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

	@Override
	public List<CategoriasResponseDto> ListaCategorias() {
		ArrayList<CategoriasResponseDto> lista = new ArrayList<>();
		String path = "C:\\Images\\";
		List<Categorias> ListCategorias = new ArrayList<>();

		ListCategorias = categoria.findAll();

		for (Categorias cat : ListCategorias) {
			CategoriasResponseDto categoria = new CategoriasResponseDto();
			ArrayList<ProductosResponseDto> Listproducto = new ArrayList<ProductosResponseDto>();

			try {
				categoria.setCatId(cat.getCatId());
				categoria.setCatNombre(cat.getCatNombre());

				if (!cat.getCatImagen().isEmpty()) {

					Path fileName = Paths.get(path, cat.getCatImagen());
					byte[] imageBytes = Files.readAllBytes(fileName);
					String base64 = Base64.getEncoder().encodeToString(imageBytes);

					String imagen = path + cat.getCatImagen();
					categoria.setCatImagen(imagen);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			lista.add(categoria);
		}
		return lista;

	}

	@Override
	public List<ProductosResponseDto> ListaProductosCategoria(Integer id) {
		ArrayList<ProductosResponseDto> listaProductos = new ArrayList<>();
		String path = "C:\\Images\\";
		List<Productos> ListProductos = productos.findAllbyCategoria(id);

		for (Productos prod : ListProductos) {

			if (!prod.getPrdImagen().isEmpty()) {
				try {
					String imagen = path + prod.getPrdImagen();
					listaProductos.add(new ProductosResponseDto(prod.getPrdNombre(), prod.getPrdDescripcion(),
							prod.getPrdPrecio(), imagen));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		return listaProductos;
	}

}
