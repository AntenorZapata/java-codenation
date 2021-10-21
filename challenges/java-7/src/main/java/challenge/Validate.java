package challenge;

public class Validate {

  public static void validateDriverNameAndLicense(String nome, String habilitacao)
      throws NullPointerException {
    if (nome == null || habilitacao == null) {
      throw new NullPointerException();
    }
  }

//  public static void validateDriverAgeAndPoints(int idade, int pontos)
//      throws IllegalArgumentException {
//    if (idade < 0 || pontos < 0) {
//      throw new IllegalArgumentException();
//    }
//  }

  public static void validateCarLicensePlateAndColor(String placa, Cor cor)
      throws NullPointerException {
    if (placa == null || cor == null) {
      throw new NullPointerException();
    }
  }

  public static void validateCarDriver(Motorista motorista)
      throws EstacionamentoException {
    if (motorista == null || motorista.getIdade() < 18) {
      throw new EstacionamentoException("A car must have a driver over 18 years of age.");
    }
  }


}
