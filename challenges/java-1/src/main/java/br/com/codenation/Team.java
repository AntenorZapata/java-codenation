package br.com.codenation;


import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import java.time.LocalDate;
import java.util.List;

public class Team {

  Long id;
  String nome;
  LocalDate dataCriacao;
  String corUniformePrincipal;
  String corUniformeSecundario;
  List<Team> listTeams = new Data().teams;
  static Long captain;


  public Team(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
      String corUniformeSecundario) throws IdentificadorUtilizadoException {
    this.id = id;
    this.nome = nome;
    this.dataCriacao = dataCriacao;
    this.corUniformePrincipal = corUniformePrincipal;
    this.corUniformeSecundario = corUniformeSecundario;
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  @Override
  public String toString() {
    return "Team{" +
        "nome='" + nome + '\'' +
        ", id=" + id +
        '}';
  }
}
