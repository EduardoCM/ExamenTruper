package com.truper.examen.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductoDTO {
	
	private String sku;
	
	private String nombre;
	
	private Integer existencia;
	
	private BigDecimal price;

}
