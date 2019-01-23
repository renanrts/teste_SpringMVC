package br.com.renantorres.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.renantorres.dominio.Produto;

@Controller
public class ProdutosController {
	
	//anotacao para indicar o mapeamento das urls, no caso, o '/
    @RequestMapping("/produtos/form")
    public String form() {
        return "produtos/form";
    }
    
    @RequestMapping("/produtos")
    public String gravar(Produto produto) {
        System.out.println(produto);
        return "produtos/ok";
    }

}
