package co.com.sofka.Brujula.domain.sucursalBrujula.commands;

import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.domain.generic.Command;

public class AgregarFactura extends Command {
    private final SucursalBrujulaId sucursalBrujulaId;
    private final FacturaId facturaId;

    public AgregarFactura(SucursalBrujulaId sucursalBrujulaId, FacturaId facturaId) {
        this.sucursalBrujulaId = sucursalBrujulaId;
        this.facturaId = facturaId;
    }

    public SucursalBrujulaId getSucursalBrujulaId() {
        return sucursalBrujulaId;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }
}
