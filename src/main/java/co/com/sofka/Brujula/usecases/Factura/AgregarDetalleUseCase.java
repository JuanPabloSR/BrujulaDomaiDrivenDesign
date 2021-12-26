package co.com.sofka.Brujula.usecases.Factura;

import co.com.sofka.Brujula.domain.factura.Factura;
import co.com.sofka.Brujula.domain.factura.commands.AgregarDetalle;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarDetalleUseCase extends UseCase<RequestCommand<AgregarDetalle>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarDetalle> agregarDetalleRequestCommand) {
        var command = agregarDetalleRequestCommand.getCommand();
        var factura = Factura.from(command.getFacturaId(), retrieveEvents(command.getDetalleId().value()));
        factura.agregarDetalle(command.getDetalleId(), command.getDeporte(), command.getCantidadCupos());
        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}