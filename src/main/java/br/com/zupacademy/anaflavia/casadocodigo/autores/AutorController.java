package br.com.zupacademy.anaflavia.casadocodigo.autores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.anaflavia.casadocodigo.autores.dto.AutorDto;

@RestController
@RequestMapping("/autor")
public class AutorController{
	
	@Autowired
	private AutorRepository autorRepository;
	@PostMapping
	public ResponseEntity<AutorDto> Cadastrar(@RequestBody @Valid AutorDto autorDto) {
		
		Autor autor = autorDto.converterAutor(autorDto);
		autor = autorRepository.save(autor);
		return ResponseEntity.ok().body(autorDto);
}
	
	
	
	
	
	
	

}
