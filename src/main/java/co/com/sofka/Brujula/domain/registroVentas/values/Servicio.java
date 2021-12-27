package co.com.sofka.Brujula.domain.registroVentas.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Servicio implements ValueObject<String> {
    private final String value;

    public Servicio(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("El Servicio no puede estar vació");
        }
        if (this.value.length() <= 3) {
            throw new IllegalArgumentException("El Servicio debe tener minimo tres letras");
        }
        if (this.value.length() >= 100) {
            throw new IllegalArgumentException("El Servicio debe tener menos de 100 letras");
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
        Servicio servicio = (Servicio) o;
        return Objects.equals(value, servicio.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
