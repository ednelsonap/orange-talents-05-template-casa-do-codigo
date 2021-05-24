package br.com.zup.academy.ednelson.casadocodigo.estado;

public class EstadoDto {

	private Long id;
	private String nome;
	private PaisDto pais;
	
	public EstadoDto(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.pais = new PaisDto(estado.getPais());
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public PaisDto getPais() {
		return pais;
	}
}
