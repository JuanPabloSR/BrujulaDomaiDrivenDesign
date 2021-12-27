package co.com.sofka.Brujula.usecases.sucursalBrujula;

import co.com.sofka.Brujula.domain.sucursalBrujula.commands.AgregarPlan;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.PlanAgregado;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.SucursalCreada;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.*;
import co.com.sofka.Brujula.usecases.SucursalBrujula.AgregarPlanUseCase;
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
class AgregarPlanUseCaseTest {
    private static final String ID_PLAN = "P-1";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar la funcion ala hora de agregar un plan a la sucursal")
    void agregarPlanEnSucursal() {
        //arrange
        var command = new AgregarPlan(
                SucursalBrujulaId.of("P-1"),
                new PlanId(ID_PLAN),
                new NombrePlan("Plan Aventura Extrema"),
                new ValorPlan("120000"),
                new CuposMaximos(5)
        );
        var useCase = new AgregarPlanUseCase();
        Mockito.when(repository.getEventsBy(ID_PLAN)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ID_PLAN)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventPlanAgregado = (PlanAgregado) events.get(0);
        Assertions.assertEquals(ID_PLAN, eventPlanAgregado.getPlanId().value());
        Assertions.assertEquals("Plan Aventura Extrema", eventPlanAgregado.getNombrePlan().value());
        Assertions.assertEquals("120000", eventPlanAgregado.getValorPlan().value());
        Mockito.verify(repository).getEventsBy(ID_PLAN);
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new SucursalCreada(
                        new NombreSucursal("Sucursal Brujula Malecon")
                )
        );
    }
}