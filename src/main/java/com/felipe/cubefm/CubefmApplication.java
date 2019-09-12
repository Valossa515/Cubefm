package com.felipe.cubefm;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.felipe.cubefm.domain.Categoria;
import com.felipe.cubefm.domain.Cidade;
import com.felipe.cubefm.domain.Estado;
import com.felipe.cubefm.domain.Produto;
import com.felipe.cubefm.repositories.CategoriaRepository;
import com.felipe.cubefm.repositories.CidadeRepository;
import com.felipe.cubefm.repositories.EstadoRepository;
import com.felipe.cubefm.repositories.ProdutoRepository;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@SpringBootApplication
public class CubefmApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRpository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
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
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlãndia",est1);
		Cidade c2 = new Cidade(null, "São Caetano do Sul", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
	}
}
