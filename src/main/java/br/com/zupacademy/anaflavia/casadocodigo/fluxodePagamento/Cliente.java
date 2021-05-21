package br.com.zupacademy.anaflavia.casadocodigo.fluxodePagamento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.anaflavia.casadocodigo.cadastroEstado.Estado;
import br.com.zupacademy.anaflavia.casadocodigo.cadastroPaís.Pais;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@Email
	@NotBlank
	private String email;

	
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull
	@ManyToOne
	private Pais pais;

	@ManyToOne
	private Estado estado;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public Cliente() {

	}
    
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", documento="
				+ documento + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade
				+ ", pais=" + pais + ", estado=" + estado + ", telefone=" + telefone + ", cep=" + cep + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


	public Cliente(@NotBlank String nome, @NotBlank String sobrenome, @Email @NotBlank String email,
			String documento, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade,
			@NotNull Pais pais, @NotBlank String telefone, @NotBlank String cep) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	

}
