package br.com.zup.academy.ednelson.casadocodigo.livro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/livro")
public class NovoLivroController {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private LivroRepository livroRepository;
	
	@PostMapping
	@Transactional
	private String cadastrar(@RequestBody @Valid NovoLivroRequest request) {

		Livro livro = request.toModel(manager);
		livroRepository.save(livro);
		
		return livro.toString();

	}
}
