package co.com.sofka.Brujula.domain.registroVentas.commands;

import co.com.sofka.Brujula.domain.factura.values.CantidadCupos;
import co.com.sofka.Brujula.domain.factura.values.DetalleId;
import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.generics.values.Deporte;
import co.com.sofka.Brujula.domain.registroVentas.values.Servicio;
import co.com.sofka.Brujula.domain.registroVentas.values.ServiciosExtraId;
import co.com.sofka.Brujula.domain.registroVentas.values.ValorServicio;
import co.com.sofka.Brujula.domain.registroVentas.values.VentaId;
import co.com.sofka.domain.generic.Command;


public class AgregarServiciosExtras extends Command {

    private final VentaId ventaId;
    private final ServiciosExtraId serviciosExtraId;
    private final Servicio servicio;
    private final ValorServicio valorServicio;

    public AgregarServiciosExtras(VentaId ventaId, ServiciosExtraId serviciosExtraId, Servicio servicio, ValorServicio valorServicio) {
        this.ventaId = ventaId;
        this.serviciosExtraId = serviciosExtraId;
        this.servicio = servicio;
        this.valorServicio = valorServicio;
    }

    public VentaId getVentaId() {
        return ventaId;
    }

    public ServiciosExtraId getServiciosExtraId() {
        return serviciosExtraId;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public ValorServicio getValorServicio() {
        return valorServicio;
    }
}
