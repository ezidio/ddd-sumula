package br.com.tdc.sumula.tradicional.model.environment;

import br.com.tdc.sumula.tradicional.model.Jogador;
import br.com.tdc.sumula.tradicional.model.Time;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Utilidades para environment de times
 */
public class TimeEnvironmentUtils {

    static Jogador criaJogador(Long cbf, Time time) {
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
