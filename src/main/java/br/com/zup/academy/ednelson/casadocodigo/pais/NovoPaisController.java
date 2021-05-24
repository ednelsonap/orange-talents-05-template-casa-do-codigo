package br.com.zup.academy.ednelson.casadocodigo.pais;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.academy.ednelson.casadocodigo.estado.PaisDto;

@RestController
@RequestMapping("/api/pais")
public class NovoPaisController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	@Transactional
	private ResponseEntity<PaisDto> cadastrar(@RequestBody @Valid NovoPaisRequest request) {
		Pais pais = request.toModel();
		paisRepository.save(pais);
		
		return ResponseEntity.ok(new PaisDto(pais));
	}
}
