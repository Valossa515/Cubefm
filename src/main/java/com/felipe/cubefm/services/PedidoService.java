package com.felipe.cubefm.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.felipe.cubefm.domain.Pedido;
import com.felipe.cubefm.repositories.PedidoRepository;
import com.felipe.cubefm.services.exceptions.ObjectNotFoundException;


@Service
public class PedidoService 
{
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
