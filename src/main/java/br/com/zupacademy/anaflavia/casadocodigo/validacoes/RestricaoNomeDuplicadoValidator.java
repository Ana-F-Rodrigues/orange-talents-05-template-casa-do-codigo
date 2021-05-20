package br.com.zupacademy.anaflavia.casadocodigo.validacoes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.anaflavia.casadocodigo.categoria.Categoria;
import br.com.zupacademy.anaflavia.casadocodigo.categoria.CategoriaDto;
import br.com.zupacademy.anaflavia.casadocodigo.categoria.CategoriaRepository;

@Component
public class RestricaoNomeDuplicadoValidator implements Validator {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
	   return CategoriaDto.class.isAssignableFrom(clazz);	
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;	
		}
		
		CategoriaDto categoriaDto = (CategoriaDto) target;
		 Optional<Categoria> candidatoCategoria = categoriaRepository.findByNome(categoriaDto.getNome());
	       
		 if(candidatoCategoria.isPresent()) {
			 errors.rejectValue("nome", null,
					 "Ja existe cadastro com este Nome "  + categoriaDto.getNome());
		 }
	}
}
