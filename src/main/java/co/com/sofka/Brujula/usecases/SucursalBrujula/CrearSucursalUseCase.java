package co.com.sofka.Brujula.usecases.SucursalBrujula;

import co.com.sofka.Brujula.domain.sucursalBrujula.SucursalBrujula;
import co.com.sofka.Brujula.domain.sucursalBrujula.commands.CrearSucursal;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearSucursalUseCase extends UseCase<RequestCommand<CrearSucursal>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearSucursal> crearSucursalRequestCommand){
        var command = crearSucursalRequestCommand.getCommand();
        var sucursal = new SucursalBrujula(
                command.getEntityId(),
                command.getNombreSucursal()
        );
        emit().onResponse(new ResponseEvents(sucursal.getUncommittedChanges()));
    }
}
