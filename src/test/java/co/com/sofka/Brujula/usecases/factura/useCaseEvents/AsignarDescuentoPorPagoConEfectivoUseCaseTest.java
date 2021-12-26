package co.com.sofka.Brujula.usecases.factura.useCaseEvents;

import co.com.sofka.Brujula.domain.factura.events.CostoFinalCalculado;
import co.com.sofka.Brujula.domain.factura.events.DescuentoPagoEnEfectivoAsignado;
import co.com.sofka.Brujula.domain.factura.events.FacturaCreada;
import co.com.sofka.Brujula.domain.factura.values.CostoFinal;
import co.com.sofka.Brujula.domain.factura.values.MetodoPago;
import co.com.sofka.Brujula.domain.generics.values.Fecha;
import co.com.sofka.Brujula.usecases.Factura.useCaseEvents.AsignarDescuentoPagoEnEfectivoUseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;

@ExtendWith(MockitoExtension.class)

class AsignarDescuentoPorPagoConEfectivoUseCaseTest {
    private static final String FACTURAID = "V-1";
    private static final double PORCENTAJE_DESCUENTO = 0.025;

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para Probar de un descuento cuando una venta supere los 500mil y pague en efectivo")
    void asignarDescuentoPorPagoEnEfectivo() {
        //arrange
        var event = new FacturaCreada(
                new Fecha(),
                MetodoPago.EFECTIVO
        );
        event.setAggregateRootId(FACTURAID);

        var useCase = new AsignarDescuentoPagoEnEfectivoUseCase();
        Mockito.when(repository.getEventsBy(FACTURAID)).thenReturn(eventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(FACTURAID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();


        //assert
        var eventDescuentoCreado = (DescuentoPagoEnEfectivoAsignado) events.get(0);
        var eventDescuentoAsignado = (CostoFinalCalculado) events.get(1);
        Assertions.assertEquals(PORCENTAJE_DESCUENTO, eventDescuentoCreado.getDescuento());
        Assertions.assertEquals(682500, eventDescuentoAsignado.getCostoFinal().value());
        Mockito.verify(repository).getEventsBy(FACTURAID);

    }
    @Test
    @DisplayName("Test para Probar que un descuento NO se aplique cuando una venta sea menor a 500mil y pague en efectivo")
    void noAsignaDescuentoPagoEnEfectivo() {
        //arrange
        var event = new FacturaCreada(
                new Fecha(),
                MetodoPago.EFECTIVO
        );
        event.setAggregateRootId(FACTURAID);

        var useCase = new AsignarDescuentoPagoEnEfectivoUseCase();
        Mockito.when(repository.getEventsBy(FACTURAID)).thenReturn(eventStoredFail());
        useCase.addRepository(repository);


        Assertions.assertThrows(NoSuchElementException.class,()->{
            var events = UseCaseHandler.getInstance()
                    .setIdentifyExecutor(FACTURAID)
                    .syncExecutor(useCase, new TriggeredEvent<>(event))
                    .orElseThrow()
                    .getDomainEvents();
        });


    }
    private List<DomainEvent> eventStoredFail() {
        var event = new FacturaCreada(
                new Fecha(),
                MetodoPago.EFECTIVO
        );
        var eventCalcularCostoFinal = new CostoFinalCalculado(
                new CostoFinal(300000D)
        );
        return List.of(
                event,
                eventCalcularCostoFinal
        );
    }
    private List<DomainEvent> eventStored() {
        var event = new FacturaCreada(
                new Fecha(),
                MetodoPago.EFECTIVO
        );
        var eventCalcularCostoFinal = new CostoFinalCalculado(
                new CostoFinal(700000D)
        );
        return List.of(
                event,
                eventCalcularCostoFinal
        );
    }
}