package com.felipe.cubefm.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.cubefm.domain.Categoria;
import com.felipe.cubefm.domain.Cidade;
import com.felipe.cubefm.domain.Cliente;
import com.felipe.cubefm.domain.Endereco;
import com.felipe.cubefm.domain.Estado;
import com.felipe.cubefm.domain.ItemPedido;
import com.felipe.cubefm.domain.Pagamento;
import com.felipe.cubefm.domain.PagamentoComBoleto;
import com.felipe.cubefm.domain.PagamentoComCartao;
import com.felipe.cubefm.domain.Pedido;
import com.felipe.cubefm.domain.Produto;
import com.felipe.cubefm.domain.enums.EstadoPagamento;
import com.felipe.cubefm.domain.enums.TipoCliente;
import com.felipe.cubefm.repositories.CategoriaRepository;
import com.felipe.cubefm.repositories.CidadeRepository;
import com.felipe.cubefm.repositories.ClienteRepository;
import com.felipe.cubefm.repositories.EnderecoRepository;
import com.felipe.cubefm.repositories.EstadoRepository;
import com.felipe.cubefm.repositories.ItemPedidoRepository;
import com.felipe.cubefm.repositories.PagamentoRepository;
import com.felipe.cubefm.repositories.PedidoRepository;
import com.felipe.cubefm.repositories.ProdutoRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRpository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	public void instantitateTestDataBase() throws ParseException
	{
		
		Categoria cat1 = new Categoria(null, "Pluzzles");
		Categoria cat2 = new Categoria(null, "Card Game");
		Categoria cat3 = new Categoria(null, "Tabuleiro");
		Categoria cat4 = new Categoria(null, "Livros");
		Categoria cat5 = new Categoria(null, "Jogos Eletônicos");
		Categoria cat6 = new Categoria(null, "HQ's");
		Categoria cat7 = new Categoria(null, "Quadrinhos");

		Produto p1 = new Produto(null, "Cubo Mágico 3x3x3", 45.00);
		Produto p2 = new Produto(null, "Pacote de booster Pokémon - Sol & Lua 12", 7.00);
		Produto p3 = new Produto(null, "Cubo Mágico 4x4x4", 55.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRpository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlãndia", est1);
		Cidade c2 = new Cidade(null, "São Caetano do Sul", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Felipe Martins", "fe.mmo515@gmail.com", "442.446.478-48",
				TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("(11) 4221-7671", "(11) 9 5432-3543"));
		Endereco e1 = new Endereco(null, "Rua Perrella", "145", "Apto 11", "Fundação", "09520-660", cli1, c2);
		Endereco e2 = new Endereco(null, "Rua João Pessoa", "83", " ", "Centro", "09520-100", cli1, c2);
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("13/09/2019 17:13"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("13/09/2019 17:21"), cli1, e2);
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2019 00:00"),
				null);
		ped2.setPagamento(pagto2);
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 45.00);
		ItemPedido ip2 = new ItemPedido(ped2, p3, 0.00, 1, 55.00);
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2));
	}
}
