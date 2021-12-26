package co.com.sofka.Brujula.domain.factura.events;

import co.com.sofka.Brujula.domain.factura.values.CantidadCupos;
import co.com.sofka.Brujula.domain.factura.values.DetalleId;
import co.com.sofka.Brujula.domain.generics.values.Deporte;
import co.com.sofka.domain.generic.DomainEvent;

public class DetalleAgregado extends DomainEvent {
    private final DetalleId entityId;
    private final Deporte deporte;
    private final CantidadCupos cantidadCupos;

    public DetalleAgregado(DetalleId entityId, Deporte deporte, CantidadCupos cantidadCupos) {
        super("sucursalbrujula.sucursal.detalleAgregado");
        this.entityId = entityId;
        this.deporte = deporte;
        this.cantidadCupos = cantidadCupos;
    }

    public DetalleId getEntityId() {
        return entityId;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public CantidadCupos getCantidadCupos() {
        return cantidadCupos;
    }
}
