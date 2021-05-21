package br.com.zupacademy.anaflavia.casadocodigo.fluxodePagamento;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.anaflavia.casadocodigo.cadastroEstado.Estado;
import br.com.zupacademy.anaflavia.casadocodigo.cadastroEstado.EstadoRepository;
import br.com.zupacademy.anaflavia.casadocodigo.cadastroPaís.Pais;
import br.com.zupacademy.anaflavia.casadocodigo.cadastroPaís.PaisRepository;
import br.com.zupacademy.anaflavia.casadocodigo.validacoes.ExisteId;
import br.com.zupacademy.anaflavia.casadocodigo.validacoes.UniqueValue;

public class ClienteDto {

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@Email
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;

	@CPFouCNPJ
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull
	@ExisteId(domainClass = Pais.class, fieldName = "id")
	private Long paisId;

	@ExisteId(domainClass = Estado.class, fieldName = "id")
	private Long estadoId;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public Long getPaisId() {
		return paisId;
	}

	public Long getEstadoId() {
		return estadoId;
	}

	public ClienteDto(@NotBlank String nome, @NotBlank String sobrenome, @Email @NotBlank String email,
			String documento, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade,
			@NotNull Long paisId, @NotBlank String telefone, @NotBlank String cep) {

		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisId = paisId;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Cliente converterCliente(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		Optional<Pais>  pais = paisRepository.findById(paisId);
		Cliente cliente = new Cliente(nome, sobrenome, email, documento,  endereco,  complemento,  cidade, pais.get(),  telefone,  cep);
	    if(estadoId!= null) {
	    	Optional<Estado>  estado = estadoRepository.findById(estadoId);
	    	cliente.setEstado(estado.get());
	    	 }
	       return cliente;
	
	}
	
	
	
	
	

}
