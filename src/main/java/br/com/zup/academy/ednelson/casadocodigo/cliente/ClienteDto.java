package br.com.zup.academy.ednelson.casadocodigo.cliente;

public class ClienteDto {

	private Long id;
	
	public ClienteDto(Cliente cliente){
		this.id = cliente.getId();
	}
	
	public Long getId() {
		return id;
	}
}
