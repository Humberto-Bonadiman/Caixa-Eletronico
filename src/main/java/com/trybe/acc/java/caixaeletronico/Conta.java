package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.List;

public class Conta {
  private String tipoConta;
  private String idConta;
  private PessoaCliente pessoaCliente;
  private ArrayList<Transacao> transacoes;
  
  /**
   * Conta.
   */
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

  public String getTipoConta() {
    return tipoConta;
  }

  public PessoaCliente getPessoaCliente() {
    return pessoaCliente;
  }
  
  /**
   * adicionar transacao.
   */
  public void adicionarTransacao(double quantia, String descricao) {
    Transacao novaTransacao = new Transacao(quantia, descricao);
    this.transacoes = new ArrayList<Transacao>();
    transacoes.add(novaTransacao);
  }

  public String retornarResumoConta() {
    String saldoConta = String.format("%.2f", retornarSaldo()).replace(",", ".");
    return this.idConta + " : " + saldoConta + " : " + this.tipoConta;
  }
  
  /**
   * retornar saldo.
   */
  public double retornarSaldo() {
    double saldo = 0.0;
    if (this.transacoes != null) {
      for (Transacao transacao : this.transacoes) {
        saldo += transacao.getQuantia();
      }
    }
    return saldo;
  }
  
  /**
   * retornar Extrato.
   */
  public void retornarExtrato() {
    int totalTransacoes = transacoes.size();
    for (int indice = 0; indice < totalTransacoes; indice += 1) {
      System.out.println(transacoes.get(indice));
    }
  }

}
