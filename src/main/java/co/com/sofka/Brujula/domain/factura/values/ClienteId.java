package co.com.sofka.Brujula.domain.factura.values;

import co.com.sofka.domain.generic.Identity;

public class ClienteId extends Identity {
    public ClienteId() {
    }

    public ClienteId(String Id) {
        super(Id);
    }

    public static ClienteId of(String Id) {
        return new ClienteId(Id);
    }


}
