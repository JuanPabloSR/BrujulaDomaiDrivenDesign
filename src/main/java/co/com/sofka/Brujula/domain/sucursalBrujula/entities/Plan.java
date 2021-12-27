package co.com.sofka.Brujula.domain.sucursalBrujula.entities;

import co.com.sofka.Brujula.domain.sucursalBrujula.values.*;
import co.com.sofka.domain.generic.Entity;

public class Plan extends Entity<PlanId> {
    private PlanId planId;
    private NombrePlan nombrePlan;
    private ValorPlan valorPlan;
    private CuposMaximos cuposMaximos;

    public Plan(PlanId entityId, NombrePlan nombrePlan, ValorPlan valorPlan, CuposMaximos cuposMaximos) {
        super(entityId);
        this.nombrePlan = nombrePlan;
        this.valorPlan = valorPlan;
        this.cuposMaximos = cuposMaximos;
    }
    public void actualizarValorPlan(ValorPlan valorPlan) {
        this.valorPlan = valorPlan;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public NombrePlan getNombrePlan() {
        return nombrePlan;
    }

    public ValorPlan getValorPlan() {
        return valorPlan;
    }

    public CuposMaximos getCuposMaximos() {
        return cuposMaximos;
    }
}
