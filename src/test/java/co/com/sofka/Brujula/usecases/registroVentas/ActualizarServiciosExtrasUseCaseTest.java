package co.com.sofka.Brujula.usecases.registroVentas;

import co.com.sofka.Brujula.domain.registroVentas.commands.AgregarServiciosExtras;
import co.com.sofka.Brujula.domain.registroVentas.events.ServiciosExtrasAgregados;
import co.com.sofka.Brujula.domain.registroVentas.values.RegistroVentasId;
import co.com.sofka.Brujula.domain.registroVentas.values.Servicio;
import co.com.sofka.Brujula.domain.registroVentas.values.ValorServicio;
import co.com.sofka.Brujula.domain.registroVentas.values.VentaId;
import co.com.sofka.Brujula.usecases.RegistroVentas.AgregarServiciosExtrasUseCase;
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
class ActualizarServiciosExtrasUseCaseTest {
    private static final String SERVICIOSEXTRAS_ID = "S-001";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar la funcion a la hora de actualizar un servicioextra a una venta")
    void actualizarServicioExtraEnVenta() {
        //arrange
        var command = new AgregarServiciosExtras(
                VentaId.of("F-001"),
                new RegistroVentasId(SERVICIOSEXTRAS_ID),
                new Servicio("Canotaje"),
                new ValorServicio(80000)
        );
        var useCase = new AgregarServiciosExtrasUseCase();
        Mockito.when(repository.getEventsBy(SERVICIOSEXTRAS_ID)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(SERVICIOSEXTRAS_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventServiciosExtrasAgregados = (ServiciosExtrasAgregados) events.get(0);
        Assertions.assertEquals(SERVICIOSEXTRAS_ID, eventServiciosExtrasAgregados.getServiciosExtraId().value());
        Assertions.assertEquals("Canotaje", eventServiciosExtrasAgregados.getServicio().value());
        Assertions.assertEquals(80000, eventServiciosExtrasAgregados.getValorServicio().value());
        Mockito.verify(repository).getEventsBy(SERVICIOSEXTRAS_ID);
    }
 
    private List<DomainEvent> EventStored() {
        return List.of(

        );
    }

}