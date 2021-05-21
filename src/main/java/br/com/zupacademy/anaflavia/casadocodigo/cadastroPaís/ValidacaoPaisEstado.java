package br.com.zupacademy.anaflavia.casadocodigo.cadastroPaís;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.anaflavia.casadocodigo.cadastroEstado.Estado;
import br.com.zupacademy.anaflavia.casadocodigo.cadastroEstado.EstadoDto;
import br.com.zupacademy.anaflavia.casadocodigo.cadastroEstado.EstadoRepository;

@Component
public class ValidacaoPaisEstado implements Validator {
	
	   @Autowired
	    private EstadoRepository estadoRepository;

	    @Override
	    public boolean supports(Class<?> clazz) {
	        return EstadoDto.class.isAssignableFrom(clazz);
	    }

	    @Override
	    public void validate(Object target, Errors errors) {
	        if(errors.hasErrors()){ return; }

	        EstadoDto estadoDto = (EstadoDto) target;
	        List<Estado> listaEstados = estadoRepository.findByNomePais(estadoDto.getNome(), estadoDto.getIdPais());

	        if(listaEstados.size() > 0){
	            errors.rejectValue("nome", null, "Já existe um estado com o nome informado neste país");
	            System.out.println("Já existe um estado com o nome informado neste país");
	        }
	    }
	
	
	
	

}
