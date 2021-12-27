package co.com.sofka.Brujula.domain.sucursalBrujula.values;

import co.com.sofka.domain.generic.Identity;

public class GuiaId extends Identity {
    public GuiaId() {
    }

    public GuiaId(String id) {
        super(id);
    }

    public static GuiaId of(String id) {
        return new GuiaId(id);
    }
}
