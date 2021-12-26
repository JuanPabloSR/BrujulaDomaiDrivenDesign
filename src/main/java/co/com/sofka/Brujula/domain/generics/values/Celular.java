package co.com.sofka.Brujula.domain.generics.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Celular implements ValueObject<String> {
    private final String value;

    public Celular(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("El numero de celular no puede estar vació");
        }
        if (this.value.length() != 10) {
            throw new IllegalArgumentException("El numero de celular debe ser de 10 digitos");
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
        Celular that = (Celular) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
