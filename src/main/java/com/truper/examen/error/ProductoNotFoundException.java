package com.truper.examen.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductoNotFoundException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4533057632247506837L;

	public ProductoNotFoundException(String sku) {
		super("No se pudo encontrar el articulo con el SKU: " + sku);
	}
}
