package br.com.zupacademy.anaflavia.casadocodigo.livros;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.zupacademy.anaflavia.casadocodigo.autores.DetalheAutorDto;

public class DetalheLivroDto {
	
	
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    
 
    
  
    

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

	public DetalheAutorDto getAutor() {
		return autor;
	}

	private DetalheAutorDto autor;

    public DetalheLivroDto(Livro livro) {
        titulo = livro.getTitulo();
        resumo = livro.getResumo();
        sumario = livro.getSumario();
        preco = livro.getPreco();
        numeroPaginas = livro.getNumeroPaginas();
        isbn = livro.getIsbn();
		dataPublicacao = livro.getDataPublicacao();
        autor = new DetalheAutorDto(livro.getAutor());
    }

}