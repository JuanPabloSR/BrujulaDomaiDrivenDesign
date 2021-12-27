package co.com.sofka.Brujula.domain.registroVentas.values;

import co.com.sofka.domain.generic.Identity;

public class VentaId extends Identity {
    public VentaId() {
    }

    public VentaId(String Id) {
        super(Id);
    }

    public static VentaId of(String Id) {
        return new VentaId(Id);
    }
}
