package co.com.sofka.Brujula.domain.sucursalBrujula.commands;

import co.com.sofka.Brujula.domain.sucursalBrujula.values.PlanId;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.ValorPlan;
import co.com.sofka.domain.generic.Command;

public class ActualizarValorPlan extends Command {
    private final SucursalBrujulaId sucursalBrujulaId;
    private final PlanId planId;
    private final ValorPlan valorPlan;

    public ActualizarValorPlan(SucursalBrujulaId sucursalBrujulaId, PlanId planId, ValorPlan valorPlan) {
        this.sucursalBrujulaId = sucursalBrujulaId;
        this.planId = planId;
        this.valorPlan = valorPlan;
    }

    public SucursalBrujulaId getSucursalBrujulaId() {
        return sucursalBrujulaId;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public ValorPlan getValorPlan() {
        return valorPlan;
    }
}
