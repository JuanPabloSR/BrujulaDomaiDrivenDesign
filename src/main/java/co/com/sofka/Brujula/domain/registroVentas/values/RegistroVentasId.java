package co.com.sofka.Brujula.domain.registroVentas.values;

import co.com.sofka.domain.generic.Identity;

public class RegistroVentasId extends Identity {
    public RegistroVentasId() {
    }

    public RegistroVentasId(String Id) {
        super(Id);
    }

    public static RegistroVentasId of(String Id) {
        return new RegistroVentasId(Id);
    }
}
