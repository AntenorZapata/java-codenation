package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Player {

  Long id;
  Long idTime;
  String nome;
  LocalDate dataNascimento;
  Integer nivelHabilidade;
  BigDecimal salario;
  static Boolean captain;


  public Player(Long id, Long idTime, String nome, LocalDate dataNascimento,
      Integer nivelHabilidade, BigDecimal salario) {
    this.id = id;
    this.idTime = idTime;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.nivelHabilidade = nivelHabilidade;
    this.salario = salario;
  }

  public Boolean getCaptain() {
    return captain;
  }

  public Long getId() {
    return id;
  }

  public Long getIdTime() {
    return idTime;
  }

  public String getNome() {
    return nome;
  }

  public Integer getNivelHabilidade() {
    return nivelHabilidade;
  }

  public BigDecimal getSalario() {
    return salario;
  }

  @Override
  public String toString() {
    return "Player{" +
        "nome='" + nome + '\'' +
        ", id=" + id + " salario: " + salario + " habilidade: " + nivelHabilidade +
        '}';
  }

}
