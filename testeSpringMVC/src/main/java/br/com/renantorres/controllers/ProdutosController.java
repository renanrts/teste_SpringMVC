package br.com.renantorres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.renantorres.dao.ProdutoDAO;
import br.com.renantorres.dominio.Produto;
import br.com.renantorres.dominio.TipoPreco;

@Controller
public class ProdutosController {
	
	//para que ele seja injetado
	 @Autowired
	 private ProdutoDAO dao;
	
	//anotacao para indicar o mapeamento das urls, no caso, o '/
    @RequestMapping("/produtos/form")
    public ModelAndView form() {
    	//mandar um objeto - modelandview adiciona um atributo - pegar um objeto da model e envia para a view - ele tem no construtor a url
    	ModelAndView modelAndView = new ModelAndView("produtos/form");
    	//enviando uma string que indica o nome do objeto como primeiro parâmetro e os valores do objeto como segundo parâmetro
    	modelAndView.addObject("tipos", TipoPreco.values());
        return modelAndView;
    }
    
    @RequestMapping("/produtos")
	public String gravar(Produto produto){
		System.out.println(produto);
		dao.gravar(produto);
		return "produtos/ok";
	}

}
