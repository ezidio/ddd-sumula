/**
 * This file was generated by the Jeddict
 */ 

package br.com.tdc.sumula.tradicional.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author everton
 */

@Entity
public class Time implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Basic
    private String nome;

    public Time(String nome) {
        this.nome = nome;
    }

    protected Time() {
        // construtor vazio para serialização
    }

    public Long getId() {
        return this.id;
    }


    public String getNome() {
        return this.nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        return new EqualsBuilder()
                .append(id, time.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }
}
