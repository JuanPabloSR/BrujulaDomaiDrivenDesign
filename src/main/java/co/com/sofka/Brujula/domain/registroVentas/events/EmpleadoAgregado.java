package co.com.sofka.Brujula.domain.registroVentas.events;

import co.com.sofka.Brujula.domain.factura.values.ClienteId;
import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Edad;
import co.com.sofka.Brujula.domain.generics.values.Email;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.Brujula.domain.registroVentas.values.Cargo;
import co.com.sofka.Brujula.domain.registroVentas.values.EmpleadoId;
import co.com.sofka.domain.generic.DomainEvent;

public class EmpleadoAgregado extends DomainEvent {
    private final EmpleadoId empleadoId;
    private final Nombre nombre;
    private final Celular celular;
    private final Cargo cargo;

    public EmpleadoAgregado(EmpleadoId empleadoId, Nombre nombre, Celular celular, Cargo cargo) {
        super("sucursalbrujula.sucursal.empleadoAgregado");
        this.empleadoId = empleadoId;
        this.nombre = nombre;
        this.celular = celular;
        this.cargo = cargo;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
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
