package co.com.sofka.Brujula.domain.factura.commands;

import co.com.sofka.Brujula.domain.factura.values.CantidadCupos;
import co.com.sofka.Brujula.domain.factura.values.DetalleId;
import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.generics.values.Deporte;
import co.com.sofka.domain.generic.Command;


public class AgregarDetalle extends Command {

    private final FacturaId facturaId;
    private final DetalleId detalleId;
    private final Deporte deporte;
    private final CantidadCupos cantidadCupos;

    public AgregarDetalle(FacturaId facturaId, DetalleId detalleId, Deporte deporte, CantidadCupos cantidadCupos) {
        this.facturaId = facturaId;
        this.detalleId = detalleId;
        this.deporte = deporte;
        this.cantidadCupos = cantidadCupos;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public DetalleId getDetalleId() {
        return detalleId;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public CantidadCupos getCantidadCupos() {
        return cantidadCupos;
    }
}
