package co.com.sofka.Brujula.domain.registroVentas.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ValorTotal implements ValueObject<Double> {
    private final Double value;

    public ValorTotal(Double value) {
        this.value = Objects.requireNonNull(value);
        if (this.value <= 0) {
            throw new IllegalArgumentException("El valor total no puede ser menor a cero");
        }
    }

    @Override
    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValorTotal that = (ValorTotal) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
