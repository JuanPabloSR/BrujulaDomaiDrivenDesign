package co.com.sofka.Brujula.usecases.sucursalBrujula;

import co.com.sofka.Brujula.domain.generics.values.Deporte;
import co.com.sofka.Brujula.domain.sucursalBrujula.commands.AgregarActividad;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.ActividadAgregada;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.SucursalCreada;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.*;
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
class AgregarActividadUseCaseTest {
    private static final String ACTIVIDAD = "Rafting";

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar agregar una actividad en una sucursal")
    void agregarActividadEnSucursal() {
        //arrange
        var command = new AgregarActividad(
                new ActividadId (ACTIVIDAD),
                SucursalBrujulaId.of("S-1"),
                        new Deporte("RAFTING"),
                        new ValorPorPersona("40000"),
                        new RangoDePeligro("Riesgo nivel 3"),
                        new EdadMinima(6)
                );
        var useCase = new AgregarActividadUseCase();
        Mockito.when(repository.getEventsBy(ACTIVIDAD)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ACTIVIDAD)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventActividadAgregada = (ActividadAgregada) events.get(0);
        Assertions.assertEquals(ACTIVIDAD, eventActividadAgregada.getActividadId().value());
        Assertions.assertEquals("RAFTING", eventActividadAgregada.getDeporte().value());
        Assertions.assertEquals("40000", eventActividadAgregada.getValorPorPersona().value());
        Assertions.assertEquals("Riesgo nivel 3", eventActividadAgregada.getRangoDePeligro().value());
        Assertions.assertEquals("6", eventActividadAgregada.getEdadMinima().value());
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