package co.com.sofka.Brujula.domain.sucursalBrujula.values;

import co.com.sofka.Brujula.domain.generics.values.Edad;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EdadMinima implements ValueObject<Integer> {
    private final Integer value;

    public EdadMinima(Integer value) {
        this.value = Objects.requireNonNull(value);
        if (this.value >= 5) {
            throw new IllegalArgumentException("La edad minima debe ser igual o mayor a 5 años");
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
        EdadMinima that = (EdadMinima) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
