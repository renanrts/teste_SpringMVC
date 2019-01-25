package br.com.renantorres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.renantorres.dao.ProdutoDAO;
import br.com.renantorres.dominio.Produto;

@Controller
public class ProdutosController {
	
	//para que ele seja injetado
	 @Autowired
	 private ProdutoDAO dao;
	
	//anotacao para indicar o mapeamento das urls, no caso, o '/
    @RequestMapping("/produtos/form")
    public String form() {
        return "produtos/form";
    }
    
    @RequestMapping("/produtos")
	public String gravar(Produto produto){
		System.out.println(produto);
		dao.gravar(produto);
		return "produtos/ok";
	}

}
