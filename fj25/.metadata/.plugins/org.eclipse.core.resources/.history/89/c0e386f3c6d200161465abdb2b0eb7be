package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereMovimentacao {

	public static void main(String[] args) {
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("conta de luz abril 2010");
		movimentacao.setValor(new BigDecimal("54"));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setTitular("Jefão");
		conta.setBanco("Bradesco");
		conta.setNumero("678.456.23");
		conta.setAgencia("777");
		manager.persist(conta);
		movimentacao.setConta(conta);
		manager.persist(movimentacao);
		
		manager.getTransaction().commit();
		manager.close();
		
	}
}
