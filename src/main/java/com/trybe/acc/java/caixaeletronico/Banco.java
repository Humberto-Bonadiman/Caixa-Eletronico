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
  
  /**public PessoaCliente adicionarPessoaCliente (String nome, String cpf, String senha) {
   *  
   *}
   */
}
