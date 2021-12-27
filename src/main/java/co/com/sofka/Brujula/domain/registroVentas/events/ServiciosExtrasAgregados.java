package co.com.sofka.Brujula.domain.registroVentas.events;

import co.com.sofka.Brujula.domain.factura.values.VendedorId;
import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Edad;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.Brujula.domain.registroVentas.values.Servicio;
import co.com.sofka.Brujula.domain.registroVentas.values.ServiciosExtraId;
import co.com.sofka.Brujula.domain.registroVentas.values.ValorServicio;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.domain.generic.DomainEvent;

public class ServiciosExtrasAgregados extends DomainEvent {
    private final ServiciosExtraId serviciosExtraId;
    private final Servicio servicio;
    private final ValorServicio valorServicio;

    public ServiciosExtrasAgregados(ServiciosExtraId serviciosExtraId, Servicio servicio, ValorServicio valorServicio) {
        super("sucursalbrujula.sucursal.serviciosExtrasAgregados");
        this.serviciosExtraId = serviciosExtraId;
        this.servicio = servicio;
        this.valorServicio = valorServicio;
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
