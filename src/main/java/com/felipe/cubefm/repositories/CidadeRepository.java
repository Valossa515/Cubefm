package com.felipe.cubefm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.felipe.cubefm.domain.Categoria;
import com.felipe.cubefm.domain.Cidade;

@Repository 
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{
	

}
