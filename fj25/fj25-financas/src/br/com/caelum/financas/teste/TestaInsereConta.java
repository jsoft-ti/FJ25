package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereConta {
	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("controlefinancas");
		//EntityManager manager = factory.createEntityManager();
		
		EntityManager manager = new JPAUtil().getEntityManager();
		ContaDao dao = new ContaDao(manager);
		
		Conta conta = new Conta();
		conta.setTitular("João Carlos");
		conta.setBanco("Safra");
		conta.setNumero("3654.456.42");
		conta.setAgencia("3333");
		
		manager.getTransaction().begin();
		dao.adiciona(conta);
		
		Conta encontrado = dao.busca(4);
		System.out.println(encontrado.getTitular());
		
		
		System.out.println("Conta gravada com sucesso");
		long fim = System.currentTimeMillis();
		System.out.println(String.format("Inicio %d Fim %d" , inicio,fim));
		System.out.println("----------------------" );
		
		Conta modificada = dao.busca(7);
		conta.setTitular("Modificado");
		conta.setBanco("Bradesco");
		
		
		List<Conta> lista = dao.lista();
		for(Conta conta1: lista){
			System.out.println(String.format("%s    %s      %s", conta1.getNumero(),conta1.getBanco(),conta1.getTitular()));
		}
		
		manager.getTransaction().commit();
		manager.close();
	}
	
	

}
