package co.com.sofka.Brujula.usecases.SucursalBrujula;

import co.com.sofka.Brujula.domain.sucursalBrujula.SucursalBrujula;
import co.com.sofka.Brujula.domain.sucursalBrujula.commands.AgregarGuia;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarGuiaUseCase extends UseCase<RequestCommand<AgregarGuia>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarGuia> agregarGuiaRequestCommand) {
        var command= agregarGuiaRequestCommand.getCommand();
        var sucursal= SucursalBrujula.from(command.getSucursalBrujulaId(),retrieveEvents(command.getGuiaId().value()));
        sucursal.agregarGuia(command.getGuiaId(), command.getSucursalBrujulaId(), command.getNombre(), command.getCelular(), command.getDeportePrincipal());
        emit().onResponse(new ResponseEvents(sucursal.getUncommittedChanges()));
    }
}