package br.com.zupacademy.anaflavia.casadocodigo.cadastroPaís;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.zupacademy.anaflavia.casadocodigo.cadastroEstado.Estado;

public interface PaisRepository extends JpaRepository<Pais, Long>{

	@Query("SELECT e FROM Estado e, Pais p WHERE e.nome = :nome AND p.id = :idPais "
	        + "AND e.pais = p " )
	List<Estado> findByNomePais(String nome, Long idPais);
}


