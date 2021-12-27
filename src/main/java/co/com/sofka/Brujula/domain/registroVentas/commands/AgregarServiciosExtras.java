package co.com.sofka.Brujula.domain.registroVentas.commands;

import co.com.sofka.Brujula.domain.registroVentas.values.*;
import co.com.sofka.domain.generic.Command;


public class AgregarServiciosExtras extends Command {

    private final VentaId ventaId;
    private final RegistroVentasId serviciosExtraId;
    private final Servicio servicio;
    private final ValorServicio valorServicio;

    public AgregarServiciosExtras(VentaId ventaId, RegistroVentasId serviciosExtraId, Servicio servicio, ValorServicio valorServicio) {
        this.ventaId = ventaId;
        this.serviciosExtraId = serviciosExtraId;
        this.servicio = servicio;
        this.valorServicio = valorServicio;
    }

    public VentaId getVentaId() {
        return ventaId;
    }

    public RegistroVentasId getServiciosExtraId() {
        return serviciosExtraId;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public ValorServicio getValorServicio() {
        return valorServicio;
    }
}
