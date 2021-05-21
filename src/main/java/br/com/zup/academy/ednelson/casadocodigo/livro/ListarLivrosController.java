package br.com.zup.academy.ednelson.casadocodigo.livro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/livro")
public class ListarLivrosController {

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping(value = "/listar")
	private List<LivroDto> listar() {
		
		List<Livro> livros = livroRepository.findAll();

		return LivroDto.converter(livros);
	}
}
