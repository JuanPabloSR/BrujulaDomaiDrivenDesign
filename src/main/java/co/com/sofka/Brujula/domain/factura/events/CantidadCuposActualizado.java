package co.com.sofka.Brujula.domain.factura.events;

import co.com.sofka.Brujula.domain.factura.values.CantidadCupos;
import co.com.sofka.Brujula.domain.factura.values.DetalleId;
import co.com.sofka.domain.generic.DomainEvent;


public class CantidadCuposActualizado extends DomainEvent {
    private final DetalleId entityId;
    private final CantidadCupos cantidadCupos;

    public CantidadCuposActualizado(DetalleId entityId, CantidadCupos cantidadCupos) {
        super("sucursalbrujula.sucursal.catidadCuposActualizada");
        this.entityId = entityId;
        this.cantidadCupos = cantidadCupos;
    }

    public DetalleId getEntityId() {
        return entityId;
    }

    public CantidadCupos getCantidadCupos() {
        return cantidadCupos;
    }
}