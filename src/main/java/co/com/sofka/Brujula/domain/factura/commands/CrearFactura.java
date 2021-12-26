package co.com.sofka.Brujula.domain.factura.commands;

import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.factura.values.MetodoPago;
import co.com.sofka.Brujula.domain.generics.values.Fecha;
import co.com.sofka.domain.generic.Command;

public class CrearFactura extends Command {
    private final FacturaId entityId;
    private final Fecha fecha;
    private final MetodoPago metodoPago;

    public CrearFactura (FacturaId entityId, Fecha fecha, MetodoPago metodoPago) {
        this.entityId = entityId;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
    }

    public FacturaId getEntityId() {
        return entityId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }
}
