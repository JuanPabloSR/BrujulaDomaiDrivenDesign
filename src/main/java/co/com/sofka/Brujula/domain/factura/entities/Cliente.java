package co.com.sofka.Brujula.domain.factura.entities;

import co.com.sofka.Brujula.domain.factura.values.ClienteId;
import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Edad;
import co.com.sofka.Brujula.domain.generics.values.Email;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.domain.generic.Entity;

public class Cliente extends Entity<ClienteId> {
    private ClienteId clienteId;
    private Nombre nombre;
    private Edad edad;
    private Celular celular;
    private Email email;

    public Cliente(ClienteId entityId, Nombre nombre, Edad edad, Celular celular, Email email) {
        super(entityId);
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.edad = edad;
        this.celular = celular;
        this.email = email;
    }


    public void actualizarNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public void actualizarEdad(Edad edad) {
        this.edad = edad;
    }

    public void actualizarCelular(Celular celular) {
        this.celular = celular;
    }
    public void actualizarEmail(Email email) {
        this.email = email;
    }

    public ClienteId clienteId() {
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
