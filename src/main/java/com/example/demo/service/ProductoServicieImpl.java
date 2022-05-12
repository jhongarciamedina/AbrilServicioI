package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductoDTOResponse;
import com.example.demo.dto.ProductoDTOResquet;
import com.example.demo.model.Productos;
import com.example.demo.repository.productoRepository;

@Service
public class ProductoServicieImpl implements ProductoService {
	
	@Autowired
	public productoRepository productoRepository;

	@Override
	public void guardarProducto(ProductoDTOResquet producto) {
		
		Productos p = new Productos();
		p.setDescripcion(producto.getDescripcionDTO());
		p.setIdProducto(producto.getIdProductoDTO());
		p.setNombreProducto(producto.getNombreProductoDTO());
		p.setPrecio(producto.getPrecioDTO());
		p.setStock(producto.getStockDTO());
		
		productoRepository.save(p);

	}

	@Override
	public void editarProducto(ProductoDTOResquet producto) {
		
		Productos p = new Productos();
		p.setDescripcion(producto.getDescripcionDTO());
		p.setIdProducto(producto.getIdProductoDTO());
		p.setNombreProducto(producto.getNombreProductoDTO());
		p.setPrecio(producto.getPrecioDTO());
		p.setStock(producto.getStockDTO());
		productoRepository.saveAndFlush(p);
	}
	@Override
	public void eliminarProducto(Integer id) {
		productoRepository.deleteById(id);
	}
	@Override
	public List<ProductoDTOResponse> listarProducto() {
		List<ProductoDTOResponse> lista = new ArrayList<ProductoDTOResponse>();
		ProductoDTOResponse p= null;
		for(Productos producto : productoRepository.findAll()) {
			p= new ProductoDTOResponse();
			p.setDescripcionDTO(producto.getDescripcion());
			p.setIdProductoDTO(producto.getIdProducto());
			p.setNombreProductoDTO(producto.getNombreProducto());
			p.setPrecioDTO(producto.getPrecio());
			p.setStockDTO(producto.getStock());
			lista.add(p);
		}
		return lista;
	}

	@Override
	public ProductoDTOResponse obtenerProducto(Integer id) {
		Productos producto= productoRepository.findById(id).orElse(null);
		ProductoDTOResponse p= new ProductoDTOResponse();
		p.setDescripcionDTO(producto.getDescripcion());
		p.setIdProductoDTO(producto.getIdProducto());
		p.setNombreProductoDTO(producto.getNombreProducto());
		p.setPrecioDTO(producto.getPrecio());
		p.setStockDTO(producto.getStock());
		return p;
	}

}
