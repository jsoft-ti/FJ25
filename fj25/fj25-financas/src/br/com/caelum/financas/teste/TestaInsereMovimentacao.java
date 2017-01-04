package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereMovimentacao {

	public static void main(String[] args) {
		Movimentacao movimentacao = new Movimentacao();
		//movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("conta de luz agua");
		movimentacao.setValor(new BigDecimal("54"));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		MovimentacaoDao mdao = new MovimentacaoDao(manager);
		ContaDao cdao = new ContaDao(manager);
		
		manager.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setTitular("Jefão");
		conta.setBanco("Bradesco");
		conta.setNumero("678.456.23");
		conta.setAgencia("777");
		
		
		cdao.adiciona(conta);
		movimentacao.setConta(conta);
		//manager.persist(movimentacao);
		mdao.adiciona(movimentacao);
		manager.getTransaction().commit();
		manager.close();
		
	}
}
