package br.com.everton.sumula.model.environment;

import br.com.everton.sumula.model.Time;
import br.com.everton.sumula.model.jogador.InscricaoCBF;
import br.com.everton.sumula.model.sumula.Escalacao;
import br.com.everton.sumula.model.jogador.Jogador;

import static org.mockito.Mockito.mock;

/**
 * Created by everton on 21/04/17.
 */
public class BotafogoEnvironment {

    public static final Long ID = 2L;

    public static final InscricaoCBF CBF_SIDAO = InscricaoCBF.of(154179L);
    public static final InscricaoCBF CBF_EMERSON_SANTOS= InscricaoCBF.of(348257L);
    public static final InscricaoCBF CBF_CARLI= InscricaoCBF.of(540906L);
    public static final InscricaoCBF CBF_ALEMAO= InscricaoCBF.of(295317L);
    public static final InscricaoCBF CBF_RODRIGO= InscricaoCBF.of(184455L);
    public static final InscricaoCBF CBF_VICTOR_LUIS = InscricaoCBF.of(309431L);
    public static final InscricaoCBF CBF_NEILTON= InscricaoCBF.of(316754L);
    public static final InscricaoCBF CBF_AIRTON= InscricaoCBF.of(186870L);
    public static final InscricaoCBF CBF_RODRIGO_PIMPAO= InscricaoCBF.of(291732L);
    public static final InscricaoCBF CBF_FERNANDO= InscricaoCBF.of(161437L);
    public static final InscricaoCBF CBF_DIOGO= InscricaoCBF.of(339876L);
    public static final InscricaoCBF CBF_HELTON= InscricaoCBF.of(303187L);
    public static final InscricaoCBF CBF_MARCIO= InscricaoCBF.of(315637L);
    public static final InscricaoCBF CBF_EMERSON= InscricaoCBF.of(154989L);
    public static final InscricaoCBF CBF_RENAN= InscricaoCBF.of(298402L);
    public static final InscricaoCBF CBF_JONATHAN= InscricaoCBF.of(310596L);
    public static final InscricaoCBF CBF_GEIRTON= InscricaoCBF.of(310627L);
    public static final InscricaoCBF CBF_VINICIUS= InscricaoCBF.of(387150L);
    public static final InscricaoCBF CBF_LEANDRO= InscricaoCBF.of(307735L);
    public static final InscricaoCBF CBF_GUSTAVO= InscricaoCBF.of(308427L);
    public static final InscricaoCBF CBF_GERVASIO= InscricaoCBF.of(540905L);
    public static final InscricaoCBF CBF_DUDU_CEARENSE = InscricaoCBF.of(139094L);
    public static final InscricaoCBF CBF_LUIS= InscricaoCBF.of(372434L);

    public static int NUMERO_SIDAO  = 1;
    public static int NUMERO_EMERSON_SANTOS = 2;
    public static int NUMERO_CARLI = 3;
    public static int NUMERO_ALEMAO = 4;
    public static int NUMERO_RODRIGO = 5;
    public static int NUMERO_VICTOR_LUIS  = 6;
    public static int NUMERO_NEILTON = 7;
    public static int NUMERO_AIRTON = 8;
    public static int NUMERO_RODRIGO_PIMPAO = 9;
    public static int NUMERO_FERNANDO = 10;
    public static int NUMERO_DIOGO = 11;
    public static int NUMERO_HELTON = 12;
    public static int NUMERO_MARCIO = 13;
    public static int NUMERO_EMERSON = 14;
    public static int NUMERO_RENAN = 15;
    public static int NUMERO_JONATHAN = 16;
    public static int NUMERO_GEIRTON = 17;
    public static int NUMERO_VINICIUS = 18;
    public static int NUMERO_LEANDRO = 19;
    public static int NUMERO_GUSTAVO = 20;
    public static int NUMERO_GERVASIO = 21;
    public static int NUMERO_DUDU_CEARENSE  = 22;
    public static int NUMERO_LUIS = 23;

    public static final Time BOTAFOGO = TimeEnvironmentUtils.criaTime("Botafogo");
    public static final Long BOTAFOGO_ID = 2L;

    public static final Jogador SIDAO = TimeEnvironmentUtils.criaJogador(CBF_SIDAO, BOTAFOGO);
    public static final Jogador EMERSON_SANTOS = TimeEnvironmentUtils.criaJogador(CBF_EMERSON_SANTOS, BOTAFOGO);
    public static final Jogador CARLI = TimeEnvironmentUtils.criaJogador(CBF_CARLI, BOTAFOGO);
    public static final Jogador ALEMAO = TimeEnvironmentUtils.criaJogador(CBF_ALEMAO, BOTAFOGO);
    public static final Jogador RODRIGO = TimeEnvironmentUtils.criaJogador(CBF_RODRIGO, BOTAFOGO);
    public static final Jogador VICTOR_LUIS = TimeEnvironmentUtils.criaJogador(CBF_VICTOR_LUIS, BOTAFOGO);
    public static final Jogador NEILTON = TimeEnvironmentUtils.criaJogador(CBF_NEILTON, BOTAFOGO);
    public static final Jogador AIRTON = TimeEnvironmentUtils.criaJogador(CBF_AIRTON, BOTAFOGO);
    public static final Jogador RODRIGO_PIMPAO = TimeEnvironmentUtils.criaJogador(CBF_RODRIGO_PIMPAO, BOTAFOGO);
    public static final Jogador FERNANDO = TimeEnvironmentUtils.criaJogador(CBF_FERNANDO, BOTAFOGO);
    public static final Jogador DIOGO = TimeEnvironmentUtils.criaJogador(CBF_DIOGO, BOTAFOGO);
    public static final Jogador HELTON = TimeEnvironmentUtils.criaJogador(CBF_HELTON, BOTAFOGO);
    public static final Jogador MARCIO = TimeEnvironmentUtils.criaJogador(CBF_MARCIO, BOTAFOGO);
    public static final Jogador EMERSON = TimeEnvironmentUtils.criaJogador(CBF_EMERSON, BOTAFOGO);
    public static final Jogador RENAN = TimeEnvironmentUtils.criaJogador(CBF_RENAN, BOTAFOGO);
    public static final Jogador JONATHAN = TimeEnvironmentUtils.criaJogador(CBF_JONATHAN, BOTAFOGO);
    public static final Jogador GEIRTON = TimeEnvironmentUtils.criaJogador(CBF_GEIRTON, BOTAFOGO);
    public static final Jogador VINICIUS = TimeEnvironmentUtils.criaJogador(CBF_VINICIUS, BOTAFOGO);
    public static final Jogador LEANDRO = TimeEnvironmentUtils.criaJogador(CBF_LEANDRO, BOTAFOGO);
    public static final Jogador GUSTAVO = TimeEnvironmentUtils.criaJogador(CBF_GUSTAVO, BOTAFOGO);
    public static final Jogador GERVASIO = TimeEnvironmentUtils.criaJogador(CBF_GERVASIO, BOTAFOGO);
    public static final Jogador DUDU_CEARENSE = TimeEnvironmentUtils.criaJogador(CBF_DUDU_CEARENSE, BOTAFOGO);
    public static final Jogador LUIS = TimeEnvironmentUtils.criaJogador(CBF_LUIS, BOTAFOGO);

    public static Escalacao getEscalacao() {
        return getEscalacaoBuilder()
                .build();
    }

    public static Escalacao.Builder getEscalacaoBuilder() {
        return Escalacao.newBuilder()
                .withTime(BOTAFOGO)
                .addTitular(NUMERO_SIDAO , SIDAO)
                .addTitular(NUMERO_EMERSON_SANTOS, EMERSON_SANTOS)
                .addTitular(NUMERO_CARLI, CARLI)
                .addTitular(NUMERO_ALEMAO, ALEMAO)
                .addTitular(NUMERO_RODRIGO, RODRIGO)
                .addTitular(NUMERO_VICTOR_LUIS , VICTOR_LUIS)
                .addTitular(NUMERO_NEILTON, NEILTON)
                .addTitular(NUMERO_AIRTON, AIRTON)
                .addTitular(NUMERO_RODRIGO_PIMPAO, RODRIGO_PIMPAO)
                .addTitular(NUMERO_FERNANDO, FERNANDO)
                .addTitular(NUMERO_DIOGO, DIOGO)
                .addReserva(NUMERO_HELTON, HELTON)
                .addReserva(NUMERO_MARCIO, MARCIO)
                .addReserva(NUMERO_EMERSON, EMERSON)
                .addReserva(NUMERO_RENAN, RENAN)
                .addReserva(NUMERO_JONATHAN, JONATHAN)
                .addReserva(NUMERO_GEIRTON, GEIRTON)
                .addReserva(NUMERO_VINICIUS, VINICIUS)
                .addReserva(NUMERO_LEANDRO, LEANDRO)
                .addReserva(NUMERO_GUSTAVO, GUSTAVO)
                .addReserva(NUMERO_GERVASIO, GERVASIO)
                .addReserva(NUMERO_DUDU_CEARENSE , DUDU_CEARENSE)
                .addReserva(NUMERO_LUIS, LUIS);
    }



}
