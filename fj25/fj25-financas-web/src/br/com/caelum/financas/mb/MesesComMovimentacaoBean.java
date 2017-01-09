package br.com.caelum.financas.mb;


import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.modelo.ValorPorMesEAno;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MesesComMovimentacaoBean {

	@Inject
	private MovimentacaoDao dao;
	private List<ValorPorMesEAno> valoresPorMesEAno;
	private Conta conta = new Conta();

	private TipoMovimentacao tipoMovimentacao;
	
	public void lista() {
		valoresPorMesEAno = dao.listaMesesComMovimentacoes(this.conta, this.tipoMovimentacao);
		System.out.println("Listando as contas pelos valores movimentados no mes");

	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Conta getConta() {
		return conta;
	}

	public List<ValorPorMesEAno> getValoresPorMesEAno(){
		return valoresPorMesEAno;
	}
}
