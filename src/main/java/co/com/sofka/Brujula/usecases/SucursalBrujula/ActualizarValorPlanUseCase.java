package co.com.sofka.Brujula.usecases.SucursalBrujula;

import co.com.sofka.Brujula.domain.sucursalBrujula.SucursalBrujula;
import co.com.sofka.Brujula.domain.sucursalBrujula.commands.ActualizarValorPlan;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarValorPlanUseCase  extends UseCase<RequestCommand<ActualizarValorPlan>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarValorPlan> actualizarValorPlanRequestCommand) {
        var command = actualizarValorPlanRequestCommand.getCommand();
        var sucursal = SucursalBrujula.from(command.getSucursalBrujulaId(), retrieveEvents(command.getPlanId().value()));
        sucursal.actualizarValorPlan(command.getPlanId(), command.getValorPlan());
        emit().onResponse(new ResponseEvents(sucursal.getUncommittedChanges()));
    }
}