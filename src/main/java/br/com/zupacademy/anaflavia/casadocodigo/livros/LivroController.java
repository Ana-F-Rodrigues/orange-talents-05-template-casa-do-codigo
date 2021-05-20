package br.com.zupacademy.anaflavia.casadocodigo.livros;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.anaflavia.casadocodigo.autores.AutorRepository;
import br.com.zupacademy.anaflavia.casadocodigo.categoria.CategoriaRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@GetMapping
	public List<LivroDtoLista> listar(){
		List<Livro>listaLivros = (List<Livro>) livroRepository.findAll();
		LivroDtoLista livroDtoLista = new LivroDtoLista();
		return livroDtoLista.converterLista(listaLivros);
				
	}
	

	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	public ResponseEntity<LivroDto> Cadastrar (@RequestBody @Valid LivroDto livroDto) {
	   System.out.println(livroDto.getIsbn());
		Livro livro = livroDto.converter(livroDto, categoriaRepository, autorRepository);
		livro = livroRepository.save(livro);
		return ResponseEntity.ok().body(livroDto);


}
	
}
