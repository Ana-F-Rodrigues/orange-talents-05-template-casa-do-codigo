package br.com.zupacademy.anaflavia.casadocodigo.cadastroEstado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.zupacademy.anaflavia.casadocodigo.cadastroPaís.Pais;

@Entity
public class Estado {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String nome;

	    @ManyToOne
	    private Pais pais; 

	    public Estado() {
	    }

	    public Estado(String nome, Pais pais) {
	        this.nome = nome;
	        this.pais = pais;
	    }

	    @Override
	    public String toString() {
	        return "Estado{" +
	                "id=" + id +
	                ", nome='" + nome + '\'' +
	                ", pais=" + pais +
	                '}';
	    }

		public Long getId() {
			return id;
		}

}
