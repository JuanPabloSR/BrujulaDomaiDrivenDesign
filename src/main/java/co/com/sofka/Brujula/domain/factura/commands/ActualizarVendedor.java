package co.com.sofka.Brujula.domain.factura.commands;

import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.factura.values.VendedorId;
import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Edad;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarVendedor extends Command {
    private final FacturaId facturaId;
    private final SucursalBrujulaId sucursalBrujulaId;
    private final VendedorId vendedorId;
    private final Nombre nombre;
    private final Edad edad;
    private final Celular celular;

    public ActualizarVendedor(FacturaId facturaId, SucursalBrujulaId sucursalBrujulaId, VendedorId vendedorId, FacturaId id, Nombre nombre, Edad edad, Celular celular) {
        this.facturaId = facturaId;
        this.sucursalBrujulaId = sucursalBrujulaId;
        this.vendedorId = vendedorId;
        this.nombre = nombre;
        this.edad = edad;
        this.celular = celular;

    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public SucursalBrujulaId getSucursalBrujulaId() { return sucursalBrujulaId; }

    public VendedorId getVendedorId() {
        return vendedorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Celular getCelular() {return celular;}

    public Edad getEdad() {
        return edad;
    }
}
