package co.com.sofka.Brujula.usecases.factura;

import co.com.sofka.Brujula.domain.factura.commands.AgregarVendedor;
import co.com.sofka.Brujula.domain.factura.events.FacturaCreada;
import co.com.sofka.Brujula.domain.factura.events.VendedorAgregado;
import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.factura.values.MetodoPago;
import co.com.sofka.Brujula.domain.factura.values.VendedorId;
import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Edad;
import co.com.sofka.Brujula.domain.generics.values.Fecha;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.Brujula.usecases.Factura.AgregarVendedorUseCase;
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
class AgregarVendedorUseCaseTest {
    private static final String ID_VENDEDOR = "1";
    private static final String ID_SUCURSALBRUJULA = "1";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar la funcion a la hora de agregar un vendedor en una factura")
    void agregarVendedorEnFactura() {
        //arrange
        var command = new AgregarVendedor(
                FacturaId.of("1"),
                SucursalBrujulaId.of("1"),
                new VendedorId(ID_VENDEDOR),
                new SucursalBrujulaId(ID_SUCURSALBRUJULA),
                new Nombre("Juan"),
                new Edad("25"),
                new Celular("3197989649")
        );
        var useCase = new AgregarVendedorUseCase();
        Mockito.when(repository.getEventsBy(ID_VENDEDOR)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ID_VENDEDOR)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventVendedorAgregado = (VendedorAgregado) events.get(0);
        Assertions.assertEquals("Juan", eventVendedorAgregado.getNombre().value());
        Assertions.assertEquals(ID_VENDEDOR, eventVendedorAgregado.getVendedorId().value());
        Assertions.assertEquals("25", eventVendedorAgregado.getEdad().value());
        Assertions.assertEquals("3197989649", eventVendedorAgregado.getCelular().value());
        Mockito.verify(repository).getEventsBy(ID_VENDEDOR);
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