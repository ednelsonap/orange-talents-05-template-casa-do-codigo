package br.com.zup.academy.ednelson.casadocodigo.livro;

import java.math.BigDecimal;

public class DetalheLivroDto {

	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer numeroDePaginas;
	private String isbn;
	private String nomeCategoria;
	private String nomeAutor;
	private String descricaoAutor;
	
	public DetalheLivroDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroDePaginas = livro.getNumeroDePaginas();
		this.isbn = livro.getIsbn();
		this.nomeCategoria = livro.getCategoria().getNome();
		this.nomeAutor = livro.getAutor().getNome();
		this.descricaoAutor = livro.getAutor().getDescricao();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getDescricaoAutor() {
		return descricaoAutor;
	}
	
}
