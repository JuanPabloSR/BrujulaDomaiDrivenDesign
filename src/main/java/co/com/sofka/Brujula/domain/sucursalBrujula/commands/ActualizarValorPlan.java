package co.com.sofka.Brujula.domain.sucursalBrujula.commands;

import co.com.sofka.Brujula.domain.sucursalBrujula.values.PlanesId;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.ValorPlan;
import co.com.sofka.domain.generic.Command;

public class ActualizarValorPlan extends Command {
    private final SucursalBrujulaId sucursalBrujulaId;
    private final PlanesId planesId;
    private final ValorPlan valorPlan;

    public ActualizarValorPlan(SucursalBrujulaId sucursalBrujulaId, PlanesId planesId, ValorPlan valorPlan) {
        this.sucursalBrujulaId = sucursalBrujulaId;
        this.planesId = planesId;
        this.valorPlan = valorPlan;
    }

    public SucursalBrujulaId getSucursalBrujulaId() {
        return sucursalBrujulaId;
    }

    public PlanesId getPlanesId() {
        return planesId;
    }

    public ValorPlan getValorPlan() {
        return valorPlan;
    }
}
