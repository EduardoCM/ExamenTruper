package com.truper.examen.dto.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.truper.examen.dto.PedidoDTO;
import com.truper.examen.model.Pedido;

@Component
public class PredidoDTOConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PedidoDTO convertToDto(Pedido producto) {
		return modelMapper.map(producto, PedidoDTO.class);
	}
	
	public Pedido convertToEntity(PedidoDTO pedidoDto) {
		return modelMapper.map(pedidoDto, Pedido.class);
	}

}
