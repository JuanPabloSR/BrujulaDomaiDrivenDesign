package co.com.sofka.Brujula.domain.factura.entities;

import co.com.sofka.Brujula.domain.factura.values.CantidadCupos;
import co.com.sofka.Brujula.domain.factura.values.DetalleId;
import co.com.sofka.Brujula.domain.generics.values.Deporte;
import co.com.sofka.domain.generic.Entity;

public class Detalle extends Entity<DetalleId> {
    private DetalleId detalleId;
    private Deporte deporte;
    private CantidadCupos cantidadCupos;

    public Detalle(DetalleId entityId, Deporte deporte, CantidadCupos cantidadCupos) {
        super(entityId);
        this.detalleId = detalleId;
        this.deporte = deporte;
        this.cantidadCupos = cantidadCupos;
    }

    public void actualizarCantidadCupos(CantidadCupos cantidadCupos) {
        this.cantidadCupos = cantidadCupos;
    }

    public DetalleId DetalleId() {
        return detalleId;
    }

    public Deporte Deporte() {
        return deporte;
    }

    public CantidadCupos CantidadCupos() {
        return cantidadCupos;
    }
}
