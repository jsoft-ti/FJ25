package br.com.caelum.financas.teste;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaBuscaContaMovimentacao {
	public static void main(String[] args) {
		MovimentacaoDao mdao = new MovimentacaoDao(new JPAUtil().getEntityManager());
		System.out.println(String.format("Titular da movimentacao 1 %s" ,mdao.busca(1).getConta().getTitular()));
	}
	

}
