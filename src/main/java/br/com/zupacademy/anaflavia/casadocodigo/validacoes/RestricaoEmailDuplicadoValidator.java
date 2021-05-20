package br.com.zupacademy.anaflavia.casadocodigo.validacoes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.anaflavia.casadocodigo.autores.Autor;
import br.com.zupacademy.anaflavia.casadocodigo.autores.AutorDto;
import br.com.zupacademy.anaflavia.casadocodigo.autores.AutorRepository;

@Component
public class RestricaoEmailDuplicadoValidator implements Validator {
	
	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
	   return AutorDto.class.isAssignableFrom(clazz);	
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;	
		}
		
		AutorDto autorDto = (AutorDto) target;
		 Optional<Autor> candidatoAutor = autorRepository.findByEmail(autorDto.getEmail());
	       
		 if(candidatoAutor.isPresent()) {
			 errors.rejectValue("email", null,
					 "Ja existe cadastro com este email "  + autorDto.getEmail());
		 }
	}
	
	
	
}

