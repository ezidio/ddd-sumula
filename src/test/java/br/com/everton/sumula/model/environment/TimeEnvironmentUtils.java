package br.com.everton.sumula.model.environment;

import br.com.everton.sumula.model.jogador.InscricaoCBF;
import br.com.everton.sumula.model.jogador.Jogador;
import br.com.everton.sumula.model.Time;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Utilidades para environment de times
 */
public class TimeEnvironmentUtils {

    static Jogador criaJogador(InscricaoCBF cbf, Time time) {
        Jogador jogador = mock(Jogador.class);
        when(jogador.getTime()).thenReturn(time);
        when(jogador.getCbf()).thenReturn(cbf);
        return jogador;
    }

    public static Time criaTime(String nome) {
        Time time = mock(Time.class);
        when(time.getNome()).thenReturn(nome);
        return time;
    }
}
