package br.com.zup.academy.ednelson.casadocodigo.estado;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

	List<Estado> findByPaisId(Long id);

}
