package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteCacheSegundoNivel {
public static void main(String[] args) {
	EntityManager primeiraEM = new JPAUtil().getEntityManager();
	
	primeiraEM.getTransaction().begin();
	Conta primeiraConta = primeiraEM.find(Conta.class, 15);
	primeiraEM.getTransaction().commit();
	
	primeiraEM.close();
	
	
EntityManager segundaEM1 = new JPAUtil().getEntityManager();
	
	segundaEM1.getTransaction().begin();
	Conta segundaConta1 = segundaEM1.find(Conta.class, 15);
	segundaConta1.setTitular("Fabiano 2");
	segundaEM1.getTransaction().commit();
	
	EntityManager segundaEM = new JPAUtil().getEntityManager();
	
	segundaEM.getTransaction().begin();
	Conta segundaConta = segundaEM.find(Conta.class, 15);
	segundaEM.getTransaction().commit();
	
	segundaEM.close();
	
	System.out.println("Titular da primeira conta "+primeiraConta.getTitular());
	System.out.println("Titular da segunda conta "+segundaConta.getTitular());
}
}
