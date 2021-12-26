package co.com.sofka.Brujula.domain.factura.values;

import co.com.sofka.domain.generic.Identity;

public class VendedorId extends Identity {
    public VendedorId() {
    }

    public VendedorId(String Id) {
        super(Id);
    }

    public static VendedorId of(String Id) {
        return new VendedorId(Id);
    }
}
