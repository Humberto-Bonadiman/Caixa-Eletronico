package com.trybe.acc.java.caixaeletronico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
  private double quantia;
  private String instante;
  private String descricao;
  
  public Transacao(double quantia, String descricao) {
    this.quantia = quantia;
    this.descricao = descricao;
    this.instante = retornarInstante();
  }
  
  public String retornarResumoTransacao() {
    return "Resumo da transação:" + "\nInstante: " + this.instante + "\nQuantia: " + this.quantia
      + "\nDescrição: " + this.descricao;
  }
  
  public String retornarInstante() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime date = LocalDateTime.now();
    String dateFormatted = date.format(formatter);
    return dateFormatted;
  }

  public double getQuantia() {
    return quantia;
  }

  public String getDescricao() {
    return descricao;
  }
}

