package br.com.everton.sumula.model.sumula;

import br.com.everton.sumula.model.environment.BotafogoEnvironment;
import br.com.everton.sumula.model.environment.ChapecoenseEnvironment;
import br.com.everton.sumula.model.type.TipoRelacao;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by everton on 21/04/17.
 */
public class EscalacaoTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void test_create() throws Exception {

        Escalacao escalacao = ChapecoenseEnvironment.getEscalacao();

        assertEquals(11, escalacao.getTitulares().size());
        assertEquals(7, escalacao.getReservas().size());


    }


    @Test
    public void lanca_exception_com_menos_de_11_titulares() throws Exception {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("São necessários 11 titulares para confirmar a escalação");

        Escalacao.newBuilder()
                .withTime(ChapecoenseEnvironment.CHAPECOENSE)
                .addTitular(1,  ChapecoenseEnvironment.DANILO)
                .addTitular(4,  ChapecoenseEnvironment.NETO)
                .addTitular(6,  ChapecoenseEnvironment.DENER)
                .addTitular(23, ChapecoenseEnvironment.LUCAS)
                .addTitular(27, ChapecoenseEnvironment.WILLIAM)
                .addTitular(33, ChapecoenseEnvironment.KEMPES)
                .addTitular(35, ChapecoenseEnvironment.SERGIO_MANOEL)
                .addTitular(60, ChapecoenseEnvironment.MATEUS)
                .addTitular(77, ChapecoenseEnvironment.MATHEUS_BITECO)
                .addTitular(88, ChapecoenseEnvironment.CLEBER_SANTANA)
                .build();
    }
    @Test
    public void lanca_exception_com_mais_de_11_titulares() throws Exception {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("São necessários 11 titulares para confirmar a escalação");

        Escalacao.newBuilder()
                .withTime(ChapecoenseEnvironment.CHAPECOENSE)
                .addTitular(1, ChapecoenseEnvironment.DANILO)
                .addTitular(4, ChapecoenseEnvironment.NETO)
                .addTitular(6, ChapecoenseEnvironment.DENER)
                .addTitular(23, ChapecoenseEnvironment.LUCAS)
                .addTitular(27, ChapecoenseEnvironment.WILLIAM)
                .addTitular(33, ChapecoenseEnvironment.KEMPES)
                .addTitular(35, ChapecoenseEnvironment.SERGIO_MANOEL)
                .addTitular(60, ChapecoenseEnvironment.MATEUS)
                .addTitular(77, ChapecoenseEnvironment.MATHEUS_BITECO)
                .addTitular(88, ChapecoenseEnvironment.CLEBER_SANTANA)
                .addTitular(94, ChapecoenseEnvironment.TIAGO_ROCHA)
                .addTitular(9, ChapecoenseEnvironment.BRUNO_RANGEL)
                .addTitular(30, ChapecoenseEnvironment.ODAIR)
                .build();
    }



    @Test
    public void lanca_exception_com_jogador_de_outro_time() throws Exception {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("A escalação deve conter somente jogadores do(a) Chapecoense");

        ChapecoenseEnvironment.getEscalacaoBuilder()
                .addReserva(100, BotafogoEnvironment.AIRTON)
                .build();
    }

    @Test
    public void lanca_exception_com_time_nao_definido() throws Exception {

        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("O time deve ser especificado.");

        ChapecoenseEnvironment.getEscalacaoBuilder()
                .withTime(null)
                .build();
    }

    @Test
    public void retorna_jogador_escalado() throws Exception {

        Escalacao escalacao = ChapecoenseEnvironment.getEscalacao();
        Optional<Relacionado> relacionado = escalacao.getRelacionadoPorNumero(ChapecoenseEnvironment.NUMERO_DENER);

        assertTrue(relacionado.isPresent());
        assertEquals(ChapecoenseEnvironment.DENER, relacionado.get().getJogador());
        assertEquals(6, relacionado.get().getNumero());
        assertEquals(ChapecoenseEnvironment.CHAPECOENSE, relacionado.get().getTime());
        assertEquals(TipoRelacao.TITULAR, relacionado.get().getTipo());
    }

    @Test
    public void retorna_vazio_para_jogador_nao_escalado() throws Exception {

        Escalacao escalacao = ChapecoenseEnvironment.getEscalacao();
        Optional<Relacionado> relacionado = escalacao.getRelacionadoPorNumero(2);
        assertFalse(relacionado.isPresent());
    }

    @Test
    public void retorna_jogadores_titulares() throws Exception {

        Escalacao escalacao = ChapecoenseEnvironment.getEscalacao();
        List<Relacionado> titulares = escalacao.getTitulares();

        assertEquals(11, titulares.size());
        assertEquals(Arrays.asList(
                ChapecoenseEnvironment.DANILO,
                ChapecoenseEnvironment.NETO,
                ChapecoenseEnvironment.DENER,
                ChapecoenseEnvironment.LUCAS,
                ChapecoenseEnvironment.WILLIAM,
                ChapecoenseEnvironment.KEMPES,
                ChapecoenseEnvironment.SERGIO_MANOEL,
                ChapecoenseEnvironment.MATEUS,
                ChapecoenseEnvironment.MATHEUS_BITECO,
                ChapecoenseEnvironment.CLEBER_SANTANA,
                ChapecoenseEnvironment.TIAGO_ROCHA
        ), titulares.stream().map(Relacionado::getJogador).collect(Collectors.toList()));
    }

    @Test
    public void retorna_jogadores_reservas() throws Exception {

        Escalacao escalacao = ChapecoenseEnvironment.getEscalacao();
        List<Relacionado> reservas = escalacao.getReservas();

        assertEquals(7, reservas.size());
        assertEquals(Arrays.asList(
                ChapecoenseEnvironment.BRUNO_RANGEL,
                ChapecoenseEnvironment.ODAIR,
                ChapecoenseEnvironment.JAKSON,
                ChapecoenseEnvironment.FILIPE_JOSE,
                ChapecoenseEnvironment.ARTHUR,
                ChapecoenseEnvironment.AILTON,
                ChapecoenseEnvironment.ALAN_RUSCHEL
        ), reservas.stream().map(Relacionado::getJogador).collect(Collectors.toList()));
    }
}