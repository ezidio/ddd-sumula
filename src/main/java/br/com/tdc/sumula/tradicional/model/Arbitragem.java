package br.com.tdc.sumula.tradicional.model;

import org.apache.commons.lang3.Validate;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.notNull;

/**
 * Created by everton on 21/04/17.
 */
@Embeddable
public class Arbitragem {

    @ManyToOne(targetEntity = Arbitro.class)
    private Arbitro arbitro;

    @ManyToOne(targetEntity = Arbitro.class)
    private Arbitro quartoArbitro;

    @ManyToOne(targetEntity = Arbitro.class)
    private Arbitro assistente1;

    @ManyToOne(targetEntity = Arbitro.class)
    private Arbitro assistente2;

    private Arbitragem(Builder builder) {
        this.arbitro = notNull(builder.arbitro, "O arbitro deve ser informado.");
        this.assistente1 = notNull(builder.assistente1, "O assistente 1 deve ser informado.");
        this.assistente2 = notNull(builder.assistente2, "O assistente 2 deve ser informado.");
        this.quartoArbitro = notNull(builder.quartoArbitro, "O quarto arbitro deve ser informado.");

        isTrue(!arbitro.equals(assistente1), "O arbitro %s esta definido como arbitro e assistente 1.", arbitro.getNome());
        isTrue(!arbitro.equals(assistente2), "O arbitro %s esta definido como arbitro e assistente 2.", arbitro.getNome());
        isTrue(!arbitro.equals(quartoArbitro), "O arbitro %s esta definido como arbitro e quarto arbitro.", arbitro.getNome());
        isTrue(!assistente1.equals(assistente2), "O arbitro %s esta definido como assistente 1 e assistente 2.", assistente1.getNome());
        isTrue(!assistente1.equals(quartoArbitro), "O arbitro %s esta definido como assistente 1 e quarto arbitro.", assistente1.getNome());
        isTrue(!assistente2.equals(quartoArbitro), "O arbitro %s esta definido como assistente 2 e quarto arbitro.", assistente2.getNome());
    }

    protected Arbitragem() {
        // Construtor vazio para serialização
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public Arbitro getQuartoArbitro() {
        return quartoArbitro;
    }

    public Arbitro getAssistente1() {
        return assistente1;
    }

    public Arbitro getAssistente2() {
        return assistente2;
    }

    public static final class Builder {
        private Arbitro arbitro;
        private Arbitro quartoArbitro;
        private Arbitro assistente1;
        private Arbitro assistente2;

        private Builder() {
        }

        public Builder withArbitro(Arbitro val) {
            arbitro = val;
            return this;
        }

        public Builder withQuartoArbitro(Arbitro val) {
            quartoArbitro = val;
            return this;
        }

        public Builder withAssistente1(Arbitro val) {
            assistente1 = val;
            return this;
        }

        public Builder withAssistente2(Arbitro val) {
            assistente2 = val;
            return this;
        }

        public Arbitragem build() {
            return new Arbitragem(this);
        }
    }
}
