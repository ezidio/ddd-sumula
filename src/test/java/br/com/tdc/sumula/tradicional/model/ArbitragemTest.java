package br.com.tdc.sumula.tradicional.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by everton on 21/04/17.
 */
public class ArbitragemTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void test_create() throws Exception {

        Arbitro dewson = mock(Arbitro.class);
        Arbitro assistente1 = mock(Arbitro.class);
        Arbitro assistente2 = mock(Arbitro.class);
        Arbitro quartoArbitro = mock(Arbitro.class);

        Arbitragem arbitragem = Arbitragem.newBuilder()
                .withArbitro(dewson)
                .withAssistente1(assistente1)
                .withAssistente2(assistente2)
                .withQuartoArbitro(quartoArbitro)
                .build();

        assertEquals(dewson, arbitragem.getArbitro());
        assertEquals(assistente1, arbitragem.getAssistente1());
        assertEquals(assistente2, arbitragem.getAssistente2());
        assertEquals(quartoArbitro, arbitragem.getQuartoArbitro());
    }


    @Test
    public void deve_lancar_exception_se_o_arbitro_nao_for_informado() throws Exception {

        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("O arbitro deve ser informado.");

        Arbitragem.newBuilder()
                .withAssistente1(mock(Arbitro.class))
                .withAssistente2(mock(Arbitro.class))
                .withQuartoArbitro(mock(Arbitro.class))
                .build();
    }

    @Test
    public void deve_lancar_exception_se_o_assistente1_nao_for_informado() throws Exception {

        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("O assistente 1 deve ser informado.");

        Arbitragem.newBuilder()
                .withArbitro(mock(Arbitro.class))
                .withAssistente2(mock(Arbitro.class))
                .withQuartoArbitro(mock(Arbitro.class))
                .build();
    }

    @Test
    public void deve_lancar_exception_se_o_asssitente2_nao_for_informado() throws Exception {

        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("O assistente 2 deve ser informado.");

        Arbitragem.newBuilder()
                .withArbitro(mock(Arbitro.class))
                .withAssistente1(mock(Arbitro.class))
                .withQuartoArbitro(mock(Arbitro.class))
                .build();
    }

    @Test
    public void deve_lancar_exception_se_o_quarto_arbitro_nao_for_informado() throws Exception {

        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("O quarto arbitro deve ser informado.");

        Arbitragem.newBuilder()
                .withArbitro(mock(Arbitro.class))
                .withAssistente1(mock(Arbitro.class))
                .withAssistente2(mock(Arbitro.class))
                .build();
    }

    @Test
    public void deve_lancar_exception_se_o_arbitro_estiver_como_assistente1() throws Exception {

        Arbitro arbitro = mock(Arbitro.class);
        Mockito.when(arbitro.getNome()).thenReturn("Marcio");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("O arbitro Marcio esta definido como arbitro e assistente 1.");

        Arbitragem.newBuilder()
                .withArbitro(arbitro)
                .withAssistente1(arbitro)
                .withAssistente2(mock(Arbitro.class))
                .withQuartoArbitro(mock(Arbitro.class))
                .build();
    }



    @Test
    public void deve_lancar_exception_se_o_arbitro_estiver_como_assistente2() throws Exception {

        Arbitro arbitro = mock(Arbitro.class);
        Mockito.when(arbitro.getNome()).thenReturn("Marcio");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("O arbitro Marcio esta definido como arbitro e assistente 2.");

        Arbitragem.newBuilder()
                .withArbitro(arbitro)
                .withAssistente1(mock(Arbitro.class))
                .withAssistente2(arbitro)
                .withQuartoArbitro(mock(Arbitro.class))
                .build();
    }
    @Test
    public void deve_lancar_exception_se_o_arbitro_estiver_como_quarto_arbitro() throws Exception {

        Arbitro arbitro = mock(Arbitro.class);
        Mockito.when(arbitro.getNome()).thenReturn("Marcio");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("O arbitro Marcio esta definido como arbitro e quarto arbitro.");

        Arbitragem.newBuilder()
                .withArbitro(arbitro)
                .withAssistente1(mock(Arbitro.class))
                .withAssistente2(mock(Arbitro.class))
                .withQuartoArbitro(arbitro)
                .build();
    }

    @Test
    public void deve_lancar_exception_se_o_assistente1_estiver_como_assistente2() throws Exception {

        Arbitro assistente = mock(Arbitro.class);
        Mockito.when(assistente.getNome()).thenReturn("Marcio");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("O arbitro Marcio esta definido como assistente 1 e assistente 2.");

        Arbitragem.newBuilder()
                .withArbitro(mock(Arbitro.class))
                .withAssistente1(assistente)
                .withAssistente2(assistente)
                .withQuartoArbitro(mock(Arbitro.class))
                .build();
    }

    @Test
    public void deve_lancar_exception_se_o_assistente1_estiver_como_quarto_arbitro() throws Exception {

        Arbitro assistente = mock(Arbitro.class);
        Mockito.when(assistente.getNome()).thenReturn("Marcio");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("O arbitro Marcio esta definido como assistente 1 e quarto arbitro.");

        Arbitragem.newBuilder()
                .withArbitro(mock(Arbitro.class))
                .withAssistente1(assistente)
                .withAssistente2(mock(Arbitro.class))
                .withQuartoArbitro(assistente)
                .build();
    }

    @Test
    public void deve_lancar_exception_se_o_assistente2_estiver_como_quarto_arbitro() throws Exception {

        Arbitro assistente = mock(Arbitro.class);
        Mockito.when(assistente.getNome()).thenReturn("Marcio");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("O arbitro Marcio esta definido como assistente 2 e quarto arbitro.");

        Arbitragem.newBuilder()
                .withArbitro(mock(Arbitro.class))
                .withAssistente1(mock(Arbitro.class))
                .withAssistente2(assistente)
                .withQuartoArbitro(assistente)
                .build();
    }
}