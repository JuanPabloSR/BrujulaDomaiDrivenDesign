package co.com.sofka.Brujula.usecases.SucursalBrujula;

import co.com.sofka.Brujula.domain.sucursalBrujula.SucursalBrujula;
import co.com.sofka.Brujula.domain.sucursalBrujula.commands.ActualizarGuia;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarGuiaUseCase extends UseCase<RequestCommand<ActualizarGuia>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarGuia> actualizarGuiaRequestCommand) {
        var command = actualizarGuiaRequestCommand.getCommand();
        var sucursal = SucursalBrujula.from(command.getSucursalBrujulaId(), retrieveEvents(command.getGuiaId().value()));
        sucursal.actualizarGuia(
                command.getGuiaId(),
                command.getSucursalBrujulaId(),
                command.getNombre(),
                command.getCelular(),
                command.getDeportePrincipal()
        );
        emit().onResponse(new ResponseEvents(sucursal.getUncommittedChanges()));
    }
}
