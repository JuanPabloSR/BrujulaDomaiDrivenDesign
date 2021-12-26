package co.com.sofka.Brujula.domain.factura.events;

import co.com.sofka.Brujula.domain.factura.values.ClienteId;
import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Edad;
import co.com.sofka.Brujula.domain.generics.values.Email;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteActualizado extends DomainEvent {

    private final Nombre nombre;
    private final Edad edad;
    private final Celular celular;
    private final Email email;

    public ClienteActualizado(Nombre nombre, Edad edad, Celular celular, Email email) {
        super("sucursalbrujula.sucursal.clienteActualizado");
        this.nombre = nombre;
        this.edad = edad;
        this.celular = celular;
        this.email = email;
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

    public Email getEmail() {
        return email;
    }
}
