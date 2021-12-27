package co.com.sofka.Brujula.usecases.sucursalBrujula;

import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.sucursalBrujula.commands.AgregarFactura;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.FacturaAgregada;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.SucursalCreada;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.NombreSucursal;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.Brujula.usecases.SucursalBrujula.AgregarFacturaUseCase;
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
class AgregarFacturaUseCaseTest {
    private static final String FACTURA_ID = "F-1";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar agregar una factura a una sucursal")
    void agregarFacturaEnSucursal() {
        //arrange
        var command = new AgregarFactura(
                SucursalBrujulaId.of("S-1"),
                new FacturaId(FACTURA_ID)
        );
        var useCase = new AgregarFacturaUseCase();
        Mockito.when(repository.getEventsBy(FACTURA_ID)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(FACTURA_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventFacturaAgregada = (FacturaAgregada) events.get(0);
        Assertions.assertEquals(FACTURA_ID, eventFacturaAgregada.getFacturaId().value());
        Mockito.verify(repository).getEventsBy(FACTURA_ID);

    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new SucursalCreada(
                        new NombreSucursal("Sucursal Brujula Centro")
                )
        );
    }

}