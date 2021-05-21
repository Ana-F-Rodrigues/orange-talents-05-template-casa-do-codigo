package br.com.zupacademy.anaflavia.casadocodigo.cadastroEstado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.zupacademy.anaflavia.casadocodigo.cadastroPaís.ValidacaoPaisEstado;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	
	@PersistenceContext
    private EntityManager em;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ValidacaoPaisEstado estadoPaisValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(estadoPaisValidator);
    }


    @Transactional
    @PostMapping
    public ResponseEntity cadastra(@RequestBody @Valid EstadoDto estadoDto){
        System.out.println(estadoDto.toString());
        System.out.println("-------");
        Estado estado = estadoDto.converter(em,estadoRepository);
        if(estado != null) {
            em.persist(estado);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
