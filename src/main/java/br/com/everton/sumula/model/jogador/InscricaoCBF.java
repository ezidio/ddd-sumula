package br.com.everton.sumula.model.jogador;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * Definição de inscrição da CBF
 */
public class InscricaoCBF implements Serializable {

    private Long value;

    private InscricaoCBF(Long value) {
        this.value = Validate.notNull(value, "O valor da inscricao é obrigatório");
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public static InscricaoCBF of(Integer value) {
        if (value == null) return null;
        return new InscricaoCBF(value.longValue());
    }

    public static InscricaoCBF of(Long value) {
        if (value == null) return null;
        return new InscricaoCBF(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        InscricaoCBF that = (InscricaoCBF) o;

        return new EqualsBuilder()
                .append(value, that.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(value)
                .toHashCode();
    }
}
