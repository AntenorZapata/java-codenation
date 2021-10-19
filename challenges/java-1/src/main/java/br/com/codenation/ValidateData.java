package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import java.util.List;

public class ValidateData {

  public static void findTeamThatExists(Long idTime, List<Team> listTeams) throws IdentificadorUtilizadoException {
    Boolean team = listTeams.stream().anyMatch(el -> el.getId().equals(idTime));
    if(team) throw new IdentificadorUtilizadoException();
  }

  public static void findPlayerThatExists(Long idTime, List<Player> listPlayers) throws IdentificadorUtilizadoException {
    Boolean player = listPlayers.stream().anyMatch(el -> el.getId().equals(idTime));
    if(player) throw new IdentificadorUtilizadoException();
  }

  public static void findTeamCaptain(List captain) throws CapitaoNaoInformadoException {
//    Long captain = listPlayers.stream().filter(el -> el.getCaptain().equals(true)).map(Player::getId)
//        .collect(Collectors.toList()).get(0);
    if(captain.size() == 0) throw new CapitaoNaoInformadoException();
  }

  public static void findTeam(Long idTime, List<Team> listTeams) throws TimeNaoEncontradoException {
    Boolean team = listTeams.stream().anyMatch(el -> el.getId().equals(idTime));
    if(!team) throw new TimeNaoEncontradoException();
  }

  public static void findPlayer(Long idJogador, List<Player> listPlayers) throws JogadorNaoEncontradoException {
    Boolean player = listPlayers.stream().anyMatch(el -> el.getId().equals(idJogador));
    if(!player) throw new JogadorNaoEncontradoException();
  }

}
