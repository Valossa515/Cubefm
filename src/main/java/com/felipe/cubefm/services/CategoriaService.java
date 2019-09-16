package com.felipe.cubefm.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.felipe.cubefm.domain.Categoria;
import com.felipe.cubefm.repositories.CategoriaRepository;
import com.felipe.cubefm.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService 
{
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	public Categoria insert(Categoria obj)
	{
		obj.setId(null);
		return repo.save(obj);
	}
}
