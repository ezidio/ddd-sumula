package br.com.everton.sumula.model.sumula;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Serviços
 */
@Service
public class SumulaService {

    public int contaAtuacoesArbitragem(Arbitragem arbitragem, List<Sumula> sumulas) {
        return (int) sumulas.stream()
                .filter(sumula ->  sumula.getArbitragem().equals(arbitragem))
                .count();
    }

    public Map<Arbitragem, Integer> contaCartoesAmareloPorArbitragem(List<Sumula> sumulas) {
        return sumulas.stream()
                .collect(Collectors.groupingBy(Sumula::getArbitragem, Collectors.summingInt(s -> s.getCartoesAmarelo().size())));
    }
}
