package br.com.zup.academy.ednelson.casadocodigo.livro;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/livro")
public class DetalheLivroController {

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping("/{id}")
	private ResponseEntity<DetalheLivroDto> detalhar(@PathVariable Long id) {
		
		Optional<Livro> livro = livroRepository.findById(id);
		
		if(livro.isPresent()) {
			return ResponseEntity.ok(new DetalheLivroDto(livro.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
