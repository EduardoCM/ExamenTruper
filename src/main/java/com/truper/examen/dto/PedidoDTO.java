package com.truper.examen.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.truper.examen.model.Producto;

import lombok.Data;

@Data
public class PedidoDTO {
	
	private Long id;
	
	private String nombreCliente;
	
	private List<Producto> productos;
	

}
