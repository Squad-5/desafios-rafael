package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Estacionamento {

    int limiteVagas = 10;
    List<Carro> estacionamento = new ArrayList<>();

    public void estacionar(Carro carro) {
      verificaSeTemMotorista(carro);
      verificarSeMotoristaTemHabilitacao(carro);
      verificarPontuacaoMotorista(carro);
      if (verificarSePodeEstacionar()) estacionamento.add(carro);
      else if (!verificaMenor55()) throw new EstacionamentoException("Todos seniors");
      else {
          estacionamento.remove(estacionamento.indexOf(recuperarPrimeiroMotoristaAbaixo55()));
          estacionamento.add(carro);
      }

    }

    public int carrosEstacionados() {
        return estacionamento.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return estacionamento.stream().anyMatch(carro1 -> carro1.equals(carro));
    }

    private boolean verificaSeTemMotorista(Carro carro) {

        if (carro.getMotorista() == null) throw new EstacionamentoException("Carro autônomo");
        return true;

    }

    private boolean verificarSePodeEstacionar() {
        if (carrosEstacionados() < 10) return true;
        return false;
    }

    private boolean verificaMenor55(){
        return estacionamento.stream().anyMatch(carro -> carro.getMotorista().getIdade() < 55);
    }

    private void verificarSeMotoristaTemHabilitacao(Carro carro){
        if ((carro.getMotorista().getHabilitacao() == null) || (carro.getMotorista().getIdade() < 18)) throw new EstacionamentoException("Motorista sem carteira");
    }

    private void verificarPontuacaoMotorista(Carro carro){
        if (carro.getMotorista().getPontos() > 20) throw new EstacionamentoException("Pontos acima do permitido");
    }

    private Carro recuperarPrimeiroMotoristaAbaixo55() {

        return estacionamento.stream()
                .filter(carro -> carro.getMotorista().getIdade() < 55)
                .findFirst()
                .get();


    }


}
