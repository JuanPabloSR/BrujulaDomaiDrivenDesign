package co.com.sofka.Brujula.domain.factura.events;

import co.com.sofka.domain.generic.DomainEvent;

public class PromocionAsignada extends DomainEvent {
    private final double promocion;

    public PromocionAsignada(Double promocion) {
        super("sucursalbrujula.sucursal.promocionAsignada");
        this.promocion = promocion;
    }

    public double getPromocion() {
        return promocion;
    }
}
