package co.com.sofka.Brujula.domain.sucursalBrujula.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombrePlan implements ValueObject<String> {
    private final String value;

    public NombrePlan(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("el Nombre del plan no puede estar vacio");
        }
        if (this.value.length() <= 3) {
            throw new IllegalArgumentException("el  Nombre del plan debe tener minimo tres letras");
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
        NombrePlan NombrePlan = (NombrePlan) o;
        return Objects.equals(value, NombrePlan.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
