package co.com.sofka.Brujula.domain.factura.events;

import co.com.sofka.Brujula.domain.factura.values.CostoFinal;
import co.com.sofka.domain.generic.DomainEvent;

public class CostoFinalCalculado extends DomainEvent {
    private final CostoFinal costoFinal;

    public CostoFinalCalculado(CostoFinal costoFinal) {
        super("sucursalbrujula.sucursal.costoFinalCalculado");
        this.costoFinal = costoFinal;
    }
}
