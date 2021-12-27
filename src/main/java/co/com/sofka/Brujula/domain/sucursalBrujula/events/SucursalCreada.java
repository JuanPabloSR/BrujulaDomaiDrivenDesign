package co.com.sofka.Brujula.domain.sucursalBrujula.events;

import co.com.sofka.Brujula.domain.sucursalBrujula.values.NombreSucursal;
import co.com.sofka.domain.generic.DomainEvent;

public class SucursalCreada extends DomainEvent {
    private final NombreSucursal nombreSucursal;

    public SucursalCreada(NombreSucursal nombreSucursal) {
        super("sucursalbrujula.sucursal.sucursalCreada");
        this.nombreSucursal = nombreSucursal;
    }

    public NombreSucursal getNombreSucursal() {
        return nombreSucursal;
    }
}
