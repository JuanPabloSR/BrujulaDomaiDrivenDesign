package co.com.sofka.Brujula.usecases.Factura;

import co.com.sofka.Brujula.domain.factura.Factura;
import co.com.sofka.Brujula.domain.factura.commands.CrearFactura;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearFacturaUseCase extends UseCase<RequestCommand<CrearFactura>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearFactura> crearFacturaRequestCommand) {
        var command= crearFacturaRequestCommand.getCommand();

        var factura = new Factura(
                command.getEntityId(),
                command.getFecha(),
                command.getMetodoPago()
        );
        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
