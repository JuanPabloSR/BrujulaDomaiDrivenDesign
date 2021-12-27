package co.com.sofka.Brujula.domain.sucursalBrujula.entities;

import co.com.sofka.Brujula.domain.generics.values.Deporte;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.*;
import co.com.sofka.domain.generic.Entity;

public class Actividad extends Entity<ActividadId> {
    private ActividadId actividadId;
    private SucursalBrujulaId sucursalBrujulaId;
    private Deporte deporte;
    private ValorPorPersona valorPorPersona;
    private RangoDePeligro rangoDePeligro;
    private EdadMinima edadMinima;

    public Actividad(ActividadId entityId, SucursalBrujulaId sucursalBrujulaId, Deporte deporte, ValorPorPersona valorPorPersona, RangoDePeligro rangoDePeligro, EdadMinima edadMinima) {
        super(entityId);
        this.actividadId = actividadId;
        this.sucursalBrujulaId = sucursalBrujulaId;
        this.deporte = deporte;
        this.valorPorPersona = valorPorPersona;
        this.rangoDePeligro = rangoDePeligro;
        this.edadMinima = edadMinima;
    }

    public void actualizarDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public void actualizarValorPorPersona(ValorPorPersona valorPorPersona) {
        this.valorPorPersona = valorPorPersona;
    }

    public void actualizarRangoDePeligro(RangoDePeligro rangoDePeligro) {
        this.rangoDePeligro = rangoDePeligro;
    }

    public void actualizarEdadMinima(EdadMinima edadMinima) {
        this.edadMinima = edadMinima;
    }

    public ActividadId ActividadId() {
        return actividadId;
    }

    public Deporte Deporte() {
        return deporte;
    }

    public ValorPorPersona ValorPorPersona() {
        return valorPorPersona;
    }

    public RangoDePeligro RangoDePeligro() {
        return rangoDePeligro;
    }

    public EdadMinima EdadMinima() {
        return edadMinima;
    }
}
