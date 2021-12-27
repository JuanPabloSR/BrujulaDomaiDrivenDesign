package co.com.sofka.Brujula.domain.registroVentas.values;

import co.com.sofka.domain.generic.Identity;

public class EmpleadoId extends Identity {
    public EmpleadoId() {
    }

    public EmpleadoId(String Id) {
        super(Id);
    }

    public static EmpleadoId of(String Id) {
        return new EmpleadoId(Id);
    }
}
