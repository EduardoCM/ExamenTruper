package com.truper.examen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truper.examen.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
