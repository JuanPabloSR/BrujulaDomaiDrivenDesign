package co.com.sofka.Brujula.domain.factura.commands;

import co.com.sofka.Brujula.domain.factura.values.CostoFinal;
import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.domain.generic.Command;

public class CalcularCostoFinal extends Command {
    private final FacturaId facturaId;
    private final CostoFinal costoFinal;

    public CalcularCostoFinal(FacturaId facturaId, CostoFinal costoFinal) {
        this.facturaId = facturaId;
        this.costoFinal = costoFinal;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public CostoFinal getCostoFinal() {
        return costoFinal;
    }
}
