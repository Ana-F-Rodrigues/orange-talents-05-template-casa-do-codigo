package br.com.zupacademy.anaflavia.casadocodigo.fluxodePagamento;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.anaflavia.casadocodigo.cadastroEstado.EstadoRepository;
import br.com.zupacademy.anaflavia.casadocodigo.cadastroPaís.PaisRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private RestricaoEstadoPertecePaisValidator restricaoaEstadoPertecencePaisValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		
		binder.addValidators(restricaoaEstadoPertecencePaisValidator);
		
	}
	
	@Autowired
	private ClienteRepository clienteRepository;
	@PostMapping
	public String Cadastrar(@RequestBody @Valid ClienteDto clienteDto) {
		
		Cliente cliente = clienteDto.converterCliente(paisRepository, estadoRepository);
		cliente = clienteRepository.save(cliente);
		return cliente.toString();
}
	

	

}
