package co.com.sofka.Brujula.domain.sucursalBrujula.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CuposMaximos implements ValueObject<Integer> {
    private final Integer value;

    public CuposMaximos(Integer value) {
        this.value = Objects.requireNonNull(value);
        if (this.value <= 0) {
            throw new IllegalArgumentException("La cantidad de cupos  Maximos para el deporte no puede ser menor a cero");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuposMaximos that = (CuposMaximos) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
