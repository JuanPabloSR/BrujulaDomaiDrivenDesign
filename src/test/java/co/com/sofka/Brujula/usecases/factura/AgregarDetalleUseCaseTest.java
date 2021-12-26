package co.com.sofka.Brujula.usecases.factura;

import co.com.sofka.Brujula.domain.factura.commands.AgregarDetalle;
import co.com.sofka.Brujula.domain.factura.events.DetalleAgregado;
import co.com.sofka.Brujula.domain.factura.events.FacturaCreada;
import co.com.sofka.Brujula.domain.factura.values.CantidadCupos;
import co.com.sofka.Brujula.domain.factura.values.DetalleId;
import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.factura.values.MetodoPago;
import co.com.sofka.Brujula.domain.generics.values.Deporte;
import co.com.sofka.Brujula.domain.generics.values.Fecha;
import co.com.sofka.Brujula.usecases.Factura.AgregarDetalleUseCase;
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
class AgregarDetalleUseCaseTest {
    private static final String DETALLE_ID = "D-001";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar la funcion a la hora de agregar un detalle en una factura")
    void agregarClienteEnVenta() {
        //arrange
        var command = new AgregarDetalle(
                FacturaId.of("F-001"),
                new DetalleId(DETALLE_ID),
                new Deporte("Canotaje"),
                new CantidadCupos(8)
        );
        var useCase = new AgregarDetalleUseCase();
        Mockito.when(repository.getEventsBy(DETALLE_ID)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(DETALLE_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventDetalleAgregado = (DetalleAgregado) events.get(0);
        Assertions.assertEquals(DETALLE_ID, eventDetalleAgregado.getEntityId().value());
        Assertions.assertEquals("Canotaje", eventDetalleAgregado.getDeporte().value());
        Assertions.assertEquals(8, command.getCantidadCupos().value());
        Mockito.verify(repository).getEventsBy(DETALLE_ID);
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new FacturaCreada(
                        new Fecha(),
                        MetodoPago.EFECTIVO
                )
        );
    }

}