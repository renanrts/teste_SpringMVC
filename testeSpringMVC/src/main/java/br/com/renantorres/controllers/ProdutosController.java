package br.com.renantorres.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.renantorres.dao.ProdutoDAO;
import br.com.renantorres.dominio.Produto;
import br.com.renantorres.dominio.TipoPreco;

@Controller
@RequestMapping("produtos")
public class ProdutosController {
	
	//para que ele seja injetado
	 @Autowired
	 private ProdutoDAO dao;
	
	//anotacao para indicar o mapeamento das urls, no caso, o '/
    @RequestMapping("/form")
    public ModelAndView form() {
    	//mandar um objeto - modelandview adiciona um atributo - pegar um objeto da model e envia para a view - ele tem no construtor a url
    	ModelAndView modelAndView = new ModelAndView("produtos/form");
    	//enviando uma string que indica o nome do objeto como primeiro parâmetro e os valores do objeto como segundo parâmetro
    	modelAndView.addObject("tipos", TipoPreco.values());
        return modelAndView;
    }
    
    @RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravar(Produto produto, RedirectAttributes redirectAttributes){
		System.out.println(produto);
		dao.gravar(produto);
		//Atributos do tipo Flash inserido pois há uma nova requisição por conta do redirecionamento. Eles só duram até a próxima requisição, ou seja, transportam informações de uma requisição para a outra e, então, deixam de existir
		redirectAttributes.addFlashAttribute("sucesso","Produto cadastrado com sucesso!");
		//redirect, que passa um status para o navegador carregar uma outra página e esquecer dos dados da requisição anterior. O status que o navegador recebe é um 302.
		return new ModelAndView("redirect:produtos");
	}
    
    //para diferenciar o mapeamento entre o gravar e o listar. o List está como GET pois é um parametro vindo pela URL direto
    @RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar(){
		List<Produto> produtos = dao.listar();
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("produtos", produtos);
		return modelAndView;
	}

}
