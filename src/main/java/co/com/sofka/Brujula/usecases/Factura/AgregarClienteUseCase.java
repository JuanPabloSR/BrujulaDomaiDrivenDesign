package co.com.sofka.Brujula.usecases.Factura;

import co.com.sofka.Brujula.domain.factura.Factura;
import co.com.sofka.Brujula.domain.factura.commands.AgregarCliente;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarClienteUseCase extends UseCase<RequestCommand<AgregarCliente>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarCliente> agregarClienteRequestCommand) {
        var command = agregarClienteRequestCommand.getCommand();
        var factura = Factura.from(command.getFacturaId(), retrieveEvents(command.getClienteId().value()));
        factura.agregarCliente(command.getClienteId(), command.getNombre(), command.getEdad(), command.getCelular(),  command.getEmail());
        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}