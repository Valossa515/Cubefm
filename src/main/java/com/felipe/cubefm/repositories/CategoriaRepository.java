package com.felipe.cubefm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipe.cubefm.domain.Categoria;

@Repository 
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	

}
