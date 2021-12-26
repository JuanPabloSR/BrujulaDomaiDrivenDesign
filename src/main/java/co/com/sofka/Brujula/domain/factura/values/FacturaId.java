package co.com.sofka.Brujula.domain.factura.values;

import co.com.sofka.domain.generic.Identity;

public class FacturaId extends Identity {
    public FacturaId() {
    }

    public FacturaId(String Id) {
        super(Id);
    }

    public static FacturaId of(String Id) {
        return new FacturaId(Id);
    }
}
