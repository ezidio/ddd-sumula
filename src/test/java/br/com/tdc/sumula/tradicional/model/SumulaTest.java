package br.com.tdc.sumula.tradicional.model;

import br.com.tdc.sumula.tradicional.model.environment.BotafogoEnvironment;
import br.com.tdc.sumula.tradicional.model.environment.ChapecoenseEnvironment;
import br.com.tdc.sumula.tradicional.model.environment.TimeEnvironmentUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static br.com.tdc.sumula.tradicional.type.TempoDeJogo.primeiroTempo;
import static br.com.tdc.sumula.tradicional.type.TempoDeJogo.segundoTempo;
import static org.junit.Assert.*;

/**
 * Testes relacionados a sumula
 */
public class SumulaTest {

    private static final Long NUMERO_JOGO = 341L;
    private static final LocalDateTime DATA_JOGO = LocalDateTime.of(2016, 11, 16, 19, 30);
    private static final Campeonato CAMPEONATO = Mockito.mock(Campeonato.class);
    private static final Integer RODADA = 35;
    private static final Escalacao ESCALACAO_TIME_DA_CASA = BotafogoEnvironment.getEscalacao();
    private static final Escalacao ESCALACAO_TIME_VISITANTE = ChapecoenseEnvironment.getEscalacao();
    private static final Arbitragem ARBITRAGEM = Mockito.mock(Arbitragem.class);
    private static final Estadio ESTADIO = Mockito.mock(Estadio.class);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private Sumula.Builder builder;
    private static final String MOTIVO = "Desaprovar com palavras ou gestos as decisões da arbitragem - Desaprovar com palavras ou gestos as decisões da arbitragem";

    @Before
    public void setUp() throws Exception {
        this.builder = createBuilder();

    }

    private Sumula.Builder createBuilder() {
        return Sumula.newBuilder()
                .withNumeroJogo(NUMERO_JOGO)
                .withCampeonato(CAMPEONATO)
                .withRodada(RODADA)
                .withData(DATA_JOGO)
                .withArbitragem(ARBITRAGEM)
                .withCasa(ESCALACAO_TIME_DA_CASA)
                .withEstadio(ESTADIO)
                .withVisitante(ESCALACAO_TIME_VISITANTE);
    }

    @Test
    public void teste_create_sumula() throws Exception {

        Sumula sumula = builder.build();

        assertEquals(NUMERO_JOGO, sumula.getNumeroJogo());
        assertEquals(DATA_JOGO, sumula.getData());
        assertEquals(RODADA, sumula.getRodada());
        assertEquals(CAMPEONATO, sumula.getCampeonato());
        assertEquals(ESCALACAO_TIME_DA_CASA, sumula.getEscalacaoCasa());
        assertEquals(ESCALACAO_TIME_VISITANTE, sumula.getEscalacaoVisitante());
        assertEquals(ARBITRAGEM, sumula.getArbitragem());
    }


    @Test
    public void deve_lancar_exception_se_nao_informar_numero() throws Exception {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Numero do jogo deve ser informado.");

        builder.withNumeroJogo(null).build();
    }

    @Test
    public void deve_lancar_exception_se_nao_informar_data() throws Exception {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Data deve ser informada.");

        builder.withData(null).build();
    }

    @Test
    public void deve_lancar_exception_se_nao_informar_rodada() throws Exception {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Rodada deve ser informada.");

        builder.withRodada(null).build();
    }

    @Test
    public void deve_lancar_exception_se_nao_informar_estadio() throws Exception {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Estadio deve ser informado.");

        builder.withEstadio(null).build();
    }

    @Test
    public void deve_lancar_exception_se_nao_informar_time_da_casa() throws Exception {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Escalação do time da casa deve ser informada.");

        builder.withCasa(null).build();
    }

    @Test
    public void deve_lancar_exception_se_nao_informar_time_visitante() throws Exception {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Escalação do time visitante deve ser informada.");

        builder.withVisitante(null).build();
    }

    @Test
    public void deve_lancar_exception_se_nao_informar_arbitragem() throws Exception {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Arbitragem deve ser informada.");

        builder.withArbitragem(null).build();
    }


    @Test
    public void deve_lancar_exception_se_nao_informar_campeonato() throws Exception {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Campeonato deve ser informado.");

        builder.withCampeonato(null).build();
    }

    @Test
    public void deve_retornar_jogador_relacionado_time_casa() throws Exception {
        Sumula sumula = builder.build();
        Optional<Relacionado> jogador = sumula.getRelacionado(BotafogoEnvironment.BOTAFOGO, BotafogoEnvironment.NUMERO_DUDU_CEARENSE);

        assertTrue(jogador.isPresent());

        assertEquals(BotafogoEnvironment.DUDU_CEARENSE, jogador.get().getJogador());
        assertEquals(BotafogoEnvironment.NUMERO_DUDU_CEARENSE, jogador.get().getNumero());
    }

    @Test
    public void deve_retornar_jogador_relacionado_time_visitante() throws Exception {
        Sumula sumula = builder.build();
        Optional<Relacionado> jogador = sumula.getRelacionado(ChapecoenseEnvironment.CHAPECOENSE, ChapecoenseEnvironment.NUMERO_KEMPES);
        assertTrue(jogador.isPresent());

        assertEquals(ChapecoenseEnvironment.KEMPES, jogador.get().getJogador());
        assertEquals(ChapecoenseEnvironment.NUMERO_KEMPES, jogador.get().getNumero());
    }

    @Test
    public void deve_lancar_exception_buscar_jogador_relacionado_de_time_nao_presente_no_jogo() throws Exception {
        Sumula sumula = builder.build();
        Time timeNaoPresenteNoJogo = TimeEnvironmentUtils.criaTime("Maringa FC");
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Time Maringa FC não esta nesta partida.");

        sumula.getRelacionado(timeNaoPresenteNoJogo, 1);
    }


    @Test
    public void deve_retornar_que_esta_no_jogo_jogadores_titulares() throws Exception {
        Sumula sumula = builder.build();
        Relacionado jogadorTitular = sumula.getEscalacaoCasa().getTitulares().get(0);
        assertTrue(sumula.estaEmCampo(primeiroTempo(10), jogadorTitular));
    }



    @Test
    public void deve_retornar_que_nao_esta_no_jogo_jogadores_reservas() throws Exception {

        Sumula sumula = builder.build();

        Relacionado jogadorReserva = sumula.getEscalacaoCasa().getReservas().get(0);
        assertFalse(sumula.estaEmCampo(primeiroTempo(10), jogadorReserva));

    }
    @Test
    public void deve_retornar_que_nao_esta_no_jogo_jogadores_substituidos() throws Exception {

        Sumula sumula = builder.build();
        Relacionado jogadorTitular = sumula.getEscalacaoCasa().getTitulares().get(0);
        Relacionado jogadorReserva = sumula.getEscalacaoCasa().getReservas().get(0);
        sumula.addSubstituicao(primeiroTempo(10), jogadorTitular, jogadorReserva);

        assertTrue(sumula.estaEmCampo(primeiroTempo(5), jogadorTitular));
        assertFalse(sumula.estaEmCampo(primeiroTempo(20), jogadorTitular));

    }

    @Test
    public void deve_permitir_substituir_jogador_titular() throws Exception {

        Sumula sumula = builder.build();

        Relacionado jogadorTitular = sumula.getEscalacaoCasa().getTitulares().get(0);
        Relacionado jogadorReserva = sumula.getEscalacaoCasa().getReservas().get(0);

        sumula.addSubstituicao(primeiroTempo(10), jogadorTitular, jogadorReserva);

        List<Substituicao> substituicoes = sumula.getSubstituicoes();
        assertEquals(1, substituicoes.size());
        assertEquals(jogadorTitular, substituicoes.get(0).getSaiu());
        assertEquals(jogadorReserva, substituicoes.get(0).getEntrou());
        assertEquals(primeiroTempo(10), substituicoes.get(0).getTempo());
        assertEquals(BotafogoEnvironment.BOTAFOGO, substituicoes.get(0).getTime());
    }

    @Test
    public void deve_permitir_substituir_jogador_que_entrou_em_outra_substituicao() throws Exception {

        Sumula sumula = builder.build();

        Relacionado jogadorTitular = sumula.getEscalacaoCasa().getTitulares().get(0);
        Relacionado jogadorReserva1 = sumula.getEscalacaoCasa().getReservas().get(0);
        Relacionado jogadorReserva2 = sumula.getEscalacaoCasa().getReservas().get(1);

        sumula.addSubstituicao(primeiroTempo(10), jogadorTitular, jogadorReserva1);
        sumula.addSubstituicao(primeiroTempo(20), jogadorReserva1, jogadorReserva2);

        List<Substituicao> substituicoes = sumula.getSubstituicoes();
        assertEquals(2, substituicoes.size());

        assertTrue(sumula.estaEmCampo(primeiroTempo(5), jogadorTitular));
        assertFalse(sumula.estaEmCampo(primeiroTempo(5), jogadorReserva1));
        assertFalse(sumula.estaEmCampo(primeiroTempo(5), jogadorReserva2));

        assertFalse(sumula.estaEmCampo(primeiroTempo(15), jogadorTitular));
        assertTrue(sumula.estaEmCampo(primeiroTempo(15), jogadorReserva1));
        assertFalse(sumula.estaEmCampo(primeiroTempo(15), jogadorReserva2));

        assertFalse(sumula.estaEmCampo(primeiroTempo(25), jogadorTitular));
        assertFalse(sumula.estaEmCampo(primeiroTempo(25), jogadorReserva1));
        assertTrue(sumula.estaEmCampo(primeiroTempo(25), jogadorReserva2));
    }


    @Test
    public void deve_lancar_excecao_ao_substituir_jogador_reserva() throws Exception {

        Sumula sumula = builder.build();

        Relacionado jogadorReserva1 = sumula.getEscalacaoCasa().getReservas().get(0);
        Relacionado jogadorReserva2 = sumula.getEscalacaoCasa().getReservas().get(1);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Jogador não pode sair na substituição pois não está em campo.");
        sumula.addSubstituicao(primeiroTempo(10), jogadorReserva1, jogadorReserva2);
    }

    @Test
    public void deve_lancar_excecao_ao_substituir_jogador_titular_por_outro_titular() throws Exception {

        Sumula sumula = builder.build();

        Relacionado titular1 = sumula.getEscalacaoCasa().getTitulares().get(0);
        Relacionado titular2 = sumula.getEscalacaoCasa().getTitulares().get(1);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Jogador não pode entrar na substituição pois já está em campo.");
        sumula.addSubstituicao(primeiroTempo(10), titular1, titular2);
    }

    @Test
    public void deve_lancar_excecao_ao_substituir_jogador_titular_por_reserva_que_ja_entrou() throws Exception {

        Sumula sumula = builder.build();

        Relacionado titular1 = sumula.getEscalacaoCasa().getTitulares().get(0);
        Relacionado titular2 = sumula.getEscalacaoCasa().getTitulares().get(1);
        Relacionado reserva1 = sumula.getEscalacaoCasa().getReservas().get(0);

        sumula.addSubstituicao(primeiroTempo(10), titular1, reserva1);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Jogador não pode entrar na substituição pois já está em campo.");
        sumula.addSubstituicao(primeiroTempo(20), titular2, reserva1);

    }

    @Test
    public void deve_lancar_excecao_ao_substituir_jogador_ja_substituido() throws Exception {

        Sumula sumula = builder.build();

        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);
        Relacionado reserva1 = sumula.getEscalacaoCasa().getReservas().get(0);
        Relacionado reserva2 = sumula.getEscalacaoCasa().getReservas().get(1);

        sumula.addSubstituicao(primeiroTempo(10), titular, reserva1);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Jogador não pode sair na substituição pois não está em campo.");
        sumula.addSubstituicao(primeiroTempo(20), titular, reserva2);
    }

    @Test
    public void deve_lancar_excecao_ao_substituir_jogador_que_ja_possui_substituicao_independente_do_tempo() throws Exception {

        Sumula sumula = builder.build();

        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);
        Relacionado reserva1 = sumula.getEscalacaoCasa().getReservas().get(0);
        Relacionado reserva2 = sumula.getEscalacaoCasa().getReservas().get(1);

        sumula.addSubstituicao(primeiroTempo(20), titular, reserva2);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Jogador não pode sair na substituição pois já existe uma substuição para ele.");
        sumula.addSubstituicao(primeiroTempo(10), titular, reserva1);

    }

    @Test
    public void deve_lancar_excecao_ao_substituir_jogadores_de_times_diferentes() throws Exception {
        Sumula sumula = builder.build();

        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);
        Relacionado reserva = sumula.getEscalacaoVisitante().getReservas().get(0);
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Substituição deve ser realizada entre jogadores do mesmo time.");

        sumula.addSubstituicao(primeiroTempo(20), titular, reserva);
    }

    @Test
    public void deve_lancar_excecao_ao_time_substituir_mais_de_3_vezes() throws Exception {
        Sumula sumula = builder.build();

        Relacionado titular1 = sumula.getEscalacaoCasa().getTitulares().get(0);
        Relacionado titular2 = sumula.getEscalacaoCasa().getTitulares().get(1);
        Relacionado titular3 = sumula.getEscalacaoCasa().getTitulares().get(2);
        Relacionado titular4 = sumula.getEscalacaoCasa().getTitulares().get(3);
        Relacionado reserva1 = sumula.getEscalacaoCasa().getReservas().get(0);
        Relacionado reserva2 = sumula.getEscalacaoCasa().getReservas().get(1);
        Relacionado reserva3 = sumula.getEscalacaoCasa().getReservas().get(2);
        Relacionado reserva4 = sumula.getEscalacaoCasa().getReservas().get(3);


        sumula.addSubstituicao(primeiroTempo(20), titular1, reserva1);
        sumula.addSubstituicao(primeiroTempo(20), titular2, reserva2);
        sumula.addSubstituicao(primeiroTempo(20), titular3, reserva3);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Cada time pode substituir no máximo 3 vezes.");
        sumula.addSubstituicao(primeiroTempo(20), titular4, reserva4);
    }

    @Test
    public void deve_lancar_excecao_ao_substituir_sem_informar_tempo() throws Exception {

        Sumula sumula = builder.build();

        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);
        Relacionado reserva = sumula.getEscalacaoCasa().getReservas().get(0);

        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Não é possivel substituir sem informar o tempo.");
        sumula.addSubstituicao(null, titular, reserva);
    }

    @Test
    public void deve_lancar_excecao_ao_substituir_sem_informar_jogador_que_ira_sair() throws Exception {

        Sumula sumula = builder.build();

        Relacionado reserva = sumula.getEscalacaoCasa().getReservas().get(0);

        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Não é possivel substituir sem informar o jogador que irá sair.");
        sumula.addSubstituicao(primeiroTempo(20), null, reserva);
    }

    @Test
    public void deve_lancar_excecao_ao_substituir_sem_informar_jogador_que_ira_entrar() throws Exception {

        Sumula sumula = builder.build();

        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);

        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Não é possivel substituir sem informar o jogador que irá entrar.");
        sumula.addSubstituicao(primeiroTempo(20), titular, null);
    }

    @Test
    public void deve_permitir_amarelo_a_jogador_titular() throws Exception {

        Sumula sumula = builder.build();

        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);

        sumula.addCartaoAmarelo(primeiroTempo(10), titular, MOTIVO);

        List<Cartao> cartoesAmarelo = sumula.getCartoesAmarelo();
        assertEquals(1, cartoesAmarelo.size());
        assertEquals(MOTIVO, cartoesAmarelo.get(0).getMotivo());
        assertEquals(primeiroTempo(10), cartoesAmarelo.get(0).getTempo());
        assertEquals(titular, cartoesAmarelo.get(0).getRelacionado());
    }

    @Test
    public void deve_permitir_adicionar_cartao_amarelo_a_jogador_reserva() throws Exception {

        Sumula sumula = builder.build();

        Relacionado reserva = sumula.getEscalacaoCasa().getReservas().get(0);
        sumula.addCartaoAmarelo(primeiroTempo(10), reserva, MOTIVO);

        assertTrue(sumula.temAmarelo(primeiroTempo(11), reserva));
    }

    @Test
    public void deve_permitir_adicionar_cartao_amarelo_a_jogador_ja_substituido() throws Exception {

        Sumula sumula = builder.build();

        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);
        Relacionado reserva = sumula.getEscalacaoCasa().getReservas().get(0);

        sumula.addSubstituicao(primeiroTempo(10), titular, reserva);
        sumula.addCartaoAmarelo(primeiroTempo(20), titular, MOTIVO);
        assertTrue(sumula.temAmarelo(primeiroTempo(21), titular));
    }

    @Test
    public void jogador_deve_ser_expulso_no_segundo_cartao_amarelo() throws Exception {

        Sumula sumula = builder.build();

        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);

        sumula.addCartaoAmarelo(primeiroTempo(20), titular, MOTIVO);
        sumula.addCartaoAmarelo(primeiroTempo(30), titular, MOTIVO);

        assertTrue(sumula.estaEmCampo(primeiroTempo(25), titular));
        assertFalse(sumula.jogadorExpulso(primeiroTempo(25), titular));
        assertTrue(sumula.temAmarelo(primeiroTempo(25), titular));

        assertFalse(sumula.estaEmCampo(primeiroTempo(35), titular));
        assertTrue(sumula.jogadorExpulso(primeiroTempo(35), titular));
        assertTrue(sumula.temAmarelo(primeiroTempo(35), titular));

        assertEquals(1, sumula.getCartoesAmarelo().size());
        assertEquals(1, sumula.getCartoesVermelho().size());
    }

    @Test
    public void deve_permitir_cartao_vermelho_direto_a_jogador_titular() throws Exception {

        Sumula sumula = builder.build();

        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);

        sumula.addCartaoVermelho(primeiroTempo(20), titular, MOTIVO);

        assertFalse(sumula.estaEmCampo(primeiroTempo(35), titular));
        assertTrue(sumula.jogadorExpulso(primeiroTempo(35), titular));
        assertFalse(sumula.temAmarelo(primeiroTempo(35), titular));

        assertEquals(0, sumula.getCartoesAmarelo().size());
        assertEquals(1, sumula.getCartoesVermelho().size());
    }

    @Test
    public void deve_lancar_excecao_ao_expulsar_jogador_ja_expulso() throws Exception {
        Sumula sumula = builder.build();

        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);

        sumula.addCartaoVermelho(primeiroTempo(20), titular, MOTIVO);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Não é possível expulsar jogador já expulso.");
        sumula.addCartaoVermelho(primeiroTempo(30), titular, MOTIVO);

    }

    @Test
    public void deve_lancar_excecao_ao_dar_amarelo_a_jogador_ja_expulso() throws Exception {
        Sumula sumula = builder.build();

        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);

        sumula.addCartaoVermelho(primeiroTempo(20), titular, MOTIVO);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Não é possível dar cartão amarelo á jogador já expulso.");
        sumula.addCartaoAmarelo(primeiroTempo(30), titular, MOTIVO);
    }

    @Test
    public void deve_lancar_excecao_ao_dar_amarelo_sem_informar_o_jogador() throws Exception {
        Sumula sumula = builder.build();

        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Não é possível dar cartão amarelo sem informar o jogador.");
        sumula.addCartaoAmarelo(primeiroTempo(30), null, MOTIVO);

    }

    @Test
    public void deve_lancar_excecao_ao_dar_amarelo_sem_informar_tempo() throws Exception {
        Sumula sumula = builder.build();

        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Não é possível dar cartão amarelo sem informar o tempo.");
        sumula.addCartaoAmarelo(null, titular, MOTIVO);

    }

    @Test
    public void deve_lancar_excecao_ao_dar_amarelo_com_motivo_vazio() throws Exception {
        Sumula sumula = builder.build();

        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Não é possível dar cartão amarelo sem informar o motivo.");
        sumula.addCartaoAmarelo(segundoTempo(20), titular, "");

    }

    @Test
    public void deve_lancar_excecao_ao_dar_vermelho_sem_informar_o_jogador() throws Exception {
        Sumula sumula = builder.build();

        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Não é possível dar cartão vermelho sem informar o jogador.");
        sumula.addCartaoVermelho(primeiroTempo(30), null, MOTIVO);

    }

    @Test
    public void deve_lancar_excecao_ao_dar_vermelho_sem_informar_tempo() throws Exception {
        Sumula sumula = builder.build();

        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Não é possível dar cartão vermelho sem informar o tempo.");
        sumula.addCartaoVermelho(null, titular, MOTIVO);

    }

    @Test
    public void deve_lancar_excecao_ao_dar_vermelho_com_motivo_vazio() throws Exception {
        Sumula sumula = builder.build();

        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Não é possível dar cartão vermelho sem informar o motivo.");
        sumula.addCartaoVermelho(segundoTempo(20), titular, "");

    }

    @Test
    public void deve_lancar_excecao_ao_substituir_jogador_expulso() throws Exception {

        Sumula sumula = builder.build();
        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);
        Relacionado reserva = sumula.getEscalacaoCasa().getReservas().get(0);
        sumula.addCartaoVermelho(primeiroTempo(20), titular, MOTIVO);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Jogador não pode sair na substituição pois foi expulso.");
        sumula.addSubstituicao(primeiroTempo(25), titular, reserva);
    }

    @Test
    public void deve_lancar_excecao_ao_entrar_em_substuicao_jogador_expulso() throws Exception {
        Sumula sumula = builder.build();
        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);
        Relacionado reserva = sumula.getEscalacaoCasa().getReservas().get(0);
        sumula.addCartaoVermelho(primeiroTempo(20), reserva, MOTIVO);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Jogador não pode entrar na substituição pois foi expulso.");
        sumula.addSubstituicao(primeiroTempo(25), titular, reserva);
    }

    @Test
    public void deve_permitir_gol_para_jogador_titular() throws Exception {
        Sumula sumula = builder.build();
        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);

        sumula.addGol(Gol.normal(primeiroTempo(10), titular));

        List<Gol> gols = sumula.getGols();
        assertEquals(1, gols.size());

        assertEquals(1, sumula.golsTimeCasa());
        assertEquals(0, sumula.golsTimeVisitante());
    }

    @Test
    public void deve_contabilizar_gols() throws Exception {
        Sumula sumula = builder.build();
        Relacionado titularCasa = sumula.getEscalacaoCasa().getTitulares().get(0);
        Relacionado titularVisitante = sumula.getEscalacaoVisitante().getTitulares().get(0);

        sumula.addGol(Gol.normal(primeiroTempo(10), titularCasa));
        sumula.addGol(Gol.normal(primeiroTempo(20), titularCasa));
        sumula.addGol(Gol.normal(primeiroTempo(30), titularVisitante));

        List<Gol> gols = sumula.getGols();
        assertEquals(3, gols.size());

        assertEquals(2, sumula.golsTimeCasa());
        assertEquals(1, sumula.golsTimeVisitante());
    }

    @Test
    public void gol_contra_deve_contar_para_o_time_contrario() throws Exception {
        Sumula sumula = builder.build();
        Relacionado titularCasa = sumula.getEscalacaoCasa().getTitulares().get(0);
        Time timeVisitante = sumula.getEscalacaoVisitante().getTime();

        sumula.addGol(Gol.contra(primeiroTempo(10), titularCasa, timeVisitante));

        assertEquals(0, sumula.golsTimeCasa());
        assertEquals(1, sumula.golsTimeVisitante());
    }

    @Test
    public void deve_permitir_gol_para_jogador_que_entrou_durante_o_jogo() throws Exception {
        Sumula sumula = builder.build();
        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);
        Relacionado reserva = sumula.getEscalacaoCasa().getReservas().get(0);

        sumula.addSubstituicao(primeiroTempo(20), titular, reserva);
        sumula.addGol(Gol.normal(segundoTempo(10), reserva));

        assertEquals(1, sumula.golsTimeCasa());
        assertEquals(0, sumula.golsTimeVisitante());
    }

    @Test
    public void deve_lancar_excecao_ao_adicionar_gol_a_jogador_reserva() throws Exception {
        Sumula sumula = builder.build();
        Relacionado reserva = sumula.getEscalacaoCasa().getReservas().get(0);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Não pode ser anotado gol para jogador que não está em campo.");
        sumula.addGol(Gol.normal(segundoTempo(10), reserva));

    }

    @Test
    public void deve_lancar_excecao_ao_adicionar_gol_a_jogador_ja_substituido() throws Exception {
        Sumula sumula = builder.build();
        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);
        Relacionado reserva = sumula.getEscalacaoCasa().getReservas().get(0);

        sumula.addSubstituicao(primeiroTempo(20), titular, reserva);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Não pode ser anotado gol para jogador que não está em campo.");
        sumula.addGol(Gol.normal(segundoTempo(10), titular));

    }

    @Test
    public void deve_lancar_excecao_ao_adicionar_gol_a_jogador_expulso() throws Exception {
        Sumula sumula = builder.build();
        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);

        sumula.addCartaoVermelho(primeiroTempo(10), titular, MOTIVO);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Não pode ser anotado gol para jogador expulso.");
        sumula.addGol(Gol.normal(segundoTempo(10), titular));
    }

    @Test
    public void deve_lancar_excecao_ao_adicionar_gol_nulo() throws Exception {

        Sumula sumula = builder.build();

        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Gol adicionado não pode ser nulo.");
        sumula.addGol(null);

    }

    @Test
    public void deve_lancar_excecao_ao_adicionar_gol_de_time_fora_da_partida() throws Exception {

        Time timeEstranho = Mockito.mock(Time.class);

        Sumula sumula = builder.build();
        Relacionado titular = sumula.getEscalacaoCasa().getTitulares().get(0);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Gol deve ser favorecido a um time pertencente a partida.");
        sumula.addGol(Gol.contra(segundoTempo(20), titular, timeEstranho));
    }

    @Test
    public void deve_lancar_excecao_ao_adicionar_gol_de_jogador_nao_relacionado() throws Exception {

        Sumula sumula = builder.build();

        Relacionado relacionado = Mockito.mock(Relacionado.class);
        Mockito.when(relacionado.getTime()).thenReturn(sumula.getTimeCasa());

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Jogador vinculado ao gol não esta relacionado por nenhum time.");
        sumula.addGol(Gol.normal(segundoTempo(20), relacionado));
    }
}