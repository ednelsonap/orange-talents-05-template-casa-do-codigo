package br.com.zup.academy.ednelson.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.zup.academy.ednelson.casadocodigo.autor.Autor;
import br.com.zup.academy.ednelson.casadocodigo.categoria.Categoria;

public class LivroDto {

	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer numeroDePaginas;
	private String isbn;
	private LocalDate dataDePublicacao;
	private Categoria categoria;
	private Autor autor;
	
	public LivroDto(Long id, String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroDePaginas,
			String isbn, LocalDate dataDePublicacao, Categoria categoria, Autor autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.dataDePublicacao = dataDePublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}
	
	
}
