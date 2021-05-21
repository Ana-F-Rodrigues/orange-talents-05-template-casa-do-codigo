package br.com.zupacademy.anaflavia.casadocodigo.cadastroEstado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.anaflavia.casadocodigo.cadastroPaís.Pais;
import br.com.zupacademy.anaflavia.casadocodigo.validacoes.ExisteId;
import br.com.zupacademy.anaflavia.casadocodigo.validacoes.UniqueValue;

public class EstadoDto {
	
	    @NotBlank
	    private String nome;

	    @NotNull
	    @ExisteId(domainClass = Pais.class, fieldName = "id", message = "O identificador do país não existe")
	    private Long idPais; 

	    public Estado converter(EntityManager em, EstadoRepository estadoRepository){
	        Pais pais = em.find(Pais.class, idPais);
	        if(pais != null) {
	            return new Estado(nome, pais);
	        }

	        return null;
	    }

	    public EstadoDto(@NotBlank String nome, @NotNull Long idPais) {
	        super();
	        this.nome = nome;
	        this.idPais = idPais;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public Long getIdPais() {
	        return idPais;
	    }

	    @Override
	    public String toString() {
	        return "EstadoDTO{" +
	                "nome='" + nome + '\'' +
	                ", idPais=" + idPais +
	                '}';
	    }

}
