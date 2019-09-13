package com.felipe.cubefm.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.felipe.cubefm.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>
{
	
}
