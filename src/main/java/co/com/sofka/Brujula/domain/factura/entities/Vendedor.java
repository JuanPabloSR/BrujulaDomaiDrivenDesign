package co.com.sofka.Brujula.domain.factura.entities;

import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.factura.values.VendedorId;
import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Edad;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.domain.generic.Entity;

public class Vendedor extends Entity<VendedorId> {
    private  FacturaId facturaId;
    private  SucursalBrujulaId sucursalBrujulaId;
    private  VendedorId vendedorId;
    private  Nombre nombre;
    private  Edad edad;
    private  Celular celular;

    public Vendedor(VendedorId entityId, FacturaId facturaId, SucursalBrujulaId sucursalBrujulaId, VendedorId vendedorId, Nombre nombre, Edad edad, Celular celular) {
        super(entityId);
        this.facturaId = facturaId;
        this.sucursalBrujulaId = sucursalBrujulaId;
        this.vendedorId = vendedorId;
        this.nombre = nombre;
        this.edad = edad;
        this.celular = celular;
    }

    public void actualizarSucursalBrujulaId(SucursalBrujulaId sucursalBrujulaId) {
        this.sucursalBrujulaId = sucursalBrujulaId;
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

}
