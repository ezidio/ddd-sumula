package br.com.everton.sumula.model.sumula;

import br.com.everton.sumula.model.*;
import br.com.everton.sumula.model.environment.BotafogoEnvironment;
import br.com.everton.sumula.model.environment.ChapecoenseEnvironment;
import br.com.everton.sumula.model.jogador.InscricaoCBF;
import br.com.everton.sumula.model.jogador.Jogador;
import br.com.everton.sumula.model.type.TempoDeJogo;
import org.hibernate.Session;
import org.junit.BeforeClass;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;


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

        sumula.getRelacionado(botafogo, BotafogoEnvironment.NUMERO_AIRTON).ifPresent(airton -> sumula.addCartaoAmarelo(TempoDeJogo.segundoTempo(10), airton, "Motivo: A2. Desaprovar com palavras ou gestos as decisões da arbitragem - Desaprovar com palavras ou gestos as decisões da arbitragem."));
        sumula.getRelacionado(botafogo, BotafogoEnvironment.NUMERO_VICTOR_LUIS).ifPresent(victorLuis -> sumula.addCartaoAmarelo(TempoDeJogo.segundoTempo(10), victorLuis, "Motivo: A2. Desaprovar com palavras ou gestos as decisões da arbitragem - Desaprovar com palavras ou gestos as decisões da arbitragem."));
        sumula.getRelacionado(botafogo, BotafogoEnvironment.NUMERO_LEANDRO).ifPresent(leandro -> sumula.addCartaoAmarelo(TempoDeJogo.segundoTempo(10), leandro, "Motivo: A1.13. Dar uma entrada contra um adversário de maneira temerária na disputa da bola - Dar uma entrada contra um adversário de maneira temerária na disputa da bola."));
        sumula.getRelacionado(chape, ChapecoenseEnvironment.NUMERO_NETO).ifPresent(neto -> sumula.addCartaoAmarelo(TempoDeJogo.primeiroTempo(35), neto, "Motivo: A1.3. Cometer uma falta tática para impedir um ataque promissor - Cometer uma falta tática para impedir um ataque promissor."));

        session.saveOrUpdate(sumula);



    }

    private Escalacao escalacaoVisitante() {
        return Escalacao.newBuilder()
                .withTime(session.find(Time.class, ChapecoenseEnvironment.CHAPECOENSE_ID))
                .addTitular(ChapecoenseEnvironment.NUMERO_DANILO, session.find(Jogador.class, ChapecoenseEnvironment.CBF_DANILO))
                .addTitular(ChapecoenseEnvironment.NUMERO_NETO, session.find(Jogador.class, ChapecoenseEnvironment.CBF_NETO))
                .addTitular(ChapecoenseEnvironment.NUMERO_DENER, session.find(Jogador.class, ChapecoenseEnvironment.CBF_DENER))
                .addTitular(ChapecoenseEnvironment.NUMERO_LUCAS, session.find(Jogador.class, ChapecoenseEnvironment.CBF_LUCAS))
                .addTitular(ChapecoenseEnvironment.NUMERO_WILLIAM, session.find(Jogador.class, ChapecoenseEnvironment.CBF_WILLIAM))
                .addTitular(ChapecoenseEnvironment.NUMERO_KEMPES, session.find(Jogador.class, ChapecoenseEnvironment.CBF_KEMPES))
                .addTitular(ChapecoenseEnvironment.NUMERO_SERGIO_MANOEL, session.find(Jogador.class, ChapecoenseEnvironment.CBF_SERGIO_MANOEL))
                .addTitular(ChapecoenseEnvironment.NUMERO_MATEUS, session.find(Jogador.class, ChapecoenseEnvironment.CBF_MATEUS))
                .addTitular(ChapecoenseEnvironment.NUMERO_MATHEUS_BITECO, session.find(Jogador.class, ChapecoenseEnvironment.CBF_MATHEUS_BITECO))
                .addTitular(ChapecoenseEnvironment.NUMERO_CLEBER_SANTANA, session.find(Jogador.class, ChapecoenseEnvironment.CBF_CLEBER_SANTANA))
                .addTitular(ChapecoenseEnvironment.NUMERO_TIAGO_ROCHA, session.find(Jogador.class, ChapecoenseEnvironment.CBF_TIAGO_ROCHA))
                .addReserva(ChapecoenseEnvironment.NUMERO_BRUNO_RANGEL, session.find(Jogador.class, ChapecoenseEnvironment.CBF_BRUNO_RANGEL))
                .addReserva(ChapecoenseEnvironment.NUMERO_ODAIR, session.find(Jogador.class, ChapecoenseEnvironment.CBF_ODAIR))
                .addReserva(ChapecoenseEnvironment.NUMERO_JAKSON, session.find(Jogador.class, ChapecoenseEnvironment.CBF_JAKSON))
                .addReserva(ChapecoenseEnvironment.NUMERO_FILIPE_JOSE, session.find(Jogador.class, ChapecoenseEnvironment.CBF_FILIPE_JOSE))
                .addReserva(ChapecoenseEnvironment.NUMERO_ARTHUR, session.find(Jogador.class, ChapecoenseEnvironment.CBF_ARTHUR))
                .addReserva(ChapecoenseEnvironment.NUMERO_AILTON, session.find(Jogador.class, ChapecoenseEnvironment.CBF_AILTON))
                .addReserva(ChapecoenseEnvironment.NUMERO_ALAN_RUSCHEL, session.find(Jogador.class, ChapecoenseEnvironment.CBF_ALAN_RUSCHEL))
                .build();
    }

    private Escalacao escalacaoCasa() {
        return Escalacao.newBuilder()
                .withTime(session.find(Time.class, BotafogoEnvironment.BOTAFOGO_ID))
                .addTitular(BotafogoEnvironment.NUMERO_SIDAO , session.find(Jogador.class, BotafogoEnvironment.CBF_SIDAO))
                .addTitular(BotafogoEnvironment.NUMERO_EMERSON_SANTOS, session.find(Jogador.class, BotafogoEnvironment.CBF_EMERSON_SANTOS))
                .addTitular(BotafogoEnvironment.NUMERO_CARLI, session.find(Jogador.class, BotafogoEnvironment.CBF_CARLI))
                .addTitular(BotafogoEnvironment.NUMERO_ALEMAO, session.find(Jogador.class, BotafogoEnvironment.CBF_ALEMAO))
                .addTitular(BotafogoEnvironment.NUMERO_RODRIGO, session.find(Jogador.class, BotafogoEnvironment.CBF_RODRIGO))
                .addTitular(BotafogoEnvironment.NUMERO_VICTOR_LUIS , session.find(Jogador.class, BotafogoEnvironment.CBF_VICTOR_LUIS))
                .addTitular(BotafogoEnvironment.NUMERO_NEILTON, session.find(Jogador.class, BotafogoEnvironment.CBF_NEILTON))
                .addTitular(BotafogoEnvironment.NUMERO_AIRTON, session.find(Jogador.class, BotafogoEnvironment.CBF_AIRTON))
                .addTitular(BotafogoEnvironment.NUMERO_RODRIGO_PIMPAO, session.find(Jogador.class, BotafogoEnvironment.CBF_RODRIGO_PIMPAO))
                .addTitular(BotafogoEnvironment.NUMERO_FERNANDO , session.find(Jogador.class, BotafogoEnvironment.CBF_FERNANDO))
                .addTitular(BotafogoEnvironment.NUMERO_DIOGO , session.find(Jogador.class, BotafogoEnvironment.CBF_DIOGO))
                .addReserva(BotafogoEnvironment.NUMERO_HELTON , session.find(Jogador.class, BotafogoEnvironment.CBF_HELTON))
                .addReserva(BotafogoEnvironment.NUMERO_MARCIO , session.find(Jogador.class, BotafogoEnvironment.CBF_MARCIO))
                .addReserva(BotafogoEnvironment.NUMERO_EMERSON , session.find(Jogador.class, BotafogoEnvironment.CBF_EMERSON))
                .addReserva(BotafogoEnvironment.NUMERO_RENAN , session.find(Jogador.class, BotafogoEnvironment.CBF_RENAN))
                .addReserva(BotafogoEnvironment.NUMERO_JONATHAN , session.find(Jogador.class, BotafogoEnvironment.CBF_JONATHAN))
                .addReserva(BotafogoEnvironment.NUMERO_GEIRTON , session.find(Jogador.class, BotafogoEnvironment.CBF_GEIRTON))
                .addReserva(BotafogoEnvironment.NUMERO_VINICIUS , session.find(Jogador.class, BotafogoEnvironment.CBF_VINICIUS))
                .build();
    }
}