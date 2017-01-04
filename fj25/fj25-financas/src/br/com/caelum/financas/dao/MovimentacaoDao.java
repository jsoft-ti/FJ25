package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;

public class MovimentacaoDao {
	public static EntityManager manager;
	
	public MovimentacaoDao(EntityManager manager){
		this.manager = manager;
	}
	public void adiciona(Movimentacao movimentacao){
		this.manager.persist(movimentacao);
	}
	
	
	public Movimentacao busca(int id){
		return this.manager.find(Movimentacao.class, id);
	}
	
	public List<Movimentacao> lista(){
		return this.manager.createQuery("selec m from Movimentacao m").getResultList();
	}
	
	public void remove (Movimentacao movimentacao){
		this.manager.remove(movimentacao);
	}

}
