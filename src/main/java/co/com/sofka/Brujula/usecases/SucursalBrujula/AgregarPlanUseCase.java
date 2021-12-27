package co.com.sofka.Brujula.usecases.SucursalBrujula;

import co.com.sofka.Brujula.domain.sucursalBrujula.SucursalBrujula;
import co.com.sofka.Brujula.domain.sucursalBrujula.commands.AgregarPlan;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarPlanUseCase extends UseCase<RequestCommand<AgregarPlan>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPlan> agregarPlanRequestCommand) {
        var command = agregarPlanRequestCommand.getCommand();
        var sucursal = SucursalBrujula.from(command.getSucursalBrujulaId(),retrieveEvents(command.getPlanId().value()));
        sucursal.agregarPlan(
                command.getSucursalBrujulaId(),
                command.getPlanId(),
                command.getNombrePlan(),
                command.getValorPlan(),
                command.getCuposMaximos()
        );
        emit().onResponse(new ResponseEvents(sucursal.getUncommittedChanges()));
    }
}