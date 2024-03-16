package br.com.relojoaria.backend;

import java.util.NoSuchElementException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.relojoaria.backend.model.Produto;
import br.com.relojoaria.backend.repository.ProdutoRepository;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	@Bean
	  CommandLineRunner runner(ProdutoRepository repository) {
	    return args -> {

	      Produto produto = new Produto();
	      produto.setNome("relogio 1");

	      repository.save(produto);
	      Produto saved = repository.findById(produto.getId()).orElseThrow(NoSuchElementException::new);
	    };
	  }

}
