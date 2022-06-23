package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

public class PessoaCliente {
  private String nomeCompleto;
  private String cpf;
  private String senha;
  private ArrayList<Conta> contas = new ArrayList<Conta>();

  /**
   * pessoa cliente.
   */
  public PessoaCliente(String nome, String cpf, String senha) {
    this.nomeCompleto = nome;
    this.cpf = cpf;
    this.senha = senha;
    String mensagem = "Nova pessoa cliente " + nome + " com " + cpf + " foi criada!";
    System.out.print(mensagem);
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
    return this.contas.get(indice).retornarSaldo();
  }

  /**
   * retornar id conta especifica.
   */
  public String retornarIdContaEspecifica(int indice) {
    return this.contas.get(indice).getIdConta();
  }

  /**
   * retornar extrato contato especifica.
   */
  public void retornarExtratoContaEspecifica(int indice) {
    this.contas.get(indice).retornarExtrato();
  }
  
  /**
   * adicionar transacao conta especifica.
   */
  public void adicionarTransacaoContaEspecifica(
      int indice,
      double quantia,
      String descricao
  ) {
    this.contas.get(indice).adicionarTransacao(quantia, descricao);
  }

  /**
   * validar senha.
   */
  public boolean validarSenha(String senha) {
    return this.senha.equals(senha);
  }
  
  /**
   * retornar resumo contas.
   */
  public void retornarResumoContas() {
    for (int indice = 1; indice <= contas.size(); indice += 1) {
      System.out.println(this.contas.get(indice - 1).retornarResumoConta());
    }
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
