package br.com.zupacademy.anaflavia.casadocodigo.livros;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.anaflavia.casadocodigo.autores.Autor;
import br.com.zupacademy.anaflavia.casadocodigo.autores.AutorRepository;
import br.com.zupacademy.anaflavia.casadocodigo.categoria.Categoria;
import br.com.zupacademy.anaflavia.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.anaflavia.casadocodigo.validacoes.ExisteId;
import br.com.zupacademy.anaflavia.casadocodigo.validacoes.UniqueValue;

public class LivroDto {

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "O titulo informado já existe")
	private String titulo;

	@NotBlank
	@Size(max = 500)
	private String resumo;

	private String sumario;

	@NotNull
	private BigDecimal preco;

	@Min(100)
	private Integer numeroPaginas;
    
	@NotBlank
//	@ISBN
	@UniqueValue(domainClass = Livro.class, fieldName = "ISBN", message = "O ISBN informado já existe")
	private String isbn;

	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataPublicacao;

	@ExisteId(domainClass= Categoria.class, fieldName="id")
	private Long categoria;

	@ExisteId(domainClass= Autor.class, fieldName="id")
	private Long autor;
	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Long getCategoria() {
		return categoria;
	}

	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}

	public Long getAutor() {
		return autor;
	}

	public void setAutor(Long autor) {
		this.autor = autor;
	}

	public Livro converter(LivroDto livroDto, CategoriaRepository categoriaRepository,
			AutorRepository autorRepository) {

		Autor autor = autorRepository.getOne(livroDto.getAutor());
		Categoria categoria = categoriaRepository.getOne(livroDto.getCategoria());

		return new Livro(livroDto.getTitulo(), livroDto.getResumo(), livroDto.getSumario(), livroDto.getPreco(),
				livroDto.getNumeroPaginas(), livroDto.getIsbn(), livroDto.getDataPublicacao(), autor, categoria);
	}

}
