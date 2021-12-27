package co.com.sofka.Brujula.usecases.SucursalBrujula;

import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.sucursalBrujula.SucursalBrujula;
import co.com.sofka.Brujula.domain.sucursalBrujula.commands.AgregarFactura;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.generic.Command;

public class AgregarFacturaUseCase extends UseCase<RequestCommand<AgregarFactura>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarFactura> agregarFacturaRequestCommand) {
        var command = agregarFacturaRequestCommand.getCommand();
        var sucursal= SucursalBrujula.from(command.getSucursalBrujulaId(),retrieveEvents(command.getFacturaId().value()));
        sucursal.agregarFactura(command.getFacturaId());
        emit().onResponse(new ResponseEvents(sucursal.getUncommittedChanges()));
    }
}