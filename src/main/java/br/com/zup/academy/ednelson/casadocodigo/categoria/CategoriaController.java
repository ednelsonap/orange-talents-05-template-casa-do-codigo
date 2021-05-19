package br.com.zup.academy.ednelson.casadocodigo.categoria;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	private ResponseEntity<?> cadastrar(@RequestBody @Valid NovaCategoriaRequest request) {
		
		Categoria categoria = request.toModel();
		categoriaRepository.save(categoria);
		
		return ResponseEntity.ok().build();
	}
}
