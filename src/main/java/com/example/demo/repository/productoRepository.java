package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Productos;

@Repository
public interface productoRepository extends JpaRepository<Productos, Integer> {
	
	

}
