package com.controleconta.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller
 * @author Thiago Henrique Carvalho Prudente
 *
 */
@Controller
public class AppController {
	@RequestMapping("/")
    String home(ModelMap modal) {
        modal.addAttribute("title","Controle de Contas");
        return "index";
    }
	
	@RequestMapping("/partials/{page}")
    String partialHandler(@PathVariable("page") final String page) {
        return page;
    }
}	
