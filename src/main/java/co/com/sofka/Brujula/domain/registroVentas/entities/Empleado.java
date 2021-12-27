package co.com.sofka.Brujula.domain.registroVentas.entities;

import co.com.sofka.Brujula.domain.factura.values.VendedorId;
import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Edad;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.Brujula.domain.registroVentas.values.Cargo;
import co.com.sofka.Brujula.domain.registroVentas.values.EmpleadoId;
import co.com.sofka.Brujula.domain.registroVentas.values.VentaId;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.domain.generic.Entity;

public class Empleado extends Entity<EmpleadoId> {
    private VentaId ventaId;
    private EmpleadoId empleadoId;
    private Nombre nombre;
    private Celular celular;
    private Cargo cargo;

    public Empleado(VentaId ventaId, EmpleadoId entityId, Nombre nombre, Celular celular, Cargo cargo) {
        super(entityId);
        this.empleadoId = empleadoId;
        this.nombre = nombre;
        this.celular = celular;
        this.cargo = cargo;
    }

    public void actualizarVentaId(VentaId ventaId) {
        this.ventaId = ventaId;
    }

    public void actualizarNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public void actualizarCelular(Celular celular) {
        this.celular = celular;
    }

    public void actualizarCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public VentaId getVentaId() {
        return ventaId;
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
