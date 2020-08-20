package com.truper.examen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truper.examen.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String>  {

}
