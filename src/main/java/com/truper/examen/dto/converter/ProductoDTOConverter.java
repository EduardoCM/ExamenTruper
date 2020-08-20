package com.truper.examen.dto.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.truper.examen.dto.ProductoDTO;
import com.truper.examen.model.Producto;

@Component
public class ProductoDTOConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ProductoDTO convertToDto(Producto producto) {
		return modelMapper.map(producto, ProductoDTO.class);
	}
	
	public Producto convertToEntity(ProductoDTO producto) {
		return modelMapper.map(producto, Producto.class);
	}


}
