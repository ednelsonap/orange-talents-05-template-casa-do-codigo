package br.com.zup.academy.ednelson.casadocodigo.autor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class EmailUnicoValidator implements ConstraintValidator<EmailUnico, String>{

	@Autowired 
	private AutorRepository autorRepository;
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return !autorRepository.findByEmail(email).isPresent();
	}
	
}
