package co.com.sofka.Brujula.domain.registroVentas.events;

import co.com.sofka.Brujula.domain.registroVentas.values.Servicio;
import co.com.sofka.Brujula.domain.registroVentas.values.ServiciosExtraId;
import co.com.sofka.Brujula.domain.registroVentas.values.ValorServicio;
import co.com.sofka.domain.generic.DomainEvent;

public class ServiciosExtrasActualizados extends DomainEvent {
    private final Servicio servicio;
    private final ValorServicio valorServicio;

    public ServiciosExtrasActualizados(Servicio servicio, ValorServicio valorServicio) {
        super("sucursalbrujula.sucursal.serviciosExtrasActualizados");
        this.servicio = servicio;
        this.valorServicio = valorServicio;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public ValorServicio getValorServicio() {
        return valorServicio;
    }
}
