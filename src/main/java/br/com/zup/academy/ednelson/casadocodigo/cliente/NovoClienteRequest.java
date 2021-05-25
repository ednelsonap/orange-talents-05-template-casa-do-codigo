package br.com.zup.academy.ednelson.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.academy.ednelson.casadocodigo.estado.Estado;
import br.com.zup.academy.ednelson.casadocodigo.pais.Pais;
import br.com.zup.academy.ednelson.casadocodigo.validation.CpfOrCnpj;
import br.com.zup.academy.ednelson.casadocodigo.validation.ExistsId;
import br.com.zup.academy.ednelson.casadocodigo.validation.UniqueValue;

public class NovoClienteRequest {

	@Email
	@NotBlank
	@UniqueValue(atributo = "email", entidade = Cliente.class)
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@CpfOrCnpj
	@UniqueValue(atributo = "documento", entidade = Cliente.class)
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long paisId;
	@ExistsId(domainClass = Estado.class, fieldName = "id")
	private Long estadoId;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	
	public NovoClienteRequest(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long paisId, @NotBlank String telefone, @NotBlank String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisId = paisId;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Long getPaisId() {
		return paisId;
	}
	
	public Long getEstadoId() {
		return estadoId;
	}
	
	public Cliente toModel(EntityManager manager) {
		@NotNull Pais pais = manager.find(Pais.class, paisId);
		return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep);
	}
	
}
