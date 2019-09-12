package com.felipe.cubefm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.felipe.cubefm.domain.Categoria;
import com.felipe.cubefm.domain.Cidade;
import com.felipe.cubefm.domain.Estado;

@Repository 
public interface EstadoRepository extends JpaRepository<Estado, Integer>
{
	

}
