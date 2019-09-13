package com.felipe.cubefm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.felipe.cubefm.domain.Categoria;
import com.felipe.cubefm.domain.Cliente;

@Repository 
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	

}
