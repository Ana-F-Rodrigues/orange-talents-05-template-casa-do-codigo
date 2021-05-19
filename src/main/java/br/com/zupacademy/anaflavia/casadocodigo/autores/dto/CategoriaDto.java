package br.com.zupacademy.anaflavia.casadocodigo.autores.dto;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.anaflavia.casadocodigo.autores.Categoria;

public class CategoriaDto {

	@NotBlank
	private String nome;
	

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public Categoria converterCategoria(CategoriaDto categoriaDto) {
		
		Categoria categoria = new Categoria(categoriaDto.getNome());
		
		return categoria;
		
	}
}
