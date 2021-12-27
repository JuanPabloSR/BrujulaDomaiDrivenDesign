package co.com.sofka.Brujula.domain.registroVentas.events;

import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.Brujula.domain.registroVentas.values.Cargo;
import co.com.sofka.Brujula.domain.registroVentas.values.EmpleadoId;
import co.com.sofka.domain.generic.DomainEvent;

public class EmpleadoActualizado extends DomainEvent {
    private final Nombre nombre;
    private final Celular celular;
    private final Cargo cargo;

    public EmpleadoActualizado(Nombre nombre, Celular celular, Cargo cargo) {
        super("sucursalbrujula.sucursal.empleadoActualizado");
        this.nombre = nombre;
        this.celular = celular;
        this.cargo = cargo;
    }


    public Nombre getNombre() {
        return nombre;
    }

    public Celular getCelular() {
        return celular;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
