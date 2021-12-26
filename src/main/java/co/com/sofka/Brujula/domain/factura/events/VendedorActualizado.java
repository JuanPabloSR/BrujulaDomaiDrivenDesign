package co.com.sofka.Brujula.domain.factura.events;

import co.com.sofka.Brujula.domain.factura.values.VendedorId;
import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Edad;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.domain.generic.DomainEvent;

public class VendedorActualizado extends DomainEvent {
    private final SucursalBrujulaId sucursalBrujulaId;
    private final VendedorId entityId;
    private final Nombre nombre;
    private final Edad edad;
    private final Celular celular;

    public VendedorActualizado(SucursalBrujulaId sucursalBrujulaId, VendedorId entityId, Nombre nombre, Edad edad, Celular celular) {
        super("sucursalbrujula.sucursal.vendedorAgregado");
        this.sucursalBrujulaId = sucursalBrujulaId;
        this.entityId = entityId;
        this.nombre = nombre;
        this.edad = edad;
        this.celular = celular;
    }

    public SucursalBrujulaId getSucursalBrujulaId() {
        return sucursalBrujulaId;
    }

    public VendedorId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Edad getEdad() {
        return edad;
    }

    public Celular getCelular() {
        return celular;
    }
}
