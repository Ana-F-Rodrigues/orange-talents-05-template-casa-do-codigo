package br.com.zupacademy.anaflavia.casadocodigo.cadastroPaís;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisController {
	
	    @Autowired
	    private PaisRepository paisRepository;

	    @Transactional
	    @PostMapping
	    public ResponseEntity cadastra(@RequestBody @Valid PaisDto paisDto){
	        paisRepository.save(new Pais(paisDto.getNome()));
	        return ResponseEntity.ok().build();
	    }


}
