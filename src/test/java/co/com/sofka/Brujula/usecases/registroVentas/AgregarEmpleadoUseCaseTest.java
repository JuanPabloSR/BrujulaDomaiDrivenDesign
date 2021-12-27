package co.com.sofka.Brujula.usecases.registroVentas;

import co.com.sofka.Brujula.domain.factura.events.ClienteAgregado;
import co.com.sofka.Brujula.domain.factura.events.FacturaCreada;
import co.com.sofka.Brujula.domain.factura.values.ClienteId;
import co.com.sofka.Brujula.domain.factura.values.MetodoPago;
import co.com.sofka.Brujula.domain.generics.values.*;
import co.com.sofka.Brujula.domain.registroVentas.commands.AgregarEmpleado;
import co.com.sofka.Brujula.domain.registroVentas.events.EmpleadoAgregado;
import co.com.sofka.Brujula.domain.registroVentas.events.VentaCreada;
import co.com.sofka.Brujula.domain.registroVentas.values.Cargo;
import co.com.sofka.Brujula.domain.registroVentas.values.EmpleadoId;
import co.com.sofka.Brujula.domain.registroVentas.values.ValorTotal;
import co.com.sofka.Brujula.domain.registroVentas.values.VentaId;
import co.com.sofka.Brujula.domain.sucursalBrujula.commands.AgregarGuia;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.GuiaAgregado;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.SucursalCreada;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.DeportePrincipal;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.GuiaId;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.NombreSucursal;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.Brujula.usecases.RegistroVentas.AgregarEmpleadoUseCase;
import co.com.sofka.Brujula.usecases.SucursalBrujula.AgregarGuiaUseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class AgregarEmpleadoUseCaseTest {
    private static final String ID_EMPLEADO = "E-1";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar la funcion de agregar un empleado al registroVentas ")
    void agregarEmpleadoEnRegistroVentas() {
        //arrange
        var command = new AgregarEmpleado(
                VentaId.of("V-1"),
                new EmpleadoId(ID_EMPLEADO),
                new Nombre("Ciro Sanchez"),
                new Celular("3142277059"),
                new Cargo("Gerente")

        );
        var useCase = new AgregarEmpleadoUseCase();
        Mockito.when(repository.getEventsBy(ID_EMPLEADO)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ID_EMPLEADO)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventEmpleadoAgregado = (EmpleadoAgregado) events.get(0);
        Assertions.assertEquals("Ciro Sanchez", eventEmpleadoAgregado.getNombre().value());
        Assertions.assertEquals(ID_EMPLEADO, eventEmpleadoAgregado.getEmpleadoId().value());
        Assertions.assertEquals("3142277059", eventEmpleadoAgregado.getCelular().value());
        Assertions.assertEquals("Gerente", eventEmpleadoAgregado.getCargo().value());
        Mockito.verify(repository).getEventsBy(ID_EMPLEADO);
    }

    private List<DomainEvent> EventStored() {
        return List.of(

        );
    }

}