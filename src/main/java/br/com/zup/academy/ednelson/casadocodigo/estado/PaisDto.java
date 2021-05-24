package br.com.zup.academy.ednelson.casadocodigo.estado;

import br.com.zup.academy.ednelson.casadocodigo.pais.Pais;

public class PaisDto {

	private Long id;
	private String nome;

	public PaisDto(Pais pais) {
		this.id = pais.getId();
		this.nome = pais.getNome();
	}

	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
}
