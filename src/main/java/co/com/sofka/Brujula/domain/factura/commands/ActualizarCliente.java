package co.com.sofka.Brujula.domain.factura.commands;

import co.com.sofka.Brujula.domain.factura.values.ClienteId;
import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Edad;
import co.com.sofka.Brujula.domain.generics.values.Email;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class ActualizarCliente extends Command {


    private final FacturaId facturaId;
    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Edad edad;
    private final Celular celular;
    private final Email email;

    public ActualizarCliente(FacturaId facturaId, ClienteId clienteId, Nombre nombre, Edad edad, Celular celular, Email email) {
        this.facturaId = facturaId;
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.edad = edad;
        this.celular = celular;
        this.email = email;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public ClienteId getClienteId() {
        return clienteId;
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
