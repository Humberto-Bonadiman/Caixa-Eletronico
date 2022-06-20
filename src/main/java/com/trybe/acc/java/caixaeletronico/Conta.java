package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.List;

public class Conta {
  private String tipoConta;
  private String idConta;
  private PessoaCliente pessoaCliente;
  private ArrayList<Transacao> transacoes;
  private double saldo = 0.00;
  
  /**
   * 
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

  public PessoaCliente getPessoaCliente() {
    return pessoaCliente;
  }
  
  public void adicionarTransacao(double quantia, String descricao) {
    Transacao novaTransacao = new Transacao(quantia, descricao);
    this.transacoes.add(novaTransacao);
  }
  
  public String retornarResumoConta() {
    String saldoConta = String.format("%.2f", this.saldo).replace(",", ".");
    return this.idConta + " : " + saldoConta + " : " + this.tipoConta;
  }
  
  public double retornarSaldo() {
    return this.saldo;
  }
  
  public void retornarExtrato() {
    int totalTransacoes = transacoes.size();
    for (int indice = 0; indice < totalTransacoes; indice += 1) {
      System.out.println(transacoes.get(indice));
    }
  }

}
