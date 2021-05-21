package br.com.zup.academy.ednelson.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.ISBN;

import br.com.zup.academy.ednelson.casadocodigo.autor.Autor;
import br.com.zup.academy.ednelson.casadocodigo.categoria.Categoria;

@Entity
public class Livro {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@NotNull
	@Column(unique=true)
	private String titulo;
	
	@NotBlank
	@NotNull
	@Column(length=500)
	private String resumo;
	
	@Column(columnDefinition = "TEXT")
	private String sumario;
	
	@Min(20)
	@NotNull
	private BigDecimal preco;
	
	@Min(100)
	@NotNull
	private Integer numeroDePaginas;
	
	@ISBN
	@NotBlank
	@NotNull
	@Column(unique=true)
	private String isbn;
	
	@Future
	private LocalDate dataDePublicacao;
	
	@NotNull
	@ManyToOne
	private Categoria categoria;
	
	@NotNull
	@ManyToOne
	private Autor autor;

	public Livro(@NotBlank @NotNull String titulo, @NotBlank @NotNull String resumo, String sumario,
			@Min(20) @NotNull BigDecimal preco, @Min(100) @NotNull Integer numeroDePaginas,
			@ISBN @NotBlank @NotNull String isbn, @Future LocalDate dataDePublicacao, @NotNull Categoria categoria,
			@NotNull Autor autor) {
		super();
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

	@Deprecated
	public Livro() {
		
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco="
				+ preco + ", numeroDePaginas=" + numeroDePaginas + ", isbn=" + isbn + ", dataDePublicacao="
				+ dataDePublicacao + ", categoria=" + categoria + ", autor=" + autor + "]";
	}

}
