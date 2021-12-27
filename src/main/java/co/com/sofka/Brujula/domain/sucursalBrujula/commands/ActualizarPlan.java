package co.com.sofka.Brujula.domain.sucursalBrujula.commands;

import co.com.sofka.Brujula.domain.sucursalBrujula.values.*;
import co.com.sofka.domain.generic.Command;

public class ActualizarPlan extends Command {
    private final PlanId planesId;
    private final NombrePlan nombrePlan;
    private final ValorPlan valorPlan;
    private final CuposMaximos cuposMaximos;

    public ActualizarPlan(PlanId planesId, NombrePlan nombrePlan, ValorPlan valorPlan, CuposMaximos cuposMaximos) {
        this.planesId = planesId;
        this.nombrePlan = nombrePlan;
        this.valorPlan = valorPlan;
        this.cuposMaximos = cuposMaximos;
    }

    public PlanId getPlanesId() {
        return planesId;
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
