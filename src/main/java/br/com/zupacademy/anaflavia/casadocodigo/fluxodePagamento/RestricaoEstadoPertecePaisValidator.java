package br.com.zupacademy.anaflavia.casadocodigo.fluxodePagamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.anaflavia.casadocodigo.cadastroEstado.Estado;
import br.com.zupacademy.anaflavia.casadocodigo.cadastroEstado.EstadoRepository;
@Component
public class RestricaoEstadoPertecePaisValidator implements Validator{
	
	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public boolean supports(Class<?> clazz) {
	   return ClienteDto.class.isAssignableFrom(clazz);	
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;	
		}
		
		ClienteDto clienteDto = (ClienteDto)target;
		List<Estado> estados = estadoRepository.findByPaisId(clienteDto.getPaisId());	
		if(estados.size()>= 1 && clienteDto.getEstadoId()== null) {
			errors.rejectValue("estadoId", null, "Este país possui estados, então você deve selecionar um");
		
		}
		if(clienteDto.getEstadoId() != null && estadoNaoPertence(estados, clienteDto)) {
			errors.rejectValue("estadoId", null, "Este Estado não pertence a este Pais");
			
			
		}
		
	

	}
	
	private boolean estadoNaoPertence(List<Estado> estados, ClienteDto clienteDto) {
		
		for (Estado estado : estados) {
			if(clienteDto.getEstadoId()== estado.getId()) {
				return false;
			}
		
		} 
		return true;
		
		
		
	}
	
	

}
