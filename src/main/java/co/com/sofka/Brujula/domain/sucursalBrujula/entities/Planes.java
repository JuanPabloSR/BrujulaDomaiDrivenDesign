package co.com.sofka.Brujula.domain.sucursalBrujula.entities;

import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.*;
import co.com.sofka.domain.generic.Entity;

public class Planes extends Entity<ActividadId> {
    private SucursalBrujulaId sucursalBrujulaId;
    private PlanesId planesId;
    private NombrePlan nombrePlan;
    private ValorPlan valorPlan;
    private CuposMaximos cuposMaximos;

    public Planes(ActividadId entityId, SucursalBrujulaId sucursalBrujulaId, PlanesId planesId, NombrePlan nombrePlan, ValorPlan valorPlan, CuposMaximos cuposMaximos) {
        super(entityId);
        this.sucursalBrujulaId = sucursalBrujulaId;
        this.planesId = planesId;
        this.nombrePlan = nombrePlan;
        this.valorPlan = valorPlan;
        this.cuposMaximos = cuposMaximos;
    }
    public void actualizarNombrePlan(NombrePlan nombrePlan) {
        this.nombrePlan = nombrePlan;
    }
    public void actualizarValorPlan(ValorPlan valorPlan) {
        this.valorPlan = valorPlan;
    }
    public void actualizarCuposMaximos(CuposMaximos cuposMaximos) {
        this.cuposMaximos = cuposMaximos;
    }

    public SucursalBrujulaId SucursalBrujulaId() {
        return sucursalBrujulaId;
    }

    public PlanesId PlanesId() {
        return planesId;
    }

    public NombrePlan NombrePlan() {
        return nombrePlan;
    }

    public ValorPlan ValorPlan() {
        return valorPlan;
    }

    public CuposMaximos CuposMaximos() {
        return cuposMaximos;
    }
}
