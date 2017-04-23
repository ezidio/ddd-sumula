package br.com.everton.sumula.model.environment;

import br.com.everton.sumula.model.jogador.InscricaoCBF;
import br.com.everton.sumula.model.sumula.Escalacao;
import br.com.everton.sumula.model.jogador.Jogador;
import br.com.everton.sumula.model.Time;

import static br.com.everton.sumula.model.environment.TimeEnvironmentUtils.criaJogador;
import static br.com.everton.sumula.model.environment.TimeEnvironmentUtils.criaTime;

/**
 * Created by everton on 21/04/17.
 */
public class ChapecoenseEnvironment {

    public static final Long ID = 1L;

    public static final InscricaoCBF CBF_DANILO = InscricaoCBF.of(159209L);
    public static final InscricaoCBF CBF_NETO = InscricaoCBF.of(170061L);
    public static final InscricaoCBF CBF_DENER = InscricaoCBF.of(305876L);
    public static final InscricaoCBF CBF_LUCAS = InscricaoCBF.of(340218L);
    public static final InscricaoCBF CBF_WILLIAM = InscricaoCBF.of(169902L);
    public static final InscricaoCBF CBF_KEMPES = InscricaoCBF.of(165524L);
    public static final InscricaoCBF CBF_SERGIO_MANOEL = InscricaoCBF.of(184216L);
    public static final InscricaoCBF CBF_MATEUS = InscricaoCBF.of(351540L);
    public static final InscricaoCBF CBF_MATHEUS_BITECO = InscricaoCBF.of(347193L);
    public static final InscricaoCBF CBF_CLEBER_SANTANA = InscricaoCBF.of(140653L);
    public static final InscricaoCBF CBF_TIAGO_ROCHA = InscricaoCBF.of(348429L);
    public static final InscricaoCBF CBF_BRUNO_RANGEL = InscricaoCBF.of(158402L);
    public static final InscricaoCBF CBF_ODAIR = InscricaoCBF.of(146284L);
    public static final InscricaoCBF CBF_JAKSON = InscricaoCBF.of(311569L);
    public static final InscricaoCBF CBF_FILIPE_JOSE = InscricaoCBF.of(155389L);
    public static final InscricaoCBF CBF_ARTHUR = InscricaoCBF.of(305555L);
    public static final InscricaoCBF CBF_AILTON = InscricaoCBF.of(384435L);
    public static final InscricaoCBF CBF_ALAN_RUSCHEL = InscricaoCBF.of(187597L);

    public static final Time CHAPECOENSE = criaTime("Chapecoense");
    public static final Long CHAPECOENSE_ID = 1L;

    public static final Jogador DANILO = criaJogador(CBF_DANILO, CHAPECOENSE);
    public static final Jogador NETO = criaJogador(CBF_NETO, CHAPECOENSE);
    public static final Jogador DENER = criaJogador(CBF_DENER, CHAPECOENSE);
    public static final Jogador LUCAS = criaJogador(CBF_LUCAS, CHAPECOENSE);
    public static final Jogador WILLIAM = criaJogador(CBF_WILLIAM, CHAPECOENSE);
    public static final Jogador KEMPES = criaJogador(CBF_KEMPES, CHAPECOENSE);
    public static final Jogador SERGIO_MANOEL = criaJogador(CBF_SERGIO_MANOEL, CHAPECOENSE);
    public static final Jogador MATEUS = criaJogador(CBF_MATEUS, CHAPECOENSE);
    public static final Jogador MATHEUS_BITECO = criaJogador(CBF_MATHEUS_BITECO, CHAPECOENSE);
    public static final Jogador CLEBER_SANTANA = criaJogador(CBF_CLEBER_SANTANA, CHAPECOENSE);
    public static final Jogador TIAGO_ROCHA = criaJogador(CBF_TIAGO_ROCHA, CHAPECOENSE);
    public static final Jogador BRUNO_RANGEL = criaJogador(CBF_BRUNO_RANGEL, CHAPECOENSE);
    public static final Jogador ODAIR = criaJogador(CBF_ODAIR, CHAPECOENSE);
    public static final Jogador JAKSON = criaJogador(CBF_JAKSON, CHAPECOENSE);
    public static final Jogador FILIPE_JOSE = criaJogador(CBF_FILIPE_JOSE, CHAPECOENSE);
    public static final Jogador ARTHUR = criaJogador(CBF_ARTHUR, CHAPECOENSE);
    public static final Jogador AILTON = criaJogador(CBF_AILTON, CHAPECOENSE);
    public static final Jogador ALAN_RUSCHEL = criaJogador(CBF_ALAN_RUSCHEL, CHAPECOENSE);

    public static final int NUMERO_DANILO = 1;
    public static final int NUMERO_NETO = 4;
    public static final int NUMERO_DENER = 6;
    public static final int NUMERO_LUCAS = 23;
    public static final int NUMERO_WILLIAM = 27;
    public static final int NUMERO_KEMPES = 33;
    public static final int NUMERO_SERGIO_MANOEL = 35;
    public static final int NUMERO_MATEUS = 60;
    public static final int NUMERO_MATHEUS_BITECO = 77;
    public static final int NUMERO_CLEBER_SANTANA = 88;
    public static final int NUMERO_TIAGO_ROCHA = 94;
    public static final int NUMERO_BRUNO_RANGEL = 9;
    public static final int NUMERO_ODAIR = 30;
    public static final int NUMERO_JAKSON = 40;
    public static final int NUMERO_FILIPE_JOSE = 45;
    public static final int NUMERO_ARTHUR = 50;
    public static final int NUMERO_AILTON = 70;
    public static final int NUMERO_ALAN_RUSCHEL = 89;


    public static Escalacao getEscalacao() {
        return getEscalacaoBuilder()
                .build();
    }

    public static Escalacao.Builder getEscalacaoBuilder() {
        return Escalacao.newBuilder()
                .withTime(CHAPECOENSE)
                .addTitular(NUMERO_DANILO, DANILO)
                .addTitular(NUMERO_NETO, NETO)
                .addTitular(NUMERO_DENER, DENER)
                .addTitular(NUMERO_LUCAS, LUCAS)
                .addTitular(NUMERO_WILLIAM, WILLIAM)
                .addTitular(NUMERO_KEMPES, KEMPES)
                .addTitular(NUMERO_SERGIO_MANOEL, SERGIO_MANOEL)
                .addTitular(NUMERO_MATEUS, MATEUS)
                .addTitular(NUMERO_MATHEUS_BITECO, MATHEUS_BITECO)
                .addTitular(NUMERO_CLEBER_SANTANA, CLEBER_SANTANA)
                .addTitular(NUMERO_TIAGO_ROCHA, TIAGO_ROCHA)
                .addReserva(NUMERO_BRUNO_RANGEL, BRUNO_RANGEL)
                .addReserva(NUMERO_ODAIR, ODAIR)
                .addReserva(NUMERO_JAKSON, JAKSON)
                .addReserva(NUMERO_FILIPE_JOSE, FILIPE_JOSE)
                .addReserva(NUMERO_ARTHUR, ARTHUR)
                .addReserva(NUMERO_AILTON, AILTON)
                .addReserva(NUMERO_ALAN_RUSCHEL, ALAN_RUSCHEL);
    }


}
