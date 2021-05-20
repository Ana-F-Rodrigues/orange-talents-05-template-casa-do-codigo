package br.com.zupacademy.anaflavia.casadocodigo.livros;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.anaflavia.casadocodigo.validacoes.UniqueValue;

public class LivroDtoLista {


	    private Long id;

	    @NotBlank
	    @UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "O título informado já existe")
	    private String titulo;

	    public LivroDtoLista() {
	    }

	    public LivroDtoLista(Long id, String titulo) {
	        this.id = id;
	        this.titulo = titulo;
	    }

	  

	    public Long getId() {
			return id;
		}

		public String getTitulo() {
			return titulo;
		}

		public List<LivroDtoLista> converterLista(List<Livro> listaLivros) {
	        List<LivroDtoLista> livros = new ArrayList<>();
	        for (Livro livro:listaLivros) {
	            livros.add(new LivroDtoLista(livro.getId(), livro.getTitulo()));
	           
	        }
	        return livros;
	    }
	}
