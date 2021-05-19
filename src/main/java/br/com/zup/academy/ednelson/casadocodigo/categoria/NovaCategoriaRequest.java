package br.com.zup.academy.ednelson.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {
	
	@NotBlank
	@NomeCategoriaUnico
	private String nome;
	
	@Deprecated
	public NovaCategoriaRequest() {

	}

	public NovaCategoriaRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() { 
		return nome; 
	}
	 
	public Categoria toModel() {
		return new Categoria(this.nome);
	}
	
}
