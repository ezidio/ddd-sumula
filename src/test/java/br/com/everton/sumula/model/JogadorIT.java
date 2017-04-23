package br.com.everton.sumula.model;

import br.com.everton.sumula.infrastructure.SumulaConfiguration;
import br.com.everton.sumula.model.environment.ChapecoenseEnvironment;
import br.com.everton.sumula.model.jogador.Jogador;
import br.com.everton.sumula.model.jogador.JogadorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Teste integrado
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SumulaConfiguration.class})
public class JogadorIT {

    @Autowired
    private JogadorRepository jogador;

    @Test
    public void name() throws Exception {

        Jogador result = jogador.findOne(ChapecoenseEnvironment.CBF_AILTON);
        System.out.println(result.getNome());

    }
}
