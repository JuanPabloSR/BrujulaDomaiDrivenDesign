package co.com.sofka.Brujula.domain.factura.events;

import co.com.sofka.Brujula.domain.generics.values.Fecha;
import co.com.sofka.Brujula.domain.generics.values.MetodoPago;
import co.com.sofka.domain.generic.DomainEvent;

public class FacturaCreada extends DomainEvent {
    private final Fecha fecha;
    private final MetodoPago metodoPago;

    public FacturaCreada(Fecha fecha, MetodoPago metodoPago) {
        super("sucursalbrujula.sucursal.facturaCreada");
        this.fecha = fecha;
        this.metodoPago = metodoPago;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }
}
