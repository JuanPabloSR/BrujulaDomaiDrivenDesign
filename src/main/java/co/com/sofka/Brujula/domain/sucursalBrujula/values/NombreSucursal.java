package co.com.sofka.Brujula.domain.sucursalBrujula.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreSucursal implements ValueObject<String> {
    private final String value;

    public NombreSucursal(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("el Nombre de la Sucursal no puede estar vacio");
        }
        if (this.value.length() <= 3) {
            throw new IllegalArgumentException("el  Nombre de la Sucursal debe tener minimo tres letras");
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
        NombreSucursal NombreSucursal = (NombreSucursal) o;
        return Objects.equals(value, NombreSucursal.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
