package br.com.zup.academy.ednelson.casadocodigo.categoria;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class NomeCategoriaUnicoValidator implements ConstraintValidator<NomeCategoriaUnico, String>{

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return !categoriaRepository.findByNome(value).isPresent();
	}

}
