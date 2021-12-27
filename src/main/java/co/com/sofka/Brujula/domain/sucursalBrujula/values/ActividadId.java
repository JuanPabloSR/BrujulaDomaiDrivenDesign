package co.com.sofka.Brujula.domain.sucursalBrujula.values;

import co.com.sofka.domain.generic.Identity;

public class ActividadId extends Identity {
    public ActividadId() {
    }

    public ActividadId(String id) {
        super(id);
    }

    public static ActividadId of(String id) {
        return new ActividadId(id);
    }
}
