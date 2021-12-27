package co.com.sofka.Brujula.domain.sucursalBrujula.events;

import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.domain.generic.DomainEvent;

public class FacturaAgregada extends DomainEvent {
    private final FacturaId facturaId;

    public FacturaAgregada(FacturaId facturaId) {
        super("sucursalbrujula.sucursal.facturaAgregada");
        this.facturaId = facturaId;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }
}
