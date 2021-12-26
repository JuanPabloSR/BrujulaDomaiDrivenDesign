package co.com.sofka.Brujula.domain.factura.values;

import co.com.sofka.domain.generic.Identity;

public class DetalleId extends Identity {
    public DetalleId() {
    }

    public DetalleId(String Id) {
        super(Id);
    }

    public static DetalleId of(String Id) {
        return new DetalleId(Id);
    }
}
