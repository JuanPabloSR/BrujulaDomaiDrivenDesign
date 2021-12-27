package co.com.sofka.Brujula.domain.registroVentas.entities;

import co.com.sofka.Brujula.domain.factura.values.CantidadCupos;
import co.com.sofka.Brujula.domain.factura.values.DetalleId;
import co.com.sofka.Brujula.domain.generics.values.Deporte;
import co.com.sofka.Brujula.domain.registroVentas.values.Servicio;
import co.com.sofka.Brujula.domain.registroVentas.values.ServiciosExtraId;
import co.com.sofka.Brujula.domain.registroVentas.values.ValorServicio;
import co.com.sofka.Brujula.domain.registroVentas.values.VentaId;
import co.com.sofka.domain.generic.Entity;

public class ServiciosExtras extends Entity<DetalleId> {
    private  VentaId ventaId;
    private  ServiciosExtraId serviciosExtraId;
    private  Servicio servicio;
    private  ValorServicio valorServicio;

    public ServiciosExtras(DetalleId entityId, VentaId ventaId, ServiciosExtraId serviciosExtraId, Servicio servicio, ValorServicio valorServicio) {
        super(entityId);
        this.ventaId = ventaId;
        this.serviciosExtraId = serviciosExtraId;
        this.servicio = servicio;
        this.valorServicio = valorServicio;
    }

    public void actualizarServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public void actualizarValorServicio (ValorServicio valorServicio) {
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
