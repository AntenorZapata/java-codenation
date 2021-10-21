package challenge;


import static java.util.concurrent.ThreadLocalRandom.current;

import java.util.Objects;

public class Motorista {

  public static void main(String[] args) {
    Estacionamento estacionamento = new Estacionamento();
    for (int indice = 1; indice <= 10; indice++) {

      Motorista motorista = Motorista.builder()
          .withNome("Motorista " + indice)
          .withIdade(20)
          .withPontos(3)
          .withHabilitacao(Long.toString(current().nextLong()))
          .build();

      Carro carro = Carro.builder().withCor(Cor.BRANCO).
          withPlaca("123")
          .withMotorista(motorista)
          .build();

      estacionamento.estacionar(carro);
    }
    Motorista motorista = Motorista.builder()
        .withNome("ULTIMNO")
        .withIdade(20)
        .withPontos(3)
        .withHabilitacao(Long.toString(current().nextLong()))
        .build();

    Carro carroLast = Carro.builder().withCor(Cor.COLORIDO).
        withPlaca("123")
        .withMotorista(motorista)
        .build();

    estacionamento.estacionar(carroLast);
    estacionamento.carroEstacionado(carroLast);


  }

  private final String nome;

  private final int idade;

  private final int pontos;

  private final String habilitacao;

  private Motorista(String nome, int idade, int pontos, String habilitacao) {
    Validate.validateDriverNameAndLicense(nome, habilitacao);
    this.nome = nome;
    this.idade = idade;
    this.pontos = pontos;
    this.habilitacao = habilitacao;
  }

  public String getNome() {
    return nome;
  }

  public int getIdade() {
    return idade;
  }

  public int getPontos() {
    return pontos;
  }

  public String getHabilitacao() {
    return habilitacao;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Motorista motorista = (Motorista) o;

    return Objects.equals(habilitacao, motorista.habilitacao);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(habilitacao);
  }

  @Override
  public String toString() {
    return "Motorista{" +
        "nome='" + nome + '\'' +
        ", idade=" + idade +
        ", pontos=" + pontos +
        ", habilitacao='" + habilitacao + '\'' +
        '}';
  }

  public static MotoristaBuilder builder() {
    return new MotoristaBuilder();
  }


  public static class MotoristaBuilder {

    private String nome;

    private int idade;

    private int pontos;

    private String habilitacao;

    private MotoristaBuilder() {
    }

    public MotoristaBuilder withNome(String nome) {
      this.nome = nome;
      return this;
    }

    public MotoristaBuilder withIdade(int idade) {
      if(idade < 0) {
        throw new IllegalArgumentException();
      }
      this.idade = idade;
      return this;
    }

    public MotoristaBuilder withPontos(int pontos) {
      if(pontos < 0) {
        throw new IllegalArgumentException();
      }
      this.pontos = pontos;
      return this;
    }

    public MotoristaBuilder withHabilitacao(String habilitacao) {
      this.habilitacao = habilitacao;
      return this;
    }


    public Motorista build() {
      return new Motorista(nome, idade, pontos, habilitacao);
    }
  }
}
