package co.com.sofka.Brujula.domain.factura.events;

import co.com.sofka.Brujula.domain.factura.values.CantidadCupos;
import co.com.sofka.Brujula.domain.factura.values.DetalleId;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class CantidadCuposActualizado extends DomainEvent {
    private final DetalleId detalleId;
    private final CantidadCupos cantidadCupos;

    public CantidadCuposActualizado(DetalleId detalleId, CantidadCupos cantidadCupos) {
        super("sucursalbrujula.sucursal.catidadCuposActualizada");
        this.detalleId = detalleId;
        this.cantidadCupos = cantidadCupos;
    }

    public DetalleId getDetalleId() {
        return detalleId;
    }

    public CantidadCupos getCantidadCupos() {
        return cantidadCupos;
    }
}
