package co.com.sofka.Brujula.domain.sucursalBrujula.events;

import co.com.sofka.Brujula.domain.sucursalBrujula.values.PlanesId;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.ValorPlan;
import co.com.sofka.domain.generic.DomainEvent;


public class ValorPlanActualizado extends DomainEvent {
    private final PlanesId planesId;
    private final ValorPlan valorPlan;

    public ValorPlanActualizado(PlanesId planesId, ValorPlan valorPlan) {
        super("sucursalbrujula.sucursal.valorPlanActualizado");
        this.planesId = planesId;
        this.valorPlan = valorPlan;
    }

    public PlanesId getPlanesId() {
        return planesId;
    }

    public ValorPlan getValorPlan() {
        return valorPlan;
    }
}

