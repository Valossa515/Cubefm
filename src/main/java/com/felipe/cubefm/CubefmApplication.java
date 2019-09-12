package com.felipe.cubefm;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.felipe.cubefm.domain.Categoria;
import com.felipe.cubefm.domain.Produto;
import com.felipe.cubefm.repositories.CategoriaRepository;
import com.felipe.cubefm.repositories.ProdutoRepository;

@SpringBootApplication
public class CubefmApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRpository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CubefmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Pluzzle");
		Categoria cat2 = new Categoria(null, "Card Game");
		
		Produto p1 = new Produto(null, "Cubo Mágico 3x3x3", 45.00);
		Produto p2 = new Produto(null, "Pacote de booster Pokémon - Sol & Lua 12", 7.00);
		Produto p3 = new Produto(null, "Cubo Mágico 4x4x4", 55.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRpository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
	}
}
