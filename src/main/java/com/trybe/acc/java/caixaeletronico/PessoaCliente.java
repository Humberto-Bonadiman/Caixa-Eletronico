package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

public class PessoaCliente {
  private String nomeCompleto;
  private String cpf;
  private String senha;
  private ArrayList<Conta> contas;

  public PessoaCliente(String nome, String cpf2, String senha2) {
	// TODO Auto-generated constructor stub
  }

public String getCpf() {
    return cpf;
  }

  public String getSenha() {
    return senha;
  }
}
