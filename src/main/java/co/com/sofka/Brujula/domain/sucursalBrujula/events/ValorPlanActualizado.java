package co.com.sofka.Brujula.domain.sucursalBrujula.events;

import co.com.sofka.Brujula.domain.sucursalBrujula.values.PlanId;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.ValorPlan;
import co.com.sofka.domain.generic.DomainEvent;


public class ValorPlanActualizado extends DomainEvent {
    private final PlanId planesId;
    private final ValorPlan valorPlan;

    public ValorPlanActualizado(PlanId planesId, ValorPlan valorPlan) {
        super("sucursalbrujula.sucursal.valorPlanActualizado");
        this.planesId = planesId;
        this.valorPlan = valorPlan;
    }

    public PlanId getPlanesId() {
        return planesId;
    }

    public ValorPlan getValorPlan() {
        return valorPlan;
    }
}

