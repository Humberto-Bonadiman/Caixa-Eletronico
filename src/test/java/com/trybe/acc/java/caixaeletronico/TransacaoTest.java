package com.trybe.acc.java.caixaeletronico;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes dos métodos da classe Transacao")
class TransacaoTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @BeforeEach
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @Test
  @DisplayName("21 - Testa o método construtor da classe Transacao.")
  void construtorTest() {
    Transacao transacao = new Transacao(500, "deposito");
    assertEquals("deposito", transacao.getDescricao());
    assertEquals(500, transacao.getQuantia());
  }

  @Test
  @DisplayName("22 - Testa o método Getter do atributo quantia.")
  void getQuantiaTest() {
    Transacao transacao = new Transacao(500, "deposito");
    assertEquals(500, transacao.getQuantia());
  }

  @Test
  @DisplayName("23 - Testa o método retornar resumo transacao.")
  void retornarResumoTransacaoTest() {
    Transacao transacao = new Transacao(500, "deposito");
    assertTrue(transacao.retornarResumoTransacao().contains(transacao.retornarResumoTransacao()));
  }

  @Test
  @DisplayName("24 - Testa o método instante está gerando o instante corretamente.")
  void retornarInstanteTest() {
    Transacao transacao = new Transacao(500, "deposito");
    assertNotNull(transacao.retornarInstante());
  }

}
