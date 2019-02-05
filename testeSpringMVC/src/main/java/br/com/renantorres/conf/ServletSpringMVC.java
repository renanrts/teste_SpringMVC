package br.com.renantorres.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{


	    @Override
	    protected Class<?>[] getRootConfigClasses() {
	        return null;
	    }

	    //para o Spring encontrar a classe JPAConfiguration
	    @Override
	    protected Class<?>[] getServletConfigClasses() {
	        return new Class[] { AppWebConfiguration.class, JPAConfiguration.class};
	    }

	    @Override
	    protected String[] getServletMappings() {
	        return new String[] {"/"};
	    }
	 
	 

	}

