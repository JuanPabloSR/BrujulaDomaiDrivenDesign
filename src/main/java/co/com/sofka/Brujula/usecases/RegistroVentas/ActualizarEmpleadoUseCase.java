package co.com.sofka.Brujula.usecases.RegistroVentas;

import co.com.sofka.Brujula.domain.registroVentas.RegistroVentas;
import co.com.sofka.Brujula.domain.registroVentas.commands.ActualizarEmpleado;
import co.com.sofka.Brujula.domain.registroVentas.commands.AgregarEmpleado;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarEmpleadoUseCase extends UseCase<RequestCommand<ActualizarEmpleado>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEmpleado> actualizarEmpleadoRequestCommand) {
        var command= actualizarEmpleadoRequestCommand.getCommand();
        var registroVenta= RegistroVentas.from(command.getVentaId(),retrieveEvents(command.getEmpleadoId().value()));
        registroVenta.AgregarEmpleado(command.getEmpleadoId(), command.getVentaId(), command.getNombre(), command.getCelular(), command.getCargo());
        emit().onResponse(new ResponseEvents(registroVenta.getUncommittedChanges()));
    }
}