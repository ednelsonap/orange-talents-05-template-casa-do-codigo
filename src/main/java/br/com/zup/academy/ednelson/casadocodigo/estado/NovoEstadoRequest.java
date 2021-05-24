package br.com.zup.academy.ednelson.casadocodigo.estado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.academy.ednelson.casadocodigo.pais.Pais;
import br.com.zup.academy.ednelson.casadocodigo.validation.ExistsId;

public class NovoEstadoRequest {

	@NotBlank
	private String nome;
	
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	@NotNull
	private Long paisId;
	
	public NovoEstadoRequest(@NotBlank String nome, Long paisId) {
		this.nome = nome;
		this.paisId = paisId;
	}

	public String getNome() {
		return nome;
	}
	
	public Long getPaisId() {
		return paisId;
	}
	
	public Estado toModel(EntityManager manager) {
		Pais pais = manager.find(Pais.class, paisId);
		return new Estado(nome, pais);
	}
}
