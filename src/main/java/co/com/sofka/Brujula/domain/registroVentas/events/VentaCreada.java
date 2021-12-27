package co.com.sofka.Brujula.domain.registroVentas.events;

import co.com.sofka.Brujula.domain.factura.values.MetodoPago;
import co.com.sofka.Brujula.domain.generics.values.Fecha;
import co.com.sofka.Brujula.domain.registroVentas.values.ValorTotal;
import co.com.sofka.domain.generic.DomainEvent;

public class VentaCreada extends DomainEvent {
    private final Fecha fecha;
    private final ValorTotal valorTotal;

    public VentaCreada(Fecha fecha, ValorTotal valorTotal) {
        super("sucursalbrujula.sucursal.ventaCreada");
        this.fecha = fecha;
        this.valorTotal = valorTotal;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public ValorTotal getValorTotal() {
        return valorTotal;
    }
}
