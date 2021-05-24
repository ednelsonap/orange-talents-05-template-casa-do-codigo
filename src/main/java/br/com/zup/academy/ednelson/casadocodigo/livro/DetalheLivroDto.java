package br.com.zup.academy.ednelson.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.com.zup.academy.ednelson.casadocodigo.autor.DetalheAutorDto;

public class DetalheLivroDto {

	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer numeroDePaginas;
	private String isbn;
	private String dataDePublicacao;
	private DetalheAutorDto autor;
	
	public DetalheLivroDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroDePaginas = livro.getNumeroDePaginas();
		this.isbn = livro.getIsbn();
		this.dataDePublicacao = livro.getDataDePublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.autor = new DetalheAutorDto(livro.getAutor());
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

	public String getDataDePublicacao() {
		return dataDePublicacao;
	}
	
	public DetalheAutorDto getAutor() {
		return autor;
	}

}
