package br.com.zupacademy.anaflavia.casadocodigo.cadastroPaís;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank
	    private String nome;

	    public Pais() {
	    }


	    public Pais(String nome) {
	        this.nome = nome;
	    }

	    @Override
	    public String toString() {
	        return "Pais{" +
	                "id=" + id +
	                ", nome='" + nome + '\'' +
	                '}';
	    }
}



