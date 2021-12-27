package co.com.sofka.Brujula.domain.sucursalBrujula.commands;

import co.com.sofka.Brujula.domain.sucursalBrujula.values.NombreSucursal;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.domain.generic.Command;

public class CrearSucursal extends Command {
    private final SucursalBrujulaId entityId;
    private final NombreSucursal nombreSucursal;

    public CrearSucursal(SucursalBrujulaId entityId, NombreSucursal nombreSucursal) {
        this.entityId = entityId;
        this.nombreSucursal = nombreSucursal;
    }

    public SucursalBrujulaId getEntityId() {
        return entityId;
    }

    public NombreSucursal getNombreSucursal() {
        return nombreSucursal;
    }
}
