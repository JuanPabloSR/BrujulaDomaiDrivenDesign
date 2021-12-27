package co.com.sofka.Brujula.usecases.SucursalBrujula;

import co.com.sofka.Brujula.domain.sucursalBrujula.SucursalBrujula;
import co.com.sofka.Brujula.domain.sucursalBrujula.commands.ActualizarActividad;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarActividadUseCase extends UseCase<RequestCommand<ActualizarActividad>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarActividad> actualizarActividadRequestCommand) {
        var command = actualizarActividadRequestCommand.getCommand();
        var sucursal = SucursalBrujula.from(command.getSucursalBrujulaId(),retrieveEvents(command.getActividadId().value()));
        sucursal.actualizarActividad(command.getActividadId(),command.getSucursalBrujulaId(), command.getDeporte(), command.getValorPorPersona(), command.getRangoDePeligro(), command.getEdadMinima());
        emit().onResponse(new ResponseEvents(sucursal.getUncommittedChanges()));
    }
}
