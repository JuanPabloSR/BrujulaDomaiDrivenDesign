package co.com.sofka.Brujula.usecases.Factura;

import co.com.sofka.Brujula.domain.factura.Factura;
import co.com.sofka.Brujula.domain.factura.commands.AgregarVendedor;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarVendedorUseCase extends UseCase<RequestCommand<AgregarVendedor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarVendedor> vendedorAgregadoRequestCommand) {
        var command = vendedorAgregadoRequestCommand.getCommand();
        var factura = Factura.from(command.getFacturaId(), retrieveEvents(command.getVendedorId().value()));
        factura.agregarVendedor(command.getVendedorId(), command.getSucursalBrujulaId(), command.getNombre(), command.getEdad(), command.getCelular());
        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
