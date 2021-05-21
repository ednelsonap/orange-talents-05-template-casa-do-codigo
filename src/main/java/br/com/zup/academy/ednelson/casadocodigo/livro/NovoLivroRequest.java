package br.com.zup.academy.ednelson.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.academy.ednelson.casadocodigo.autor.Autor;
import br.com.zup.academy.ednelson.casadocodigo.categoria.Categoria;
import br.com.zup.academy.ednelson.casadocodigo.validation.ExistsId;
import br.com.zup.academy.ednelson.casadocodigo.validation.UniqueValue;

public class NovoLivroRequest {

	@NotBlank
	@UniqueValue(atributo = "titulo", entidade = Livro.class)
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;

	@NotBlank
	private String sumario;
	
	@Min(20)
	@NotNull
	private BigDecimal preco;
	
	@Min(100)
	@NotNull
	private Integer numeroDePaginas;
	
	@ISBN
	@NotBlank
	@UniqueValue(atributo = "isbn", entidade = Livro.class)
	private String isbn;
	
	@Future
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataDePublicacao;
	
	@NotNull
	@ExistsId(domainClass = Categoria.class, fieldName = "id")
	private Long categoriaId;
	
	@NotNull
	@ExistsId(domainClass = Autor.class, fieldName = "id")
	private Long autorId;
	
	@JsonCreator
	public NovoLivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@Min(20) @NotNull BigDecimal preco, @Min(100) @NotNull Integer numeroDePaginas, @ISBN @NotBlank String isbn,
			@Future @NotBlank LocalDate dataDePublicacao, @NotNull Long categoriaId, @NotNull Long autorId) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.dataDePublicacao = dataDePublicacao;
		this.categoriaId = categoriaId;
		this.autorId = autorId;
	}
	
	public Livro toModel(EntityManager manager) {
		
		@NotNull Categoria categoria = manager.find(Categoria.class, categoriaId);
		@NotNull Autor autor = manager.find(Autor.class, autorId);

		return new Livro(titulo, resumo, sumario, preco, numeroDePaginas, isbn, dataDePublicacao, categoria, autor);
	}

}
