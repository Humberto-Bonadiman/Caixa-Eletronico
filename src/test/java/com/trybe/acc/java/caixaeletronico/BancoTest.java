package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes para a classe Banco")
class BancoTest {

  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  public void gerarNumeroNovaContaTest() {
	Banco banco = new Banco();
	int length = banco.gerarNumeroNovaConta().length();
	assertEquals(10, length);
  }

  @Test
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
	Banco banco = new Banco();
    PessoaCliente cliente = banco.adicionarPessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    assertEquals(cliente, banco.getPessoasClientes().get(0));
  }

  @Test
  @DisplayName("3 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    Banco banco = new Banco();
    PessoaCliente cliente = banco.adicionarPessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    PessoaCliente retornaCliente = banco.pessoaClienteLogin("842.074.410-77", "1234");
    PessoaCliente naoRetornaCliente = banco.pessoaClienteLogin("842.074.410-79", "123456");
    assertEquals(retornaCliente, cliente);
    assertEquals(naoRetornaCliente, null);
  }

  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    Banco banco = new Banco();
    PessoaCliente cliente = banco.adicionarPessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    banco.adicionarConta("Corrente", cliente);
    banco.adicionarConta("Poupança", cliente);
    cliente.adicionarTransacaoContaEspecifica(0, 500.0, "depósito");
    banco.transferirFundos(cliente, 0, 1, 100.0);
    assertEquals(400, cliente.retornarSaldoContaEspecifica(0));
    assertEquals(100, cliente.retornarSaldoContaEspecifica(1));
  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    Banco banco = new Banco();
    PessoaCliente cliente = banco.adicionarPessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    banco.adicionarConta("Poupança", cliente);
    cliente.adicionarTransacaoContaEspecifica(0, 500.0, "depósito");
    banco.sacar(cliente, 0, 200.0);
    assertEquals(300, cliente.retornarSaldoContaEspecifica(0));
  }

}
