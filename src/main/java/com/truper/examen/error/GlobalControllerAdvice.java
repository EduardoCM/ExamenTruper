package com.truper.examen.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalControllerAdvice {

	@ExceptionHandler(ProductoNotFoundException.class)
	public ResponseEntity<ApiError> handeProductosNoEncontrados(ProductoNotFoundException ex){
		ApiError apiError = new ApiError();
		apiError.setStatus(HttpStatus.NOT_FOUND);
		apiError.setMensaje(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
		
	}
	
}
