package br.com.everton.sumula.infrastructure.types;

import br.com.everton.sumula.model.jogador.InscricaoCBF;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * User type para desserializar o tipo {@link InscricaoCBF}
 */
public class InscricaoCBFType implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[] {Types.INTEGER};
    }

    @Override
    public Class returnedClass() {
        return InscricaoCBF.class;
    }

    @Override
    public boolean equals(Object o, Object o1) throws HibernateException {
        return o.equals(o1);
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return o.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
        return InscricaoCBF.of(rs.getLong(names[0]));
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, Types.CHAR);
        } else {
            st.setLong(index, ((InscricaoCBF) value).getValue());
        }
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        return o;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        return (Serializable) o;
    }

    @Override
    public Object assemble(Serializable cached, Object o) throws HibernateException {
        return cached;
    }

    @Override
    public Object replace(Object o, Object target, Object owner) throws HibernateException {
        return o;
    }
}
