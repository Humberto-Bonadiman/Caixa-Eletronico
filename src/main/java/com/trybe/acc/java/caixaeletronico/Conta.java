package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.List;

public class Conta {
  private String tipoConta;
  private String idConta;
  private PessoaCliente pessoaCliente;
  private ArrayList<Transacao> transacoes;
  private double saldo = 0.00;
  
  public Conta(String tipoConta, PessoaCliente pessoaCliente, Banco banco) {
    this.tipoConta = tipoConta;
    this.idConta = banco.gerarNumeroNovaConta();
    this.pessoaCliente = pessoaCliente;
  }
  
  public String getIdConta() {
    return idConta;
  }
  
  public List<Transacao> getTransacoes() {
    return transacoes;
  }

  public PessoaCliente getPessoaCliente() {
    return pessoaCliente;
  }
  
  public void adicionarTransacao(double quantia, String descricao) {
    Transacao novaTransacao = new Transacao(quantia, descricao);
    this.transacoes.add(novaTransacao);
  }
  
  public double retornarSaldo() {
    return this.saldo;
  }

}
