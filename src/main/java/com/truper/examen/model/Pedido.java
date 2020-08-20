package com.truper.examen.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="PEDIDO")
@Getter
@Setter
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombreCliente;
	
	/*
	@OneToMany(cascade = CascadeType.ALL)
	private List<Producto> productos = new ArrayList<>();
	*/
	
	/*
	@ManyToMany
	@JoinTable(name = "articulos_pedidos",
	joinColumns = @JoinColumn(name = "sku", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="id", referencedColumnName = "sku"))
	private Set<Producto> productos = new HashSet<>();
	*/
	
	private String skuProducto;
	

}
