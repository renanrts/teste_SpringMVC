package br.com.renantorres.negocio;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.renantorres.dominio.Produto;

public class ValidarDadosObrigatoriosProduto implements Validator{
	
	//A implementação desse método indica a qual classe a validação dará suporte. O que esse código faz é verificar se o objeto recebido para a validação tem uma assinatura da classe Produto. Com isso o Spring pode verificar se o objeto é uma instância daquela classe ou não.
	@Override
	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);
	}

	//o objeto errors não é gerenciado por nós, mas sim pelo Spring
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
		
		Produto produto = (Produto) target;
		
 		if (produto.getPaginas()<=0)
		{
			errors.rejectValue("paginas", "field.required");
		}
		
	}

}
