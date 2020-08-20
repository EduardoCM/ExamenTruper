package com.truper.examen.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.truper.examen.dao.PedidoRepository;
import com.truper.examen.dto.PedidoDTO;
import com.truper.examen.dto.converter.PredidoDTOConverter;
import com.truper.examen.error.PedidoNotFoundException;
import com.truper.examen.model.Pedido;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
	

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	private PredidoDTOConverter pedidoDTOConverter;
	
	@GetMapping("/test")
	public void test() {
		Pedido pedido = new Pedido();
		pedido.setNombreCliente("Eduardo Castillo");
		pedido.setSkuProducto("456567");
		pedidoRepository.save(pedido);
	}
	
	@GetMapping
	public ResponseEntity<?> obtenerTodosPedidos(){
		List<Pedido> pedidos = pedidoRepository.findAll();
		
		if(pedidos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			pedidos.stream()
			         .map(pedidoDTOConverter::convertToDto)
			         .collect(Collectors.toList());
			return ResponseEntity.ok(pedidos);
			
		}
	}
	
	@PostMapping
	public ResponseEntity<Pedido> nuevoPedido(@RequestBody PedidoDTO pedidoDTO){
		Pedido pedido = pedidoDTOConverter.convertToEntity(pedidoDTO);	
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoRepository.save(pedido));
	}
	
	@GetMapping("/{id}")
	public Pedido obtenerById(@PathVariable Long id) {
		return pedidoRepository.findById(id)
				.orElseThrow(() -> new PedidoNotFoundException(id));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarPedidos(@RequestBody Pedido nuevo, @PathVariable Long id){
		return pedidoRepository.findById(id)
				.map( p -> {
					
					p.setNombreCliente(nuevo.getNombreCliente());
					p.setSkuProducto(nuevo.getSkuProducto());
					return ResponseEntity.ok(pedidoRepository.save(p));
				}).orElseThrow(() -> new PedidoNotFoundException(id));
	}
	
	@DeleteMapping
	public ResponseEntity<?> borrarPedido(@PathVariable Long id){
		Pedido producto = pedidoRepository.findById(id)
				.orElseThrow(() -> new PedidoNotFoundException(id));
		pedidoRepository.delete(producto);
		return ResponseEntity.noContent().build();
		
	}

	
	

}
