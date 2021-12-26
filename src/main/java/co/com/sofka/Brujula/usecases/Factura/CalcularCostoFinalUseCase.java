package co.com.sofka.Brujula.usecases.Factura;

import co.com.sofka.Brujula.domain.factura.Factura;
import co.com.sofka.Brujula.domain.factura.commands.CalcularCostoFinal;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;


public class CalcularCostoFinalUseCase extends UseCase<RequestCommand<CalcularCostoFinal>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CalcularCostoFinal> calcularCostoFinalRequestCommand) {
        var command = calcularCostoFinalRequestCommand.getCommand();
        var factura = Factura.from(command.getFacturaId(), retrieveEvents(command.getFacturaId().value()));
        factura.calcularCostoFinal(command.getCostoFinal());
        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }

}
