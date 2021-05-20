package br.com.zupacademy.anaflavia.casadocodigo.livros;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface LivroRepository extends JpaRepository<Livro, Long> {

	Optional<Livro>findByTitulo(String titulo);
}
