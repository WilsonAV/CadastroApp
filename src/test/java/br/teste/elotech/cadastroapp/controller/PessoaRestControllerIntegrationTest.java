package br.teste.elotech.cadastroapp.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import br.teste.elotech.cadastroapp.entity.Pessoa;
import br.teste.elotech.cadastroapp.service.PessoaService;

import io.restassured.http.ContentType;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.mockito.Mockito.when;

@WebMvcTest
public class PessoaRestControllerIntegrationTest {

    @Autowired
    private PessoaController pessoaController;

    @MockBean
    private PessoaService service;

    @BeforeEach
	public void setup() {
		standaloneSetup(this.pessoaController);
	}


    @Test
	public void deveRetornarSucesso_QuandoBuscarPessoa() {
		
		when(this.service.getPessoaById(1L)).thenReturn(new Pessoa());
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/pessoa/{id}", 1L)
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveRetornarNaoEncontrado_QuandoBuscaFilme() {
		
		when(this.service.getPessoaById(100L)).thenReturn(null);
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/pessoa/{id}",100L)
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}    
}
