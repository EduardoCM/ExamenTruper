package com.truper.examen.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.truper.examen.dao.ProductoRepository;
import com.truper.examen.dto.ProductoDTO;
import com.truper.examen.dto.converter.ProductoDTOConverter;
import com.truper.examen.error.ProductoNotFoundException;
import com.truper.examen.model.Producto;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	private ProductoDTOConverter productoConverter;
	
	@GetMapping("/test")
	public void test() {
		Producto producto = new Producto();
		producto.setSku("456567");
		producto.setNombre("Podadora");
		producto.setExistencia(10);
		producto.setPrice(new BigDecimal("1000"));
		productoRepository.save(producto);
	}
	
	@GetMapping
	public ResponseEntity<?> obtenerTodosProductos(){
		List<Producto> productos = productoRepository.findAll();
		
		if(productos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			productos.stream()
			         .map(productoConverter::convertToDto)
			         .collect(Collectors.toList());
			return ResponseEntity.ok(productos);
			
		}
	}
	
	@PostMapping
	public ResponseEntity<Producto> nuevoProducto(@RequestBody ProductoDTO productoDTO){
		Producto producto = productoConverter.convertToEntity(productoDTO);	
		return ResponseEntity.status(HttpStatus.CREATED).body(productoRepository.save(producto));
	}
	
	@GetMapping("/{id}")
	public Producto obtenerById(@PathVariable String sku) {
		return productoRepository.findById(sku)
				.orElseThrow(() -> new ProductoNotFoundException(sku));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarProducto(@RequestBody Producto nuevo, @PathVariable String id){
		return productoRepository.findById(id)
				.map( p -> {
					p.setExistencia(nuevo.getExistencia());
					p.setNombre(nuevo.getNombre());
					p.setPrice(nuevo.getPrice());
					return ResponseEntity.ok(productoRepository.save(p));
				}).orElseThrow(() -> new ProductoNotFoundException(id));
	}
	
	
	@DeleteMapping
	public ResponseEntity<?> borrarProducto(@PathVariable String sku){
		Producto producto = productoRepository.findById(sku)
				.orElseThrow(() -> new ProductoNotFoundException(sku));
		productoRepository.delete(producto);
		return ResponseEntity.noContent().build();
		
	}
	
	
	

}
