package br.com.zup.academy.ednelson.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.academy.ednelson.casadocodigo.estado.EstadoRepository;
import br.com.zup.academy.ednelson.casadocodigo.validation.EstadoPertenceAoPaisValidator;
import br.com.zup.academy.ednelson.casadocodigo.validation.PaisPossuiEstadosValidator;

@RestController
@RequestMapping("/api/cliente")
public class NovoClienteController {

	@Autowired
	private EntityManager manager;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private PaisPossuiEstadosValidator paisPossuiEstadosValidator;
	@Autowired
	private EstadoPertenceAoPaisValidator estadoPertenceAoPaisValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(paisPossuiEstadosValidator, estadoPertenceAoPaisValidator);
	}

	@PostMapping
	@Transactional
	private ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid NovoClienteRequest request) {
		Cliente cliente = request.toModel(manager);

		if(request.getEstadoId() != null && estadoRepository.findById(request.getEstadoId()).isPresent()) {
			cliente.setEstado(estadoRepository.findById(request.getEstadoId()).get());
		}
		clienteRepository.save(cliente);
		
		return ResponseEntity.ok(new ClienteDto(cliente));
	}
}
