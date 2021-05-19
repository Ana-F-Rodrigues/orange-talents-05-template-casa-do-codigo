package br.com.zupacademy.anaflavia.casadocodigo.autores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.anaflavia.casadocodigo.autores.dto.CategoriaDto;
import br.com.zupacademy.anaflavia.casadocodigo.validacoes.RestricaoNomeDuplicadoValidator;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private RestricaoNomeDuplicadoValidator restricaoNomeDuplicadoValidator;
	

	@InitBinder
	public void init(WebDataBinder binder) {
		
		binder.addValidators(restricaoNomeDuplicadoValidator);
		
		
      }
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@PostMapping
	public ResponseEntity<CategoriaDto> Cadastrar (@RequestBody @Valid CategoriaDto categoriaDto) {
		
		Categoria categoria = categoriaDto.converterCategoria(categoriaDto);
		categoria = categoriaRepository.save(categoria);
		return ResponseEntity.ok().body(categoriaDto);
}
	
	
}
