package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProductoDTOResponse;
import com.example.demo.dto.ProductoDTOResquet;

public interface ProductoService {
public void guardarProducto(ProductoDTOResquet producto);
	
	public void editarProducto(ProductoDTOResquet producto);
	
	public void eliminarProducto(Integer id);
	
	public List<ProductoDTOResponse> listarProducto();
	
	public ProductoDTOResponse obtenerProducto(Integer id);

}
