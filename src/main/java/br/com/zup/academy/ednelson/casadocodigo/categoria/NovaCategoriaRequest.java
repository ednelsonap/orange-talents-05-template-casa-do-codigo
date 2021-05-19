package br.com.zup.academy.ednelson.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import br.com.zup.academy.ednelson.casadocodigo.validation.UniqueValue;

public class NovaCategoriaRequest {
	
	@NotBlank
	@UniqueValue(entidade = Categoria.class, atributo = "nome")
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
