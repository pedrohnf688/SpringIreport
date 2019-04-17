package com.pedrohnf688.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pedrohnf688.api.modelo.Pessoa;
import com.pedrohnf688.api.repositorio.PessoaRepositorio;

@SpringBootApplication
public class TesteIreportSpringApplication {
	
	@Autowired
	private PessoaRepositorio pessoaRepositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(TesteIreportSpringApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner() {
//		return args -> {
//
//			Pessoa p1 = new Pessoa();
//			
//			p1.setNome("Pedro");
//			p1.setEmail("pedrohnf2014@gmail.com");
//			p1.setCpf("11111111111");
//
//			this.pessoaRepositorio.save(p1);
//			
//            Pessoa p2 = new Pessoa();
//			
//			p2.setNome("Pedro Fernandes");
//			p2.setEmail("phnf@gmail.com");
//			p2.setCpf("22222222222");
//
//			this.pessoaRepositorio.save(p2);
//			
//            Pessoa p3 = new Pessoa();
//			
//			p3.setNome("Lucas");
//			p3.setEmail("lucas@gmail.com");
//			p3.setCpf("333333333333");
//
//			this.pessoaRepositorio.save(p3);
//
//
//		};
//	}

}
