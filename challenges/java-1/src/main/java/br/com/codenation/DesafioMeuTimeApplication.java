package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

  List<Team> listTeams;
  List<Player> listPlayers;

  public DesafioMeuTimeApplication() {
    listTeams = new Data().teams;
    listPlayers = new Data().players;
  }

  public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
      String corUniformeSecundario) {
    try {
      ValidateData.findTeamThatExists(id, listTeams);
      Team newTeam = new Team(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
      listTeams.add(newTeam);
      System.out.println(listTeams);
    } catch (IdentificadorUtilizadoException e) {
      throw new IdentificadorUtilizadoException();
    }
  }

  public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento,
      Integer nivelHabilidade, BigDecimal salario) {
    try {
      ValidateData.findPlayerThatExists(id, listPlayers);
      ValidateData.findTeam(idTime, listTeams);
      Player newPlayer = new Player(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
      listPlayers.add(newPlayer);
    } catch (IdentificadorUtilizadoException e) {
      throw new IdentificadorUtilizadoException();
    } catch (TimeNaoEncontradoException e) {
      throw new TimeNaoEncontradoException();
    }
  }

  public void definirCapitao(Long idJogador) {
    try {
      ValidateData.findPlayer(idJogador, listPlayers);
      Team.captain = idJogador;
      Player.captain = true;
    } catch (JogadorNaoEncontradoException e) {
      throw new JogadorNaoEncontradoException();
    }
  }

  public Long buscarCapitaoDoTime(Long idTime) {
    Long captain = null;
    try {
      ValidateData.findTeam(idTime, listTeams);
      List<Long> caps = listPlayers.stream().filter(el -> el.getCaptain().equals(true))
          .map(Player::getId)
          .collect(Collectors.toList());
      ValidateData.findTeamCaptain(caps);
      captain = caps.get(0);
    } catch (TimeNaoEncontradoException e) {
      throw new TimeNaoEncontradoException();
    } catch (CapitaoNaoInformadoException e) {
      throw new CapitaoNaoInformadoException();
    }
    return captain;
  }

  public String buscarNomeJogador(Long idJogador) {
    String name = "";
    try {
      ValidateData.findPlayer(idJogador, listPlayers);
      name = listPlayers.stream().filter(el -> el.getId().equals(idJogador))
          .map(Player::getNome).collect(Collectors.toList()).get(0);
      System.out.println(name);
    } catch (JogadorNaoEncontradoException e) {
      throw new JogadorNaoEncontradoException();
    }
    return name;
  }

  public String buscarNomeTime(Long idTime) {
    String teamName = "";
    try {
      ValidateData.findTeam(idTime, listTeams);
      teamName = listTeams.stream().filter(el -> el.getId().equals(idTime))
          .map(Team::getNome).collect(Collectors.toList()).get(0);
    } catch (TimeNaoEncontradoException e) {
      throw new TimeNaoEncontradoException();
    }
    return teamName;
  }

  public List<Long> buscarJogadoresDoTime(Long idTime) {
    List<Long> identifiers;

    try {
      ValidateData.findTeam(idTime, listTeams);
      identifiers = listPlayers.stream().filter(el -> el.getIdTime().equals(idTime))
          .map(Player::getId).collect(Collectors.toList());
    } catch (TimeNaoEncontradoException e) {
      throw new TimeNaoEncontradoException();
    }
    return identifiers;
  }

  public Long buscarMelhorJogadorDoTime(Long idTime) {
    Long bestPlayer = null;
    try {
      ValidateData.findTeam(idTime, listTeams);

      int higherAbility = Collections.max(listPlayers.stream()
          .map(Player::getNivelHabilidade).collect(Collectors.toList()));

      bestPlayer = listPlayers.stream().filter(el -> el.getNivelHabilidade().equals(higherAbility))
          .map(Player::getId).collect(Collectors.toList()).get(0);

    } catch (TimeNaoEncontradoException e) {
      throw new TimeNaoEncontradoException();
    }
    return bestPlayer;
  }

  public Long buscarJogadorMaisVelho(Long idTime) {
    long olderPlayer = 0L;
    try {
      ValidateData.findTeam(idTime, listTeams);
      olderPlayer += Collections.min(
          listPlayers.stream().filter(el -> el.getIdTime().equals(idTime))
              .map(Player::getId).collect(Collectors.toList()));
    } catch (TimeNaoEncontradoException e) {
      throw new TimeNaoEncontradoException();
    }
    return olderPlayer;
  }

  public List<Long> buscarTimes() {
    List<Long> identifiers = listTeams.stream()
        .map(Team::getId).collect(Collectors.toList());

    identifiers.sort(Comparator.naturalOrder());
    return identifiers;
  }

  public Long buscarJogadorMaiorSalario(Long idTime) {
    Long richestPlayer = null;
    try {
      ValidateData.findTeam(idTime, listTeams);

      BigDecimal bigSalary = Collections.max(
          listPlayers.stream().filter(el -> el.getIdTime().equals(idTime))
              .map(Player::getSalario).collect(Collectors.toList()));

      richestPlayer = listPlayers.stream().filter(el -> el.getSalario().equals(bigSalary))
          .map(Player::getId).collect(Collectors.toList()).get(0);

    } catch (TimeNaoEncontradoException e) {
      throw new TimeNaoEncontradoException();
    }
    return richestPlayer;
  }

  public BigDecimal buscarSalarioDoJogador(Long idJogador) {
    BigDecimal salary = null;
    try {
      ValidateData.findPlayer(idJogador, listPlayers);
      salary = listPlayers.stream().filter(el -> el.getId().equals(idJogador))
          .map(Player::getSalario).collect(Collectors.toList()).get(0);
    } catch (JogadorNaoEncontradoException e) {
      throw new JogadorNaoEncontradoException();
    }
    return salary;
  }

  public List<Long> buscarTopJogadores(Integer top) {
    List<Long> topPlayers = new ArrayList<Long>();

    List<Long> topIds = listPlayers.stream()
        .map(Player::getId).collect(Collectors.toList());

    if (topIds.size() == 0) {
      return new ArrayList<>();
    }
    topIds.sort(Comparator.reverseOrder());

    for (int i = 0; i < top; i++) {
      topPlayers.add(topIds.get(i));
    }
    return topPlayers;
  }
}
