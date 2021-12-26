package co.com.sofka.Brujula.usecases.factura.useCaseEvents;

import co.com.sofka.Brujula.domain.factura.events.CostoFinalCalculado;
import co.com.sofka.Brujula.domain.factura.events.FacturaCreada;
import co.com.sofka.Brujula.domain.factura.events.PromocionAsignada;
import co.com.sofka.Brujula.domain.factura.values.CostoFinal;
import co.com.sofka.Brujula.domain.factura.values.MetodoPago;
import co.com.sofka.Brujula.domain.generics.values.Fecha;
import co.com.sofka.Brujula.usecases.Factura.useCaseEvents.AsignarPromocionUseCase;
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
class AsignarPromocionUseCaseTest {
    private static final String FACTURAID = "V-1111";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar la asignacion de una promo cuando una factura supere 500.000")
    void asignarPromocionCuandoUnaFacturaPaseDeQuinientosMil() {
        //arrange
        var event = new FacturaCreada(
                new Fecha(),
                MetodoPago.EFECTIVO
        );

        event.setAggregateRootId(FACTURAID);
        var useCase = new AsignarPromocionUseCase();
        Mockito.when(repository.getEventsBy(FACTURAID)).thenReturn(eventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(FACTURAID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();


        //assert
        var eventPromocionCreada = (PromocionAsignada) events.get(0);
        var eventPromocionAsignada = (CostoFinalCalculado) events.get(1);
        Assertions.assertEquals(40000, eventPromocionCreada.getPromocion());
        Assertions.assertEquals(560000, eventPromocionAsignada.getCostoFinal().value());
        Mockito.verify(repository).getEventsBy(FACTURAID);
    }
    @Test
    @DisplayName("test para validad que un bono NO se asigne si no supera los 500mil")
    void noAsignacionDePromocionCuandoLaFacturaNoSupereLos500Mil() {
        //arrange
        var event = new FacturaCreada(
                new Fecha(),
                MetodoPago.EFECTIVO
        );

        event.setAggregateRootId(FACTURAID);
        var useCase = new AsignarPromocionUseCase();
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

    private List<DomainEvent> eventStored() {
        var event = new FacturaCreada(
                new Fecha(),
                MetodoPago.EFECTIVO
        );
        var eventCalcularCostoFinal = new CostoFinalCalculado(new CostoFinal(600000D));
        return List.of(
                event,
                eventCalcularCostoFinal
        );
    }
    private List<DomainEvent> eventStoredFail() {
        var event = new FacturaCreada(
                new Fecha(),
                MetodoPago.EFECTIVO
        );
        var eventCalcularCostoFinal = new CostoFinalCalculado(new CostoFinal(400000D));
        return List.of(
                event,
                eventCalcularCostoFinal
        );
    }
}