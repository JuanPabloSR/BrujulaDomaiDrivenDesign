package co.com.sofka.Brujula.domain.registroVentas.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class SeguroRiesgos implements ValueObject<String> {
    private final String value;

    public SeguroRiesgos(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("El seguro de riesgos no puede estar vació");
        }
        if (this.value.length() <= 3) {
            throw new IllegalArgumentException("El seguro de riesgos debe minimo tres letras");
        }
        if (this.value.length() >= 100) {
            throw new IllegalArgumentException("El seguro de riesgos debe tener menos de 100 letras");
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
        SeguroRiesgos seguroRiesgos = (SeguroRiesgos) o;
        return Objects.equals(value, seguroRiesgos.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
