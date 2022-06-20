package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

public class PessoaCliente {
  private String nomeCompleto;
  private String cpf;
  private String senha;
  private ArrayList<Conta> contas;

  /**
   * pessoa cliente.
   */
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

  /**
   * retornar saldo conta especifica.
   */
  public double retornarSaldoContaEspecifica(int indice) {
    Conta conta = this.contas.get(indice);
    double saldo = conta.retornarSaldo();
    return saldo;
  }

  /**
   * retornar id conta especifica.
   */
  public String retornarIdContaEspecifica(int indice) {
    Conta conta = this.contas.get(indice);
    String idConta = conta.getIdConta();
    return idConta;
  }

  public void retornarExtratoContaEspecifica(int indice) {
    this.contas.get(indice).retornarExtrato();
  }

  /**
   * validar senha.
   */
  public boolean validarSenha(String senha) {
    if (senha == this.senha) {
      return true;
    }
    return false;
  }

  public void retornarResumoContas() {
    getContas();
  }

  public ArrayList<Conta> getContas() {
    return contas;
  }

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
