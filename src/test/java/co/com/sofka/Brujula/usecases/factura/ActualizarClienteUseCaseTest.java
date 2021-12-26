package co.com.sofka.Brujula.usecases.factura;


import co.com.sofka.Brujula.domain.factura.commands.ActualizarCliente;
import co.com.sofka.Brujula.domain.factura.events.ClienteActualizado;
import co.com.sofka.Brujula.domain.factura.events.ClienteAgregado;
import co.com.sofka.Brujula.domain.factura.events.FacturaCreada;
import co.com.sofka.Brujula.domain.factura.values.ClienteId;
import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.factura.values.MetodoPago;
import co.com.sofka.Brujula.domain.generics.values.*;
import co.com.sofka.Brujula.usecases.Factura.ActualizarClienteUseCase;
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
class ActualizarClienteUseCaseTest {
    private final String CLIENTE_ID = "C-1";
    private final String FACTURA_ID= "F-1";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar la funcion de actualizar un cliente en una factura")
    void actuarlizarClienteEnFacturaDeManeraEsperada() {
        //arrange
        var command = new ActualizarCliente(
                FacturaId.of(FACTURA_ID),
                ClienteId.of(CLIENTE_ID),
                        new Nombre("Ivon Acevedo"),
                        new Edad("22"),
                        new Celular("3007628717"),
                        new Email("ivon@gmail.com")
                );
        var useCase = new ActualizarClienteUseCase();
        Mockito.when(repository.getEventsBy(FACTURA_ID)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(FACTURA_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventClienteActualizado = (ClienteActualizado) events.get(0);
        Assertions.assertEquals("Ivon Acevedo", eventClienteActualizado.getNombre().value());
        Assertions.assertEquals("22", eventClienteActualizado.getEdad().value());
        Assertions.assertEquals("3007628717", eventClienteActualizado.getCelular().value());
        Assertions.assertEquals("ivon@gmail.com", eventClienteActualizado.getEmail().value());
        Mockito.verify(repository).getEventsBy(FACTURA_ID);
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new FacturaCreada(
                        new Fecha(),
                        MetodoPago.EFECTIVO
                ),
                new ClienteAgregado(
                        new ClienteId(CLIENTE_ID),
                        new Nombre("Natalia"),
                        new Edad("25"),
                        new Celular("3002528794"),
                        new Email("natalia@gmail.com")
                )
        );
    }


}