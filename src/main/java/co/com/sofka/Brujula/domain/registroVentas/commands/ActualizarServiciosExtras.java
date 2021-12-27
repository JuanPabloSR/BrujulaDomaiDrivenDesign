package co.com.sofka.Brujula.domain.registroVentas.commands;

import co.com.sofka.Brujula.domain.registroVentas.values.Servicio;
import co.com.sofka.Brujula.domain.registroVentas.values.ServiciosExtraId;
import co.com.sofka.Brujula.domain.registroVentas.values.ValorServicio;
import co.com.sofka.Brujula.domain.registroVentas.values.VentaId;
import co.com.sofka.domain.generic.Command;


public class ActualizarServiciosExtras extends Command {

    private final VentaId ventaId;
    private final ServiciosExtraId serviciosExtraId;
    private final Servicio servicio;
    private final ValorServicio valorServicio;

    public ActualizarServiciosExtras(VentaId ventaId, ServiciosExtraId serviciosExtraId, Servicio servicio, ValorServicio valorServicio) {
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
