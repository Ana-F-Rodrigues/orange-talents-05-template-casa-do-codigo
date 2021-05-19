package br.com.zupacademy.anaflavia.casadocodigo.autores.dto;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.anaflavia.casadocodigo.categoria.Categoria;
import br.com.zupacademy.anaflavia.casadocodigo.validacoes.UniqueValue;

public class CategoriaDto {
	
	
	
	@NotBlank
	 @UniqueValue(domainClass = Categoria.class, 
					  fieldName = "nome", 
					 message = "A categoria informada já existe")
	private String nome;
	
	
	 public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Categoria converter() {
		 return new Categoria(this.nome);
		
	}

	 
}

