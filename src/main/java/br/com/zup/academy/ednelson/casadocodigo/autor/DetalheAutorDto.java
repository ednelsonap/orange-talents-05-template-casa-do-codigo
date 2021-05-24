package br.com.zup.academy.ednelson.casadocodigo.autor;

public class DetalheAutorDto {

	private String nome;
	private String descricao;

	public DetalheAutorDto(Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
