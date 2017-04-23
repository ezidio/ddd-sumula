package br.com.tdc.sumula.tradicional.model.environment;

import br.com.tdc.sumula.tradicional.model.Escalacao;
import br.com.tdc.sumula.tradicional.model.Jogador;

import static br.com.tdc.sumula.tradicional.model.environment.TimeEnvironmentUtils.criaJogador;
import static org.mockito.Mockito.mock;

/**
 * Created by everton on 21/04/17.
 */
public class BotafogoEnvironment {

    public static final Long ID = 2L;

    public static final Long CBF_SIDAO = 154179L;
    public static final Long CBF_EMERSON_SANTOS= 348257L;
    public static final Long CBF_CARLI= 540906L;
    public static final Long CBF_ALEMÃO= 295317L;
    public static final Long CBF_RODRIGO= 184455L;
    public static final Long CBF_VICTOR_LUIS = 309431L;
    public static final Long CBF_NEILTON= 316754L;
    public static final Long CBF_AIRTON= 186870L;
    public static final Long CBF_RODRIGO_PIMPAO= 291732L;
    public static final Long CBF_FERNANDO= 161437L;
    public static final Long CBF_DIOGO= 339876L;
    public static final Long CBF_HELTON= 303187L;
    public static final Long CBF_MARCIO= 315637L;
    public static final Long CBF_EMERSON= 154989L;
    public static final Long CBF_RENAN= 298402L;
    public static final Long CBF_JONATHAN= 310596L;
    public static final Long CBF_GEIRTON= 310627L;
    public static final Long CBF_VINICIUS= 387150L;
    public static final Long CBF_LEANDRO= 307735L;
    public static final Long CBF_GUSTAVO= 308427L;
    public static final Long CBF_GERVASIO= 540905L;
    public static final Long CBF_DUDU_CEARENSE = 139094L;
    public static final Long CBF_LUIS= 372434L;

    public static int NUMERO_SIDAO  = 1;
    public static int NUMERO_EMERSON_SANTOS = 2;
    public static int NUMERO_CARLI = 3;
    public static int NUMERO_ALEMÃO = 4;
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

    public static final br.com.tdc.sumula.tradicional.model.Time BOTAFOGO = TimeEnvironmentUtils.criaTime("Botafogo");

    public static final Jogador SIDAO = criaJogador(CBF_SIDAO, BOTAFOGO);
    public static final Jogador EMERSON_SANTOS = criaJogador(CBF_EMERSON_SANTOS, BOTAFOGO);
    public static final Jogador CARLI = criaJogador(CBF_CARLI, BOTAFOGO);
    public static final Jogador ALEMÃO = criaJogador(CBF_ALEMÃO, BOTAFOGO);
    public static final Jogador RODRIGO = criaJogador(CBF_RODRIGO, BOTAFOGO);
    public static final Jogador VICTOR_LUIS = criaJogador(CBF_VICTOR_LUIS, BOTAFOGO);
    public static final Jogador NEILTON = criaJogador(CBF_NEILTON, BOTAFOGO);
    public static final Jogador AIRTON = criaJogador(CBF_AIRTON, BOTAFOGO);
    public static final Jogador RODRIGO_PIMPAO = criaJogador(CBF_RODRIGO_PIMPAO, BOTAFOGO);
    public static final Jogador FERNANDO = criaJogador(CBF_FERNANDO, BOTAFOGO);
    public static final Jogador DIOGO = criaJogador(CBF_DIOGO, BOTAFOGO);
    public static final Jogador HELTON = criaJogador(CBF_HELTON, BOTAFOGO);
    public static final Jogador MARCIO = criaJogador(CBF_MARCIO, BOTAFOGO);
    public static final Jogador EMERSON = criaJogador(CBF_EMERSON, BOTAFOGO);
    public static final Jogador RENAN = criaJogador(CBF_RENAN, BOTAFOGO);
    public static final Jogador JONATHAN = criaJogador(CBF_JONATHAN, BOTAFOGO);
    public static final Jogador GEIRTON = criaJogador(CBF_GEIRTON, BOTAFOGO);
    public static final Jogador VINICIUS = criaJogador(CBF_VINICIUS, BOTAFOGO);
    public static final Jogador LEANDRO = criaJogador(CBF_LEANDRO, BOTAFOGO);
    public static final Jogador GUSTAVO = criaJogador(CBF_GUSTAVO, BOTAFOGO);
    public static final Jogador GERVASIO = criaJogador(CBF_GERVASIO, BOTAFOGO);
    public static final Jogador DUDU_CEARENSE = criaJogador(CBF_DUDU_CEARENSE, BOTAFOGO);
    public static final Jogador LUIS = criaJogador(CBF_LUIS, BOTAFOGO);

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
                .addTitular(NUMERO_ALEMÃO, ALEMÃO)
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
