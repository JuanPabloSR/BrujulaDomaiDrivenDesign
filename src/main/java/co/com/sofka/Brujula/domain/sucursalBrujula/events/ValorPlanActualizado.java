package co.com.sofka.Brujula.domain.sucursalBrujula.events;

import co.com.sofka.Brujula.domain.sucursalBrujula.values.PlanId;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.ValorPlan;
import co.com.sofka.domain.generic.DomainEvent;


public class ValorPlanActualizado extends DomainEvent {
    private final PlanId planId;
    private final ValorPlan valorPlan;

    public ValorPlanActualizado(PlanId planId, ValorPlan valorPlan) {
        super("sucursalbrujula.sucursal.valorPlanActualizado");
        this.planId = planId;
        this.valorPlan = valorPlan;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public ValorPlan getValorPlan() {
        return valorPlan;
    }
}

