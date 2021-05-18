package br.com.zupacademy.anaflavia.casadocodigo.autores.dto;

import java.time.OffsetDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.anaflavia.casadocodigo.autores.Autor;

public class  AutorDto {

	@NotNull
	@NotEmpty 
    @Length(max = 30)
	private String nome;
	
	@NotNull
	@NotEmpty 
	@Length(max = 30)
 	@Email
	private String email;
	
	@NotNull
	@NotEmpty 
	@Length(max = 400)
	private String descricao;
	
	
	private OffsetDateTime dataCriacao = OffsetDateTime.now();
	
	
	
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getDescricao() {
		return descricao;
	}
	
	
	public OffsetDateTime getDataCriacao() {
		return dataCriacao;
	}
	public Autor converterAutor(AutorDto autorDto) {
		
		Autor autor = new Autor(autorDto.getNome(), autorDto.getEmail(), autorDto.getDescricao(),autorDto.getDataCriacao());
		
		return autor;
		
	}
	
	

}
