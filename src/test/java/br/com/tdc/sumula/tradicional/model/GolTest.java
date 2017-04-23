package br.com.tdc.sumula.tradicional.model;

import br.com.tdc.sumula.tradicional.type.TempoDeJogo;
import br.com.tdc.sumula.tradicional.type.TipoGol;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static br.com.tdc.sumula.tradicional.type.TempoDeJogo.segundoTempo;
import static org.junit.Assert.*;

/**
 * Created by everton on 23/04/17.
 */
public class GolTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void deve_criar_gol_normal() throws Exception {

        TempoDeJogo tempo = segundoTempo(20);
        Relacionado relacionado = Mockito.mock(Relacionado.class);
        Time time = Mockito.mock(Time.class);
        Mockito.when(relacionado.getTime()).thenReturn(time);

        Gol gol = Gol.normal(tempo, relacionado);

        assertEquals(tempo, gol.getTempo());
        assertEquals(relacionado, gol.getRelacionado());
        assertEquals(time, gol.getFavorecido());
        assertEquals(TipoGol.NORMAL, gol.getTipo());
    }

    @Test
    public void deve_criar_gol_falta() throws Exception {

        TempoDeJogo tempo = segundoTempo(20);
        Relacionado relacionado = Mockito.mock(Relacionado.class);
        Time time = Mockito.mock(Time.class);
        Mockito.when(relacionado.getTime()).thenReturn(time);

        Gol gol = Gol.falta(tempo, relacionado);

        assertEquals(tempo, gol.getTempo());
        assertEquals(relacionado, gol.getRelacionado());
        assertEquals(time, gol.getFavorecido());
        assertEquals(TipoGol.FALTA, gol.getTipo());
    }

    @Test
    public void deve_criar_gol_contra() throws Exception {

        TempoDeJogo tempo = segundoTempo(20);
        Relacionado relacionado = Mockito.mock(Relacionado.class);
        Time time = Mockito.mock(Time.class);
        Time timeFavorecido = Mockito.mock(Time.class);
        Mockito.when(relacionado.getTime()).thenReturn(time);

        Gol gol = Gol.contra(tempo, relacionado, timeFavorecido);

        assertEquals(tempo, gol.getTempo());
        assertEquals(relacionado, gol.getRelacionado());
        assertEquals(timeFavorecido, gol.getFavorecido());
        assertEquals(TipoGol.CONTRA, gol.getTipo());
    }

    @Test
    public void deve_lancar_excecao_com_gol_contra_favorecido_ao_time_do_jogador() throws Exception {

        TempoDeJogo tempo = segundoTempo(20);
        Relacionado relacionado = Mockito.mock(Relacionado.class);
        Time time = Mockito.mock(Time.class);
        Mockito.when(relacionado.getTime()).thenReturn(time);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Gol contra não pode ser favorecido ao time do jogador.");

        Gol.contra(tempo, relacionado, time);

    }

}