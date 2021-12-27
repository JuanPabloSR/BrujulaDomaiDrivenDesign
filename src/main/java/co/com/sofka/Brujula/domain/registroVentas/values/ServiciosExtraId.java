package co.com.sofka.Brujula.domain.registroVentas.values;

import co.com.sofka.domain.generic.Identity;

public class ServiciosExtraId extends Identity {
    public ServiciosExtraId() {
    }

    public ServiciosExtraId(String Id) {
        super(Id);
    }

    public static ServiciosExtraId of(String Id) {
        return new ServiciosExtraId(Id);
    }
}
