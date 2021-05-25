package br.com.zup.academy.ednelson.casadocodigo.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.academy.ednelson.casadocodigo.cliente.NovoClienteRequest;
import br.com.zup.academy.ednelson.casadocodigo.estado.Estado;
import br.com.zup.academy.ednelson.casadocodigo.estado.EstadoRepository;
import br.com.zup.academy.ednelson.casadocodigo.pais.Pais;
import br.com.zup.academy.ednelson.casadocodigo.pais.PaisRepository;

@Component
public class EstadoPertenceAoPaisValidator implements Validator{

	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private PaisRepository paisRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return NovoClienteRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		NovoClienteRequest request = (NovoClienteRequest) target;
		
		Optional<Estado> estado = estadoRepository.findById(request.getEstadoId());
		Pais pais = paisRepository.findById(request.getPaisId()).get();
		
		if (estado.isPresent() && estado.get().getPais().getId() != pais.getId()) {
			errors.rejectValue("estadoId", null, "O estado não pertence ao pais");
		}
	}

}
