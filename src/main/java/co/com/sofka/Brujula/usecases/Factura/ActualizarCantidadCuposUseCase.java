package co.com.sofka.Brujula.usecases.Factura;

import co.com.sofka.Brujula.domain.factura.Factura;
import co.com.sofka.Brujula.domain.factura.commands.ActualizarCantidadCupos;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarCantidadCuposUseCase extends UseCase<RequestCommand<ActualizarCantidadCupos>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarCantidadCupos> actualizarCantidadCuposRequestCommand) {
        var command = actualizarCantidadCuposRequestCommand.getCommand();
        var factura = Factura.from(command.getFacturaId(), retrieveEvents(command.getEntityId().value()));
        factura.actualizarCantidadCupos(command.getEntityId(), command.getCantidadCupos());
        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
