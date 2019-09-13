package com.felipe.cubefm.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.felipe.cubefm.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>
{
	
}
