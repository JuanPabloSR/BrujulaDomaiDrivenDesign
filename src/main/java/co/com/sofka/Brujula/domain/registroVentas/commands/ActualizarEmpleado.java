package co.com.sofka.Brujula.domain.registroVentas.commands;

import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.factura.values.VendedorId;
import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Edad;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.Brujula.domain.registroVentas.values.Cargo;
import co.com.sofka.Brujula.domain.registroVentas.values.EmpleadoId;
import co.com.sofka.Brujula.domain.registroVentas.values.VentaId;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarEmpleado extends Command {
    private final VentaId ventaId;
    private final EmpleadoId empleadoId;
    private final Nombre nombre;
    private final Celular celular;
    private final Cargo cargo;

    public ActualizarEmpleado(VentaId ventaId, EmpleadoId empleadoId, Nombre nombre, Celular celular, Cargo cargo) {
        this.ventaId = ventaId;
        this.empleadoId = empleadoId;
        this.nombre = nombre;
        this.celular = celular;
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
