package br.com.tdc.sumula.tradicional.type;

import br.com.tdc.sumula.tradicional.model.Tempo;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

/**
 * Definição de tempo de jogo
 */
@Embeddable
public class TempoDeJogo implements Comparable<TempoDeJogo> {

    @NotNull
    private int minuto;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Tempo tempo;

    public TempoDeJogo(int minuto, Tempo tempo) {
        this.minuto = minuto;
        this.tempo = tempo;
    }

    public int getMinuto() {
        return minuto;
    }

    public Tempo getTempo() {
        return tempo;
    }

    public boolean isAfter(TempoDeJogo o) {
        return this.compareTo(o) > 0;
    }

    public boolean isBefore(TempoDeJogo o) {
        return this.compareTo(o) < 0;
    }

    public static TempoDeJogo of(int minuto, Tempo tempo) {
        return new TempoDeJogo(minuto, tempo);
    }

    @Override
    public int compareTo(TempoDeJogo o) {
        if (this.tempo.equals(o.tempo)) {
            return this.minuto - o.minuto;
        }
        return this.tempo.compareTo(o.tempo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        TempoDeJogo that = (TempoDeJogo) o;

        return new EqualsBuilder()
                .append(minuto, that.minuto)
                .append(tempo, that.tempo)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(minuto)
                .append(tempo)
                .toHashCode();
    }

    public static TempoDeJogo primeiroTempo(int minuto) {
        return TempoDeJogo.of(minuto, Tempo.PRIMEIRO);
    }

    public static TempoDeJogo segundoTempo(int minuto) {
        return TempoDeJogo.of(minuto, Tempo.SEGUNDO);
    }
}
