package br.com.tdc.sumula.tradicional.model;

import br.com.tdc.sumula.tradicional.type.TempoDeJogo;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by everton on 18/04/17.
 */
public class TempoDeJogoTest {


    @Test
    public void test_after() throws Exception {

        assertTrue(TempoDeJogo.of(10, Tempo.PRIMEIRO).isAfter(TempoDeJogo.of(5, Tempo.PRIMEIRO)));
        assertTrue(TempoDeJogo.of(10, Tempo.SEGUNDO).isAfter(TempoDeJogo.of(10, Tempo.PRIMEIRO)));
        assertTrue(TempoDeJogo.of(10, Tempo.PRORROGACAO).isAfter(TempoDeJogo.of(10, Tempo.PRIMEIRO)));
        assertTrue(TempoDeJogo.of(10, Tempo.PRORROGACAO).isAfter(TempoDeJogo.of(10, Tempo.SEGUNDO)));
        assertTrue(TempoDeJogo.of(10, Tempo.PRIMEIRO).isAfter(TempoDeJogo.of(9, Tempo.PRIMEIRO)));

        assertFalse(TempoDeJogo.of(10, Tempo.PRIMEIRO).isAfter(TempoDeJogo.of(19, Tempo.PRIMEIRO)));
        assertFalse(TempoDeJogo.of(10, Tempo.PRIMEIRO).isAfter(TempoDeJogo.of(10, Tempo.PRIMEIRO)));

    }

    @Test
    public void test_before() throws Exception {

        assertTrue(TempoDeJogo.of(10, Tempo.PRIMEIRO).isBefore(TempoDeJogo.of(15, Tempo.PRIMEIRO)));
        assertTrue(TempoDeJogo.of(10, Tempo.PRIMEIRO).isBefore(TempoDeJogo.of(10, Tempo.SEGUNDO)));
        assertTrue(TempoDeJogo.of(10, Tempo.PRIMEIRO).isBefore(TempoDeJogo.of(10, Tempo.PRORROGACAO)));
        assertTrue(TempoDeJogo.of(10, Tempo.SEGUNDO).isBefore(TempoDeJogo.of(10, Tempo.PRORROGACAO)));
        assertTrue(TempoDeJogo.of(10, Tempo.PRIMEIRO).isBefore(TempoDeJogo.of(11, Tempo.PRIMEIRO)));

        assertFalse(TempoDeJogo.of(10, Tempo.PRIMEIRO).isBefore(TempoDeJogo.of(9, Tempo.PRIMEIRO)));
        assertFalse(TempoDeJogo.of(10, Tempo.PRIMEIRO).isBefore(TempoDeJogo.of(10, Tempo.PRIMEIRO)));

    }
}