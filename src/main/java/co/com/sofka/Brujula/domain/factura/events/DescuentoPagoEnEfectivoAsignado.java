package co.com.sofka.Brujula.domain.factura.events;

import co.com.sofka.domain.generic.DomainEvent;

public class DescuentoPagoEnEfectivoAsignado extends DomainEvent {
    private final Double descuento;

    public DescuentoPagoEnEfectivoAsignado(Double descuento) {
        super("sucursalbrujula.sucursal.descuentoPagoEnEfectivoAsignado");
        this.descuento = descuento;
    }

    public Double getDescuento() {
        return descuento;
    }
}
