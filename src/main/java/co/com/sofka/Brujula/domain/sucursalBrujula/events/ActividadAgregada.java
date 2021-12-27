package co.com.sofka.Brujula.domain.sucursalBrujula.events;

import co.com.sofka.Brujula.domain.generics.values.Deporte;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.ActividadId;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.EdadMinima;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.RangoDePeligro;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.domain.generic.DomainEvent;

public class ActividadAgregada extends DomainEvent {
    private final SucursalBrujulaId sucursalBrujulaId;
    private final ActividadId actividadId;
    private final Deporte deporte;
    private final RangoDePeligro rangoDePeligro;
    private final EdadMinima edadMinima;

    public ActividadAgregada(SucursalBrujulaId sucursalBrujulaId, ActividadId actividadId, Deporte deporte, RangoDePeligro rangoDePeligro, EdadMinima edadMinima) {
        super("sucursalbrujula.sucursal.actividadAgregada");
        this.sucursalBrujulaId = sucursalBrujulaId;
        this.actividadId = actividadId;
        this.deporte = deporte;
        this.rangoDePeligro = rangoDePeligro;
        this.edadMinima = edadMinima;
    }

    public SucursalBrujulaId getSucursalBrujulaId() {
        return sucursalBrujulaId;
    }

    public ActividadId getActividadId() {
        return actividadId;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public RangoDePeligro getRangoDePeligro() {
        return rangoDePeligro;
    }

    public EdadMinima getEdadMinima() {
        return edadMinima;
    }
}
