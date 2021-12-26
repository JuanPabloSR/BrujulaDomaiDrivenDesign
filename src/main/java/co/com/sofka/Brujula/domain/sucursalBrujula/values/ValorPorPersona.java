package co.com.sofka.Brujula.domain.sucursalBrujula.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ValorPorPersona implements ValueObject<String> {
    private final String value;

    public ValorPorPersona(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El Valor Por Persona no puede estar vacio");
        }
        if (this.value.length() <3) {
            throw new IllegalArgumentException("El Valor Por Persona debe tener minimo 6 digitos");
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
        ValorPorPersona ValorPorPersona = (ValorPorPersona) o;
        return Objects.equals(value, ValorPorPersona.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
