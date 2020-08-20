package com.truper.examen.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "PRODUCTO")
@Data
public class Producto implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="SKU")
	private String sku;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="EXISTENCIA")
	private Integer existencia;
	
	@Column(name="PRICE")
	private BigDecimal price;
	

}
