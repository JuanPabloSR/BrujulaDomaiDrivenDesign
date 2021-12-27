package co.com.sofka.Brujula.usecases.sucursalBrujula;

import co.com.sofka.Brujula.domain.sucursalBrujula.commands.ActualizarValorPlan;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.PlanAgregado;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.SucursalCreada;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.ValorPlanActualizado;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.*;
import co.com.sofka.Brujula.usecases.SucursalBrujula.ActualizarValorPlanUseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)

class ActualizarValorPlanUseCaseTest {
    private final String PLAN_ID="P-001";
    @Mock
    private DomainEventRepository repository;
    @Test
    @DisplayName("Test para probar la actualización del valor de un plan")
    void validarActualizacionDelValorDeUnPlan() {
        //arrange
        var command = new ActualizarValorPlan(
                SucursalBrujulaId.of("S-001"),
                new PlanId(PLAN_ID),
                new ValorPlan("300000")
        );
        var useCase = new ActualizarValorPlanUseCase();
        Mockito.when(repository.getEventsBy(PLAN_ID)).thenReturn(eventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(PLAN_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventValorPLanActualizado = (ValorPlanActualizado) events.get(0);
        Assertions.assertEquals(PLAN_ID, eventValorPLanActualizado.getPlanId().value());
        Assertions.assertEquals("300000",eventValorPLanActualizado.getValorPlan().value());
        Mockito.verify(repository).getEventsBy(PLAN_ID);
    }

    private List<DomainEvent> eventStored() {
        var eventSucursalCreada = new SucursalCreada(
                new NombreSucursal("Brujula Sur")
        );
        var eventPlanAgregado = new PlanAgregado(
                new PlanId(PLAN_ID),
                new NombrePlan("Tecnomecanica"),
                new ValorPlan("200000"),
                new CuposMaximos(5)
        );
        return List.of(
                eventSucursalCreada,
                eventPlanAgregado
        );
    }
}