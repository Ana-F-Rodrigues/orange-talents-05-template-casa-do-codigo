package br.com.zupacademy.anaflavia.casadocodigo.livros;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livroDetalhe")
public class DetalheLivroController {

	        
	    @Autowired
	    private LivroRepository livroRepository;

	    @GetMapping(value = "/{id}")
	    public ResponseEntity<?> detalhe(@PathVariable("id") Long id) {
	        
	        Optional<Livro> livroOp = livroRepository.findById(id);
	       
	        if (livroOp.isPresent()) {
	            DetalheLivroDto detalheSiteLivroResponse = new DetalheLivroDto(livroOp.get());
	            return ResponseEntity.ok(detalheSiteLivroResponse);
	        }

	        return ResponseEntity.notFound().build();
	    }

}
