package co.com.sofka.Brujula.domain.sucursalBrujula.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class RangoDePeligro implements ValueObject<String> {
    private final String value;

    public RangoDePeligro(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("El Rango de peligro no puede estar vació");
        }
        if (this.value.length() <= 3) {
            throw new IllegalArgumentException("El Rango de peligro debe tener minimo tres letras");
        }
        if (this.value.length() >= 100) {
            throw new IllegalArgumentException("El Rango de peligro debe tener menos de 100 letras");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RangoDePeligro deporte = (RangoDePeligro) o;
        return Objects.equals(value, deporte.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
