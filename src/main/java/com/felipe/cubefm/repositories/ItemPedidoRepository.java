package com.felipe.cubefm.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipe.cubefm.domain.ItemPedido;
import com.felipe.cubefm.domain.Pedido;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>
{
	
}
