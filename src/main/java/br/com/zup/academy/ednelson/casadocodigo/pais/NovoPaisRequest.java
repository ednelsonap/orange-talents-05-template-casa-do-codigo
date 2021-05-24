package br.com.zup.academy.ednelson.casadocodigo.pais;

import javax.validation.constraints.NotBlank;

import br.com.zup.academy.ednelson.casadocodigo.validation.UniqueValue;

public class NovoPaisRequest {

	@NotBlank
	@UniqueValue(atributo = "nome", entidade = Pais.class)
	private String nome;

	public NovoPaisRequest(String nome) {
		this.nome = nome;
	}

	public Pais toModel() {
		return new Pais(nome);
	}
	
	public String getNome() {
		return nome;
	}

	public NovoPaisRequest() {
		
	}
}
