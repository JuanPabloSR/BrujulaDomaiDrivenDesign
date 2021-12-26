package co.com.sofka.Brujula.usecases.factura;

import co.com.sofka.Brujula.domain.factura.commands.AgregarCliente;
import co.com.sofka.Brujula.domain.factura.events.ClienteAgregado;
import co.com.sofka.Brujula.domain.factura.events.FacturaCreada;
import co.com.sofka.Brujula.domain.factura.values.ClienteId;
import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.factura.values.MetodoPago;
import co.com.sofka.Brujula.domain.generics.values.*;
import co.com.sofka.Brujula.usecases.Factura.AgregarClienteUseCase;
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
class AgregarClienteUseCaseTest {
    private static final String IDCLIENTE = "1";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar la funcion agregar un cliente en una factura")
    void agregarClienteEnFactura() {
        //arrange
        var command = new AgregarCliente(FacturaId.of("1"),
                new ClienteId(IDCLIENTE),
                new Nombre("Juan"),
                new Edad("25"),
                new Celular("3197989649"),
                new Email("juanpablosanchez744@gmail.com")
        );
        var useCase = new AgregarClienteUseCase();
        Mockito.when(repository.getEventsBy(IDCLIENTE)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(IDCLIENTE)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventClienteAgregado = (ClienteAgregado) events.get(0);
        Assertions.assertEquals("Juan", eventClienteAgregado.getNombre().value());
        Assertions.assertEquals(IDCLIENTE, eventClienteAgregado.getClienteId().value());
        Assertions.assertEquals("25", eventClienteAgregado.getEdad().value());
        Assertions.assertEquals("3197989649", eventClienteAgregado.getCelular().value());
        Assertions.assertEquals("juanpablosanchez744@gmail.com", eventClienteAgregado.getEmail().value());
        Mockito.verify(repository).getEventsBy(IDCLIENTE);
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