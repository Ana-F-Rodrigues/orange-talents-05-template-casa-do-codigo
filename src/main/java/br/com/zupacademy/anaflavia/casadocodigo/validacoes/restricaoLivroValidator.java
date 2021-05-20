package br.com.zupacademy.anaflavia.casadocodigo.validacoes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.anaflavia.casadocodigo.livros.Livro;
import br.com.zupacademy.anaflavia.casadocodigo.livros.LivroDto;
import br.com.zupacademy.anaflavia.casadocodigo.livros.LivroRepository;

@Component
public class restricaoLivroValidator implements Validator {
	
	@Autowired
	private LivroRepository livroRepository;

	@Override
	public boolean supports(Class<?> clazz) {
	   return LivroDto.class.isAssignableFrom(clazz);	
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;	
		}
		
		LivroDto livroDto = (LivroDto) target;
		 Optional<Livro> candidato = livroRepository.findByTitulo(livroDto.getTitulo());
	       
		 if(candidato.isPresent()) {
			 errors.rejectValue("titulo", null,
					 "O titulo informado ja existe "  + livroDto.getTitulo());
		 }
	}

	
}
