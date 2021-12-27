package co.com.sofka.Brujula.usecases.sucursalBrujula;

import co.com.sofka.Brujula.domain.generics.values.Deporte;
import co.com.sofka.Brujula.domain.sucursalBrujula.commands.ActualizarActividad;
import co.com.sofka.Brujula.domain.sucursalBrujula.commands.AgregarActividad;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.ActividadActualizada;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.ActividadAgregada;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.SucursalCreada;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.*;
import co.com.sofka.Brujula.usecases.SucursalBrujula.ActualizarActividadUseCase;
import co.com.sofka.Brujula.usecases.SucursalBrujula.AgregarActividadUseCase;
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
class ActualizarActividadUseCaseTest {
    private static final String ACTIVIDAD = "Rafting";

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar actualizar una actividad en una sucursal")
    void ActualizarActividadEnSucursal() {
        //arrange
        var command = new ActualizarActividad(
                SucursalBrujulaId.of("S-1"),
                new ActividadId (ACTIVIDAD),
                                new Deporte("RAFTING"),
                                new ValorPorPersona("40000"),
                                new RangoDePeligro("Riesgo nivel 3"),
                                new EdadMinima(6)
                        );
        var useCase = new ActualizarActividadUseCase();
        Mockito.when(repository.getEventsBy(Mockito.any())).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ACTIVIDAD)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventActividadActualizada = (ActividadAgregada) events.get(0);
        Assertions.assertEquals(ACTIVIDAD, eventActividadActualizada.getActividadId().value());
        Assertions.assertEquals("RAFTING", eventActividadActualizada.getDeporte().value());
        Assertions.assertEquals("40000", eventActividadActualizada.getValorPorPersona().value());
        Assertions.assertEquals("Riesgo nivel 3", eventActividadActualizada.getRangoDePeligro().value());
        Assertions.assertEquals("6", eventActividadActualizada.getEdadMinima().value());
        Mockito.verify(repository).getEventsBy(ACTIVIDAD);
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new SucursalCreada(
                        new NombreSucursal("Sucursal Brujula Cañaveral")
                )
        );
    }

}