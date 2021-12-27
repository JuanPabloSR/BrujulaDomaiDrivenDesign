package co.com.sofka.Brujula.usecases.SucursalBrujula;

import co.com.sofka.Brujula.domain.sucursalBrujula.SucursalBrujula;
import co.com.sofka.Brujula.domain.sucursalBrujula.commands.AgregarActividad;
import co.com.sofka.Brujula.domain.sucursalBrujula.commands.AgregarPlan;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarActividadUseCase extends UseCase<RequestCommand<AgregarActividad>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarActividad> agregarActividadRequestCommand) {
        var command = agregarActividadRequestCommand.getCommand();
        var sucursal = SucursalBrujula.from(command.getSucursalBrujulaId(),retrieveEvents(command.getActividadId().value()));
        sucursal.agregarActividad(
                command.getActividadId(),
                command.getSucursalBrujulaId(),
                command.getDeporte(),
                command.getValorPorPersona(),
                command.getRangoDePeligro(),
                command.getEdadMinima()
        );
        emit().onResponse(new ResponseEvents(sucursal.getUncommittedChanges()));
    }
}