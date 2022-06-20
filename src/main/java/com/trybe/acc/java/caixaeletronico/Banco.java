package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.Random;

/**
 * Banco.
 *
 */
public class Banco {

  private ArrayList<PessoaCliente> pessoasClientes = new ArrayList<PessoaCliente>();
  private ArrayList<Conta> contas = new ArrayList<Conta>();
  /**
   * gerar numero nova conta.
   * 
   */

  /**
   * gerar numero nova conta.
   *
   */
  public String gerarNumeroNovaConta() {
    Random gerador = new Random();
    int numeroGerado = gerador.nextInt(2147483647);
    String result = String.format("%010d", numeroGerado);
    boolean idDuplicated =
        this.contas.stream().anyMatch(element -> element.getIdConta().contains(result));
    if (idDuplicated) {
      this.gerarNumeroNovaConta();
    }
    return result;
  }
  
  /**
   * adicionar pessoa cliente.
   */
  public PessoaCliente adicionarPessoaCliente(String nome, String cpf, String senha) {
    PessoaCliente cliente = new PessoaCliente(nome, cpf, senha);
    this.pessoasClientes.add(cliente);
    return cliente;
  }
  
  /**
   * pessoa cliente login.
   */
  public PessoaCliente pessoaClienteLogin(String cpf, String senha) {
    PessoaCliente contains = this.pessoasClientes.stream()
        .filter(e -> e.getCpf() == cpf && e.getSenha() == senha)
        .findFirst().orElse(null);
    return contains;
  }
  
  public void transferirFundos(
      PessoaCliente pessoaCliente,
      int daConta,
      int paraConta,
      double quantia
  ) {
    
  }
  
  /**
   * get Pessoas Clientes.
   *
   */
  public ArrayList<PessoaCliente> getPessoasClientes() {
    return pessoasClientes;
  }
  
}
