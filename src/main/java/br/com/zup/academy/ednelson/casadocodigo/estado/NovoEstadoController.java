package br.com.zup.academy.ednelson.casadocodigo.estado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estado")
public class NovoEstadoController {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private EstadoRepository estadoRepository;

	@PostMapping
	private ResponseEntity<EstadoDto> cadastrar(@RequestBody @Valid NovoEstadoRequest request) {
		
		Query query = manager.createQuery("select e from Estado e where e.nome = :pNome and e.pais.id = :pPaisId");
		query.setParameter("pNome", request.getNome());
		query.setParameter("pPaisId", request.getPaisId());
		
		if(!query.getResultList().isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		
		Estado estado = request.toModel(manager);
		estadoRepository.save(estado);
		return ResponseEntity.ok(new EstadoDto(estado));
	}
}
