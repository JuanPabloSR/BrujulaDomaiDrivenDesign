package co.com.sofka.Brujula.domain.sucursalBrujula.commands;

import co.com.sofka.Brujula.domain.generics.values.Deporte;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.*;
import co.com.sofka.domain.generic.Command;

public class AgregarActividad extends Command {
    private final ActividadId actividadId;
    private final SucursalBrujulaId sucursalBrujulaId;
    private final Deporte deporte;
    private final ValorPorPersona valorPorPersona;
    private final RangoDePeligro rangoDePeligro;
    private final EdadMinima edadMinima;

    public AgregarActividad(ActividadId actividadId, SucursalBrujulaId sucursalBrujulaId, Deporte deporte, ValorPorPersona valorPorPersona, RangoDePeligro rangoDePeligro, EdadMinima edadMinima) {
        this.sucursalBrujulaId = sucursalBrujulaId;
        this.actividadId = actividadId;
        this.deporte = deporte;
        this.valorPorPersona = valorPorPersona;
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

    public ValorPorPersona getValorPorPersona() {
        return valorPorPersona;
    }

    public RangoDePeligro getRangoDePeligro() {
        return rangoDePeligro;
    }

    public EdadMinima getEdadMinima() {
        return edadMinima;
    }
}
