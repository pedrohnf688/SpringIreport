package com.pedrohnf688.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pedrohnf688.api.modelo.Pessoa;
import com.pedrohnf688.api.modelo.Produto;
import com.pedrohnf688.api.repositorio.PessoaRepositorio;
import com.pedrohnf688.api.repositorio.ProdutoRepositorio;

@SpringBootApplication
public class TesteIreportSpringApplication {

	@Autowired
	private PessoaRepositorio pessoaRepositorio;

	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(TesteIreportSpringApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner() {
//		return args -> {
//
//			// Pessoa 1
//			Pessoa pessoa1 = new Pessoa();
//			pessoa1.setNome("Pedro");
//			pessoa1.setEmail("pedrohnf2014@gmail.com");
//			pessoa1.setCpf("11111111111");
//			this.pessoaRepositorio.save(pessoa1);
//
//			// Pessoa 2
//			Pessoa pessoa2 = new Pessoa();
//			pessoa2.setNome("Pedro Fernandes");
//			pessoa2.setEmail("phnf@gmail.com");
//			pessoa2.setCpf("22222222222");
//			this.pessoaRepositorio.save(pessoa2);
//
//			// Pessoa 3
//			Pessoa pessoa3 = new Pessoa();
//			pessoa3.setNome("Lucas");
//			pessoa3.setEmail("lucas@gmail.com");
//			pessoa3.setCpf("333333333333");
//			this.pessoaRepositorio.save(pessoa3);
//
//			// Produto 1
//			Produto produto1 = new Produto();
//			produto1.setNomeProduto("Arroz");
//			produto1.setPreco(4.50);
//			produto1.setQuantidade(6);
//			produto1.setPessoa(pessoa1);
//			this.produtoRepositorio.save(produto1);
//
//			// Produto 2
//			Produto produto2 = new Produto();
//			produto2.setNomeProduto("Feijão");
//			produto2.setPreco(5.50);
//			produto2.setQuantidade(8);
//			produto2.setPessoa(pessoa1);
//			this.produtoRepositorio.save(produto2);
//
//			// Produto 3
//			Produto produto3 = new Produto();
//			produto3.setNomeProduto("Sabão");
//			produto3.setPreco(10.50);
//			produto3.setQuantidade(2);
//			produto3.setPessoa(pessoa1);
//			this.produtoRepositorio.save(produto3);
//
//			// Produto 4
//			Produto produto4 = new Produto();
//			produto4.setNomeProduto("Ovo da Pascoa");
//			produto4.setPreco(54.00);
//			produto4.setQuantidade(2);
//			produto4.setPessoa(pessoa2);
//			this.produtoRepositorio.save(produto4);
//
//			// Produto 5
//			Produto produto5 = new Produto();
//			produto5.setNomeProduto("Carne");
//			produto5.setPreco(30);
//			produto5.setQuantidade(3);
//			produto5.setPessoa(pessoa3);
//			this.produtoRepositorio.save(produto5);
//
//		};
//	}

}
