package co.com.sofka.Brujula.domain.registroVentas.events;

import co.com.sofka.Brujula.domain.factura.values.CostoFinal;
import co.com.sofka.Brujula.domain.registroVentas.values.ValorTotal;
import co.com.sofka.domain.generic.DomainEvent;

public class ValorTotalCalculado extends DomainEvent {
    private final ValorTotal valorTotal;

    public ValorTotalCalculado(ValorTotal valorTotal) {
        super("sucursalbrujula.sucursal.valotTotalCalculado");
        this.valorTotal = valorTotal;
    }

    public ValorTotal getValorTotal() {
        return valorTotal;
    }
}
