package co.com.sofka.Brujula.domain.registroVentas.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cedula implements ValueObject<String> {
    private final String value;

    public Cedula(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("El numero de cedula no puede estar vació");
        }
        if (this.value.length() != 10) {
            throw new IllegalArgumentException("El numero de cedula debe ser de 10 digitos");
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
        Cedula that = (Cedula) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
