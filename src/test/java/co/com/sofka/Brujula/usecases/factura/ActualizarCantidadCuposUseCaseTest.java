package co.com.sofka.Brujula.usecases.factura;


import co.com.sofka.Brujula.domain.factura.commands.ActualizarCantidadCupos;
import co.com.sofka.Brujula.domain.factura.events.CantidadCuposActualizado;
import co.com.sofka.Brujula.domain.factura.events.DetalleAgregado;
import co.com.sofka.Brujula.domain.factura.events.FacturaCreada;
import co.com.sofka.Brujula.domain.factura.values.CantidadCupos;
import co.com.sofka.Brujula.domain.factura.values.DetalleId;
import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.factura.values.MetodoPago;
import co.com.sofka.Brujula.domain.generics.values.Deporte;
import co.com.sofka.Brujula.domain.generics.values.Fecha;
import co.com.sofka.Brujula.usecases.Factura.ActualizarCantidadCuposUseCase;
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
class ActualizarCantidadCuposUseCaseTest {
    private final static String DETALLE_ID = "D-1";

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar la funcion actualizar la cantiadad de cupos en el detalle de una factura")
    void actualizarCantidadCuposEnElDetalleDeUnaFactura() {
        //arrange
        var command = new ActualizarCantidadCupos(
                new FacturaId("V-1"),
                new DetalleId(DETALLE_ID),
                new CantidadCupos(8)
        );
        var useCase = new ActualizarCantidadCuposUseCase();
        Mockito.when(repository.getEventsBy(Mockito.any())).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(DETALLE_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventCantidadCuposActualizado = (CantidadCuposActualizado) events.get(0);
        Assertions.assertEquals(DETALLE_ID, eventCantidadCuposActualizado.getEntityId().value());
        Assertions.assertEquals(8, eventCantidadCuposActualizado.getCantidadCupos().value());
        Mockito.verify(repository).getEventsBy(DETALLE_ID);
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new FacturaCreada(
                        new Fecha(),
                        MetodoPago.EFECTIVO
                ),
                new DetalleAgregado(
                        new DetalleId(DETALLE_ID),
                        new Deporte("Canotaje"),
                        new CantidadCupos(8)
                )
        );
    }
}