package co.com.sofka.Brujula.domain.sucursalBrujula.events;

import co.com.sofka.Brujula.domain.sucursalBrujula.values.NombreSucursal;
import co.com.sofka.domain.generic.DomainEvent;

public class SucursalAgregada extends DomainEvent {
    private final NombreSucursal nombreSucursal;

    public SucursalAgregada(NombreSucursal nombreSucursal) {
        super("sucursalbrujula.sucursal.sucursalAgregada");
        this.nombreSucursal = nombreSucursal;
    }

    public NombreSucursal getNombreSucursal() {
        return nombreSucursal;
    }
}
