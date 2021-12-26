package co.com.sofka.Brujula.domain.sucursalBrujula.values;

import co.com.sofka.domain.generic.Identity;

public class PlanesId extends Identity {
    public PlanesId() {
    }

    public PlanesId(String id) {
        super(id);
    }

    public static PlanesId of(String id) {
        return new PlanesId(id);
    }
}
