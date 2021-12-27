package co.com.sofka.Brujula.domain.sucursalBrujula.events;

import co.com.sofka.Brujula.domain.sucursalBrujula.values.CuposMaximos;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.NombrePlan;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.PlanesId;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.ValorPlan;
import co.com.sofka.domain.generic.DomainEvent;

public class PlanAgregado extends DomainEvent {
    private final PlanesId planesId;
    private final NombrePlan nombrePlan;
    private final ValorPlan valorPlan;
    private final CuposMaximos cuposMaximos;

    public PlanAgregado(String type, PlanesId planesId, NombrePlan nombrePlan, ValorPlan valorPlan, CuposMaximos cuposMaximos) {
        super("sucursalbrujula.sucursal.planAgregado");
        this.planesId = planesId;
        this.nombrePlan = nombrePlan;
        this.valorPlan = valorPlan;
        this.cuposMaximos = cuposMaximos;
    }

    public PlanesId getPlanesId() {
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
