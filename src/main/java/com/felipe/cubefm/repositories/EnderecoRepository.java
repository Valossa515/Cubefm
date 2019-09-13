package com.felipe.cubefm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.felipe.cubefm.domain.Categoria;
import com.felipe.cubefm.domain.Cliente;
import com.felipe.cubefm.domain.Endereco;

@Repository 
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
	

}
