package br.com.tdc.sumula.tradicional.model;

import org.apache.commons.lang3.Validate;

/**
 * Created by everton on 18/04/17.
 */
public class InscricaoCBF {

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
        return new InscricaoCBF(value.longValue());
    }
}
