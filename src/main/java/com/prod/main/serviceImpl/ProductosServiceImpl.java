package com.prod.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prod.main.entity.Productos;
import com.prod.main.repository.ProductosRepository;
import com.prod.main.responsedto.ProductosResponseDto;
import com.prod.main.service.ProductosService;

@Service
public class ProductosServiceImpl implements ProductosService {

	@Autowired
	ProductosRepository productoRepository;

	@Override
	public String RegistrarProducto(ProductosResponseDto producto) {
		String resultado = "";

		if (producto == null) {
			resultado = "Error al guardar el registro";

		} else {
			// Educacion cEdu = productoRepository.get;
			Productos prod = new Productos();

			prod.setPrdId(producto.getId());
			prod.setPrdNombre(producto.getPrdNombre());
			prod.setPrdDescripcion(producto.getPrdDescripcion());
			prod.setPrdImagen(producto.getPrdImagen());
			prod.setPrdPrecio(producto.getPrdPrecio());

			productoRepository.save(prod);

			resultado = "Actualizado!";

		}

		return resultado;
	}

	@Override
	public String ActualizarProducto(ProductosResponseDto producto, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String EliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
