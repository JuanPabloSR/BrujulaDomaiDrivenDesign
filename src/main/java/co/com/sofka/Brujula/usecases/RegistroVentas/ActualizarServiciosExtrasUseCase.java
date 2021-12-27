package co.com.sofka.Brujula.usecases.RegistroVentas;

import co.com.sofka.Brujula.domain.registroVentas.RegistroVentas;
import co.com.sofka.Brujula.domain.registroVentas.commands.AgregarServiciosExtras;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarServiciosExtrasUseCase extends UseCase<RequestCommand<AgregarServiciosExtras>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarServiciosExtras> agregarServiciosExtrasRequestCommand) {
        var command = agregarServiciosExtrasRequestCommand.getCommand();
        var venta = RegistroVentas.from(command.getVentaId(), retrieveEvents(command.getServiciosExtraId().value()));
        venta.AgregarServiciosExtras(command.getServicio(), command.getValorServicio());
        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}