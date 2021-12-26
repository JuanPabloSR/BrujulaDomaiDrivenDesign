package co.com.sofka.Brujula.usecases.Factura;

import co.com.sofka.Brujula.domain.factura.Factura;
import co.com.sofka.Brujula.domain.factura.commands.ActualizarVendedor;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarVendedorUseCase extends UseCase<RequestCommand<ActualizarVendedor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarVendedor> actualizarVendedorRequestCommand) {
        var command = actualizarVendedorRequestCommand.getCommand();
        var factura = Factura.from(command.getFacturaId(), retrieveEvents(command.getVendedorId().value()));
        factura.actualizarVendedor(command.getVendedorId(), command.getSucursalBrujulaId(), command.getNombre(), command.getEdad(), command.getCelular());
        emit().onResponse( new ResponseEvents(factura.getUncommittedChanges()));
    }
}
