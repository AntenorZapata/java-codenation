package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

  List<Carro> parkingLot = new ArrayList<>();


  public void estacionar(Carro carro) {

    if (carro.getMotorista().getPontos() > 20) {
      throw new EstacionamentoException("A driver must have points");
    }

    if (parkingLot.size() == 10) {
      for (Carro car : parkingLot) {
        if (car.getMotorista().getIdade() < 55) {
          parkingLot.remove(car);
          parkingLot.add(carro);
          break;
        } else if (parkingLot.indexOf(car) == 9) {
          throw new EstacionamentoException("Full parking lot");
        }
      }
    } else {
      parkingLot.add(carro);
    }
  }

  public int carrosEstacionados() {
    return parkingLot.size();
  }

  public boolean carroEstacionado(Carro carro) {
    System.out.println(parkingLot.contains(carro));
    return parkingLot.contains(carro);
  }
}
