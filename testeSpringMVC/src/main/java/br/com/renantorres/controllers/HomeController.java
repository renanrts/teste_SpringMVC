package br.com.renantorres.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//anotação para indicar que a classe é uma controller no Spring MVC

@Controller
public class HomeController {

	//anotacao para indicar o mapeamento das urls, no caso, o '/
    @RequestMapping("/")
    public String home() {
        System.out.println("Exibindo a home da CDC");
        return "home";
    }
}
