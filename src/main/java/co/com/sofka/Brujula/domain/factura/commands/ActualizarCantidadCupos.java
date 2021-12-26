package co.com.sofka.Brujula.domain.factura.commands;

import co.com.sofka.Brujula.domain.factura.values.CantidadCupos;
import co.com.sofka.Brujula.domain.factura.values.DetalleId;
import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarCantidadCupos extends Command {
    private final FacturaId facturaId;
    private final DetalleId entityId;
    private final CantidadCupos cantidadCupos;

    public ActualizarCantidadCupos(FacturaId facturaId, DetalleId entityId, CantidadCupos cantidadCupos) {
        this.facturaId = facturaId;
        this.entityId = entityId;
        this.cantidadCupos = cantidadCupos;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public DetalleId getEntityId() {
        return entityId;
    }

    public CantidadCupos getCantidadCupos() {
        return cantidadCupos;
    }
}
