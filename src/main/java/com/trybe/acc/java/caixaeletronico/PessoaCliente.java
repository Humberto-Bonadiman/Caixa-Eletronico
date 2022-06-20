package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

public class PessoaCliente {
  private String nomeCompleto;
  private String cpf;
  private String senha;
  private ArrayList<Conta> contas;

  public PessoaCliente(String nome, String cpf, String senha) {
	this.nomeCompleto = nome;
	this.cpf = cpf;
	this.senha = senha;
	System.out.println("Nova pessoa cliente " + nome + " com " + cpf + " foi criada!");
  }
  
  public void adicionarConta(Conta conta) {
    this.contas.add(conta);
  }
  
  public int retornaNumeroDeContas() {
    return this.contas.size();
  }
  
  public double retornarSaldoContaEspecifica(int indice) {
    Conta conta = this.contas.get(indice);
    double saldo = conta.retornarSaldo();
    return saldo;
  }
  
  public String retornarIdContaEspecifica(int indice) {
    Conta conta = this.contas.get(indice);
    String idConta = conta.getIdConta();
    return idConta;
  }
  
  // faltam 4 métodos

  public String getNomeCompleto() {
    return nomeCompleto;
  }

  public String getCpf() {
    return cpf;
  }

  public String getSenha() {
    return senha;
  }
}
