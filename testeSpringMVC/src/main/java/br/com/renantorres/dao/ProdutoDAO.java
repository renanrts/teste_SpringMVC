package br.com.renantorres.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.renantorres.dominio.Produto;

// ProdutoDAO é um recurso persistente (persiste dados) dentro do sistema, portanto, anote-o com @Repository. E embora o Spring esteja configurado para gerenciar as transações, ainda é necessário indicar que o ProdutoDAO precisa de uma transação. Faça isso anotando-o com @Transactional

@Repository
@Transactional
public class ProdutoDAO {

	//comunicação com o banco de dados 
	//para que ele seja injetável
    @PersistenceContext
    private EntityManager manager;

    public void gravar(Produto produto) {
        manager.persist(produto);
    }
}
