package br.com.zupacademy.anaflavia.casadocodigo.cadastroPaís;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.anaflavia.casadocodigo.validacoes.UniqueValue;

public class PaisDto {
	
	@NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "O país informado já existe")
    private String nome;

    public PaisDto() {
    }

    public PaisDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
     
    }

	public void setNome(String nome) {
		this.nome = nome;
	}
    
    
}

