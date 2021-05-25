package br.com.zup.academy.ednelson.casadocodigo.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.academy.ednelson.casadocodigo.cliente.NovoClienteRequest;
import br.com.zup.academy.ednelson.casadocodigo.estado.Estado;
import br.com.zup.academy.ednelson.casadocodigo.estado.EstadoRepository;

@Component
public class PaisPossuiEstadosValidator implements Validator {

	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return NovoClienteRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if (errors.hasErrors()) {
			return;
		}

		System.out.println("entrou no validador");

		NovoClienteRequest request = (NovoClienteRequest) target;
		
		List<Estado> estadosDoPais = estadoRepository.findByPaisId(request.getPaisId());
		
		if (request.getEstadoId() == null && !estadosDoPais.isEmpty()) {
			errors.rejectValue("paisId", null, "O país possui estados");
		}

	}

}
