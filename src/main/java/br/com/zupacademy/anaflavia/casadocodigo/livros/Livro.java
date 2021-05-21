package br.com.zupacademy.anaflavia.casadocodigo.livros;

import java.math.BigDecimal;
import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.anaflavia.casadocodigo.autores.Autor;
import br.com.zupacademy.anaflavia.casadocodigo.categoria.Categoria;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	@NotBlank
	private String sumario;
	
	@NotNull
	@Min(20)
	private BigDecimal preco;
	

	@Min(100)
	private Integer numeroPaginas;
	
	@NotBlank
	private String isbn;
	
	@Future
	private LocalDate dataPublicacao;

	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Autor autor;
	
	@Deprecated
	public  Livro() {
		
	}
	
	
	
	public Long getId() {
		return id;
	}



	public String getTitulo() {
		return titulo;
	}
	
	
	



	public String getResumo() {
		return resumo;
	}



	public String getSumario() {
		return sumario;
	}



	public BigDecimal getPreco() {
		return preco;
	}



	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}



	public String getIsbn() {
		return isbn;
	}



	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}



	public Categoria getCategoria() {
		return categoria;
	}



	public Autor getAutor() {
		return autor;
	}



	public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroPaginas,
			String isbn,LocalDate dataPublicacao, Autor autor, Categoria categoria) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
		this.categoria = categoria;
		
		
	}

	
}
	
	
	

