package co.com.sofka.Brujula.domain.sucursalBrujula.values;

import co.com.sofka.domain.generic.Identity;

public class SucursalBrujulaId extends Identity {
    public SucursalBrujulaId() {
    }

    public SucursalBrujulaId(String id) {
        super(id);
    }

    public static SucursalBrujulaId of(String id) {
        return new SucursalBrujulaId(id);
    }
}
