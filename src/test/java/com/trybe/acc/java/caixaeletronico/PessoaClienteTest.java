package com.trybe.acc.java.caixaeletronico;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste dos métodos da classe PessoaCliente")
class PessoaClienteTest {
  private final PrintStream originalOut = System.out;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  
  @BeforeEach
  public void setUp() {
      System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  public void restoreStreams() {
      System.setOut(originalOut);
  }

  @Test
  @DisplayName("12 - Testa o construtor da classe Pessoa Cliente.")
  void construtorTest() {
    PessoaCliente cliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    assertEquals("Alexiania Pereira", cliente.getNomeCompleto());
    assertEquals("842.074.410-77", cliente.getCpf());
    assertEquals("1234", cliente.getSenha());
    String mensagem = "Nova pessoa cliente Alexiania Pereira com 842.074.410-77 foi criada!";
    String resposta = outContent.toString();
    assertEquals(mensagem, resposta);
  }

  @Test
  @DisplayName("13 - Testa o método adicionar conta e o método retornar número de contas.")
  void adicionarContaTestRetornaNumeroDeContasTest() {
    Banco banco = new Banco();
    PessoaCliente cliente = banco.adicionarPessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Poupança", cliente, banco);
    cliente.adicionarConta(conta);
    assertEquals(2, cliente.retornaNumeroDeContas());
  }

@Test
  @DisplayName("14 - Testa o método retornar saldo de uma conta específica da pessoa cliente.")
  void retornarSaldoContaEspecificaTest() {
    PessoaCliente cliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Conta Corrente", cliente, new Banco());
    cliente.adicionarConta(conta);
    assert (cliente.retornarSaldoContaEspecifica(0) == 0.0);
  }


  @Test
  @DisplayName("15 - Testa o método retornar id de uma conta específica da pessoa cliente.")
  void retornarIdContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente cliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Poupança", cliente, banco);
    cliente.adicionarConta(conta);
    assertEquals(conta.getIdConta(), cliente.retornarIdContaEspecifica(1));
  }

  @Test
  @DisplayName("16 - Testa o método retornar o extrato de uma conta específica da pessoa cliente.")
  void retornarExtratoContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente cliente = banco.adicionarPessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    banco.depositar(cliente, 0, 200.00);
    cliente.retornarExtratoContaEspecifica(0);
    assertTrue(outContent.toString().contains("Depósito recebido: R$ 200.00 +\n"));
  }

  @Test
  @DisplayName("17 - Testa o método adiciona transacao de uma conta específica da pessoa cliente.")
  void adicionarTransacaoContaEspecificaTest() {
	Banco banco = new Banco();
    PessoaCliente cliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Poupança", cliente, banco);
    cliente.adicionarConta(conta);
    assertThrows(IndexOutOfBoundsException.class, () -> {
	    cliente.adicionarTransacaoContaEspecifica(2, 500.0, "descricao");
	});
  }

  @Test
  @DisplayName("18 - Testa o método validar senha.")
  void validarSenhaTest() {
    PessoaCliente cliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    assertTrue(cliente.validarSenha("1234"));
  }

  @Test
  @DisplayName("19 - Testa o método retornar resumo contas.")
  void retornarResumoContasTest() {
    Banco banco = new Banco();
    PessoaCliente cliente = banco.adicionarPessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = cliente.getContas().get(0);
    cliente.retornarResumoContas();
    assertTrue(outContent.toString().contains(conta.retornarResumoConta()));
  }

  @Test
  @DisplayName("20 - Testa o método Getter do atributo cpf está retornando.")
  void getCpfTest() {
    PessoaCliente cliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    assertEquals("842.074.410-77", cliente.getCpf());
  }

}
