package co.com.sofka.Brujula.usecases.factura;

import co.com.sofka.Brujula.domain.factura.commands.CalcularCostoFinal;
import co.com.sofka.Brujula.domain.factura.events.CostoFinalCalculado;
import co.com.sofka.Brujula.domain.factura.events.FacturaCreada;
import co.com.sofka.Brujula.domain.factura.values.CostoFinal;
import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.factura.values.MetodoPago;
import co.com.sofka.Brujula.domain.generics.values.Fecha;
import co.com.sofka.Brujula.usecases.Factura.CalcularCostoFinalUseCase;
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
class CalcularCostoFinalUseCaseTest {
    private static final String ID_FACTURA = "F-001";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para validar la funcion de calcular el costo final en una factura")
    void calcularCostoTotalDeUnaFactura() {
        //arrange
        var command = new CalcularCostoFinal(
                new FacturaId(ID_FACTURA),
                new CostoFinal(13030010D)
        );
        var useCase = new CalcularCostoFinalUseCase();
        Mockito.when(repository.getEventsBy(ID_FACTURA)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ID_FACTURA)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventCostoFinalActualizado = (CostoFinalCalculado) events.get(0);
        Assertions.assertEquals(13030010D, eventCostoFinalActualizado.getCostoFinal().value());
        Mockito.verify(repository).getEventsBy(ID_FACTURA);
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