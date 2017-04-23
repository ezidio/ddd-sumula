package br.com.everton.sumula.model.sumula;

import br.com.everton.sumula.model.Time;
import br.com.everton.sumula.model.jogador.InscricaoCBF;
import br.com.everton.sumula.model.jogador.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Fabrica de escalacao
 */
public class EscalacaoFactory {

    @Autowired
    private JogadorRepository jogadorRepository;

    public Escalacao createFrom(Time time, Map<Integer, InscricaoCBF> titulares, Map<Integer, InscricaoCBF> reservas) {
        Escalacao.Builder builder = Escalacao.newBuilder().withTime(time);
        titulares.forEach((numero, inscricao) -> builder.addTitular(numero, jogadorRepository.findOne(inscricao)));
        reservas.forEach((numero, inscricao) -> builder.addReserva(numero, jogadorRepository.findOne(inscricao)));
        return builder.build();
    }

}
