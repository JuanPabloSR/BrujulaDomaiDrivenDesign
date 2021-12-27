package co.com.sofka.Brujula.domain.registroVentas.commands;

import co.com.sofka.Brujula.domain.factura.values.CostoFinal;
import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.registroVentas.values.ValorServicio;
import co.com.sofka.Brujula.domain.registroVentas.values.ValorTotal;
import co.com.sofka.Brujula.domain.registroVentas.values.VentaId;
import co.com.sofka.domain.generic.Command;

public class CalcularValorTotal extends Command {
    private final VentaId ventaId;
    private final ValorTotal valorTotal;

    public CalcularValorTotal(VentaId ventaId, ValorTotal valorTotal) {
        this.ventaId = ventaId;
        this.valorTotal = valorTotal;
    }

    public VentaId getVentaId() {
        return ventaId;
    }

    public ValorTotal getValorTotal() {
        return valorTotal;
    }
}
