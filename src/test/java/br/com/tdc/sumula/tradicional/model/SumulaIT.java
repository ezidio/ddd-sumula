package br.com.tdc.sumula.tradicional.model;

import br.com.tdc.sumula.tradicional.model.environment.ChapecoenseEnvironment;
import br.com.tdc.sumula.tradicional.type.TempoDeJogo;
import org.hibernate.Session;
import org.junit.BeforeClass;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

import static br.com.tdc.sumula.tradicional.model.environment.ChapecoenseEnvironment.*;
import static br.com.tdc.sumula.tradicional.model.environment.BotafogoEnvironment.*;


/**
 * Teste de integração para a súmula
 */
public class SumulaIT {


    private static final long NUMERO_JOGO = 341L;
    private static final int RODADA = 35;
    private static final LocalDateTime DATA = LocalDateTime.of(2016, 11, 16, 16, 0);
    private static Session session;

    @BeforeClass
    public static void init() throws ClassNotFoundException, IOException, URISyntaxException {
        session = HibernateUtil.createSessionFactory().openSession();
    }

    @org.junit.Test
    public void test_create_simple() throws Exception {

        Arbitragem arbitragem = Arbitragem.newBuilder()
                .withArbitro(session.find(Arbitro.class, 1L))
                .withAssistente1(session.find(Arbitro.class, 2L))
                .withAssistente2(session.find(Arbitro.class, 3L))
                .withQuartoArbitro(session.find(Arbitro.class, 4L))
                .build();

        Sumula sumula = Sumula.newBuilder()
                .withEstadio(session.find(Estadio.class, 1L))
                .withArbitragem(arbitragem)
                .withCampeonato(session.find(Campeonato.class, 1L))
                .withCasa(escalacaoCasa())
                .withVisitante(escalacaoVisitante())
                .withNumeroJogo(NUMERO_JOGO)
                .withRodada(RODADA)
                .withData(DATA)
                .build();

        session.save(sumula);

    }

    @org.junit.Test
    public void test_create_and_manipulate() throws Exception {

        Arbitragem arbitragem = Arbitragem.newBuilder()
                .withArbitro(session.find(Arbitro.class, 1L))
                .withAssistente1(session.find(Arbitro.class, 2L))
                .withAssistente2(session.find(Arbitro.class, 3L))
                .withQuartoArbitro(session.find(Arbitro.class, 4L))
                .build();

        Sumula sumula = Sumula.newBuilder()
                .withEstadio(session.find(Estadio.class, 1L))
                .withArbitragem(arbitragem)
                .withCampeonato(session.find(Campeonato.class, 1L))
                .withCasa(escalacaoCasa())
                .withVisitante(escalacaoVisitante())
                .withNumeroJogo(NUMERO_JOGO)
                .withRodada(RODADA)
                .withData(DATA)
                .build();


        session.saveOrUpdate(sumula);

        Time botafogo = sumula.getTimeCasa();
        Time chape = sumula.getTimeVisitante();

        sumula.getRelacionado(chape, ChapecoenseEnvironment.NUMERO_KEMPES).ifPresent(kempes -> sumula.addGol(Gol.normal(TempoDeJogo.primeiroTempo(32), kempes)));
        sumula.getRelacionado(chape, ChapecoenseEnvironment.NUMERO_SERGIO_MANOEL).ifPresent(sergioManoel -> sumula.addGol(Gol.normal(TempoDeJogo.segundoTempo(19), sergioManoel)));

        sumula.getRelacionado(botafogo, NUMERO_AIRTON).ifPresent(airton -> sumula.addCartaoAmarelo(TempoDeJogo.segundoTempo(10), airton, "Motivo: A2. Desaprovar com palavras ou gestos as decisões da arbitragem - Desaprovar com palavras ou gestos as decisões da arbitragem."));
        sumula.getRelacionado(botafogo, NUMERO_VICTOR_LUIS).ifPresent(victorLuis -> sumula.addCartaoAmarelo(TempoDeJogo.segundoTempo(10), victorLuis, "Motivo: A2. Desaprovar com palavras ou gestos as decisões da arbitragem - Desaprovar com palavras ou gestos as decisões da arbitragem."));
        sumula.getRelacionado(botafogo, NUMERO_LEANDRO).ifPresent(leandro -> sumula.addCartaoAmarelo(TempoDeJogo.segundoTempo(10), leandro, "Motivo: A1.13. Dar uma entrada contra um adversário de maneira temerária na disputa da bola - Dar uma entrada contra um adversário de maneira temerária na disputa da bola."));
        sumula.getRelacionado(chape, NUMERO_NETO).ifPresent(neto -> sumula.addCartaoAmarelo(TempoDeJogo.primeiroTempo(35), neto, "Motivo: A1.3. Cometer uma falta tática para impedir um ataque promissor - Cometer uma falta tática para impedir um ataque promissor."));

        session.saveOrUpdate(sumula);



    }

    private Escalacao escalacaoVisitante() {
        return Escalacao.newBuilder()
                .withTime(session.find(Time.class, CHAPECOENSE_ID))
                .addTitular(NUMERO_DANILO, session.find(Jogador.class, CBF_DANILO))
                .addTitular(NUMERO_NETO, session.find(Jogador.class, CBF_NETO))
                .addTitular(NUMERO_DENER, session.find(Jogador.class, CBF_DENER))
                .addTitular(NUMERO_LUCAS, session.find(Jogador.class, CBF_LUCAS))
                .addTitular(NUMERO_WILLIAM, session.find(Jogador.class, CBF_WILLIAM))
                .addTitular(NUMERO_KEMPES, session.find(Jogador.class, CBF_KEMPES))
                .addTitular(NUMERO_SERGIO_MANOEL, session.find(Jogador.class, CBF_SERGIO_MANOEL))
                .addTitular(NUMERO_MATEUS, session.find(Jogador.class, CBF_MATEUS))
                .addTitular(NUMERO_MATHEUS_BITECO, session.find(Jogador.class, CBF_MATHEUS_BITECO))
                .addTitular(NUMERO_CLEBER_SANTANA, session.find(Jogador.class, CBF_CLEBER_SANTANA))
                .addTitular(NUMERO_TIAGO_ROCHA, session.find(Jogador.class, CBF_TIAGO_ROCHA))
                .addReserva(NUMERO_BRUNO_RANGEL, session.find(Jogador.class, CBF_BRUNO_RANGEL))
                .addReserva(NUMERO_ODAIR, session.find(Jogador.class, CBF_ODAIR))
                .addReserva(NUMERO_JAKSON, session.find(Jogador.class, CBF_JAKSON))
                .addReserva(NUMERO_FILIPE_JOSE, session.find(Jogador.class, CBF_FILIPE_JOSE))
                .addReserva(NUMERO_ARTHUR, session.find(Jogador.class, CBF_ARTHUR))
                .addReserva(NUMERO_AILTON, session.find(Jogador.class, CBF_AILTON))
                .addReserva(NUMERO_ALAN_RUSCHEL, session.find(Jogador.class, CBF_ALAN_RUSCHEL))
                .build();
    }

    private Escalacao escalacaoCasa() {
        return Escalacao.newBuilder()
                .withTime(session.find(Time.class, BOTAFOGO_ID))
                .addTitular(NUMERO_SIDAO , session.find(Jogador.class, CBF_SIDAO))
                .addTitular(NUMERO_EMERSON_SANTOS, session.find(Jogador.class, CBF_EMERSON_SANTOS))
                .addTitular(NUMERO_CARLI, session.find(Jogador.class, CBF_CARLI))
                .addTitular(NUMERO_ALEMAO, session.find(Jogador.class, CBF_ALEMAO))
                .addTitular(NUMERO_RODRIGO, session.find(Jogador.class, CBF_RODRIGO))
                .addTitular(NUMERO_VICTOR_LUIS , session.find(Jogador.class, CBF_VICTOR_LUIS))
                .addTitular(NUMERO_NEILTON, session.find(Jogador.class, CBF_NEILTON))
                .addTitular(NUMERO_AIRTON, session.find(Jogador.class, CBF_AIRTON))
                .addTitular(NUMERO_RODRIGO_PIMPAO, session.find(Jogador.class, CBF_RODRIGO_PIMPAO))
                .addTitular(NUMERO_FERNANDO , session.find(Jogador.class, CBF_FERNANDO))
                .addTitular(NUMERO_DIOGO , session.find(Jogador.class, CBF_DIOGO))
                .addReserva(NUMERO_HELTON , session.find(Jogador.class, CBF_HELTON))
                .addReserva(NUMERO_MARCIO , session.find(Jogador.class, CBF_MARCIO))
                .addReserva(NUMERO_EMERSON , session.find(Jogador.class, CBF_EMERSON))
                .addReserva(NUMERO_RENAN , session.find(Jogador.class, CBF_RENAN))
                .addReserva(NUMERO_JONATHAN , session.find(Jogador.class, CBF_JONATHAN))
                .addReserva(NUMERO_GEIRTON , session.find(Jogador.class, CBF_GEIRTON))
                .addReserva(NUMERO_VINICIUS , session.find(Jogador.class, CBF_VINICIUS))
                .build();
    }
}