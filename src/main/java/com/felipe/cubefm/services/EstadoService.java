package com.felipe.cubefm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.cubefm.domain.Estado;
import com.felipe.cubefm.repositories.EstadoRepository;

@Service
public class EstadoService {
	@Autowired
	private EstadoRepository repo;
	
	public List<Estado> findAll()
	{
		return repo.findAllByOrderByNome();
	}
}
