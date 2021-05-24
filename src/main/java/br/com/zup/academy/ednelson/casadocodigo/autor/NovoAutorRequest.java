package br.com.zup.academy.ednelson.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.academy.ednelson.casadocodigo.validation.UniqueValue;

public class NovoAutorRequest {

	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@UniqueValue(atributo = "email", entidade = Autor.class)
	private String email;
	@NotBlank
	@Size(max=400) 
	private String descricao;

	public NovoAutorRequest(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {	
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}
	
}
