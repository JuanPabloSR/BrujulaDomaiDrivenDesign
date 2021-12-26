package co.com.sofka.Brujula.usecases.Factura;

import co.com.sofka.Brujula.domain.factura.Factura;
import co.com.sofka.Brujula.domain.factura.commands.ActualizarCliente;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarClienteUseCase extends UseCase<RequestCommand<ActualizarCliente>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarCliente> actualizarClienteRequestCommand) {
        var command = actualizarClienteRequestCommand.getCommand();
        var factura = Factura.from(command.getFacturaId(), retrieveEvents(command.getFacturaId().value()));
        factura.ActualizarCliente(command.getNombre(), command.getEdad(),command.getCelular(), command.getEmail());
        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
