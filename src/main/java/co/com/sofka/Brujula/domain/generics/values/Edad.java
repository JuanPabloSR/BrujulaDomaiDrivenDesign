package co.com.sofka.Brujula.domain.generics.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Edad implements ValueObject<String> {
    private final String value;

    public Edad(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("La edad no puede estar vacia");
        }
        if (this.value.length() > 3) {
            throw new IllegalArgumentException("La edad no puede tener mas de 3 digitos");
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
        Edad that = (Edad) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
