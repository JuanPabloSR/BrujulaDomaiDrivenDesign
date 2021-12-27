package co.com.sofka.Brujula.domain.sucursalBrujula.values;

import co.com.sofka.domain.generic.Identity;

public class PlanId extends Identity {
    public PlanId() {
    }

    public PlanId(String id) {
        super(id);
    }

    public static PlanId of(String id) {
        return new PlanId(id);
    }
}
