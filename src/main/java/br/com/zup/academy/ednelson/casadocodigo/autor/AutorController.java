package br.com.zup.academy.ednelson.casadocodigo.autor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;

	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid AlunoForm form) {
		Autor autor = form.converter();
		autorRepository.save(autor);
		return ResponseEntity.ok().build();
	}
}
