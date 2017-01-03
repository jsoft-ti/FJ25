package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereConta {
	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("controlefinancas");
		//EntityManager manager = factory.createEntityManager();
		
		EntityManager manager = new JPAUtil().getEntityManager();
		Conta conta = new Conta();
		conta.setTitular("João Carlos");
		conta.setBanco("Safra");
		conta.setNumero("3654.456.42");
		conta.setAgencia("1285");
		
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println("Conta gravada com sucesso");
		long fim = System.currentTimeMillis();
		System.out.println(String.format("Inicio %i Fim %i" , inicio,fim));
	}
	
	

}
