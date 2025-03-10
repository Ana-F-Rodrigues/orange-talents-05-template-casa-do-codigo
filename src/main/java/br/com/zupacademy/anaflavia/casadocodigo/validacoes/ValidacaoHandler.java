package br.com.zupacademy.anaflavia.casadocodigo.validacoes;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ValidacaoHandler {
	
	@Autowired
	private MessageSource messageSource;
	
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroFormularioDto> handle(MethodArgumentNotValidException exception) {
		List<ErroFormularioDto> dto = new ArrayList<>();
		
    	List<FieldError> fielErrors = exception.getBindingResult().getFieldErrors();
    	    fielErrors.forEach(e ->{
    		String mensagem = messageSource.getMessage(e,LocaleContextHolder.getLocale());
    		ErroFormularioDto erro = new ErroFormularioDto(e.getField(), mensagem);
    		dto.add(erro);
    	});
    	return dto;
	}
	

}
