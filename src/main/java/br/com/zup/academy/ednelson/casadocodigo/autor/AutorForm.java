package br.com.zup.academy.ednelson.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorForm {

	@NotNull @NotBlank
	private String nome;
	
	@Email(message="Formato inválido") @NotNull @NotBlank
	private String email;
	
	@Size(max=400, message="Não pode exceder 400 caracteres") @NotNull @NotBlank
	private String descricao;

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public Autor converter() {
		return new Autor(nome, email, descricao);
	}
}
