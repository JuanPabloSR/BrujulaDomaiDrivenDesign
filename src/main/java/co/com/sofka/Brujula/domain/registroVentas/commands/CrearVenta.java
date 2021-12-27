package co.com.sofka.Brujula.domain.registroVentas.commands;

import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.factura.values.MetodoPago;
import co.com.sofka.Brujula.domain.generics.values.Fecha;
import co.com.sofka.Brujula.domain.registroVentas.values.ValorTotal;
import co.com.sofka.Brujula.domain.registroVentas.values.VentaId;
import co.com.sofka.domain.generic.Command;

public class CrearVenta extends Command {
    private final VentaId entityId;
    private final Fecha fecha;
    private final ValorTotal valorTotal;

    public CrearVenta(VentaId entityId, Fecha fecha, ValorTotal valorTotal) {
        this.entityId = entityId;
        this.fecha = fecha;
        this.valorTotal = valorTotal;
    }

    public VentaId getEntityId() {
        return entityId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public ValorTotal getValorTotal() {
        return valorTotal;
    }
}
