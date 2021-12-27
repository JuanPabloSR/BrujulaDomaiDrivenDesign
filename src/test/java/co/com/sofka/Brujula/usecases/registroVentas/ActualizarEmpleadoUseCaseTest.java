package co.com.sofka.Brujula.usecases.registroVentas;

import co.com.sofka.Brujula.domain.factura.events.FacturaCreada;
import co.com.sofka.Brujula.domain.factura.values.MetodoPago;
import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Fecha;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.Brujula.domain.registroVentas.commands.ActualizarEmpleado;
import co.com.sofka.Brujula.domain.registroVentas.commands.AgregarEmpleado;
import co.com.sofka.Brujula.domain.registroVentas.events.EmpleadoActualizado;
import co.com.sofka.Brujula.domain.registroVentas.events.EmpleadoAgregado;
import co.com.sofka.Brujula.domain.registroVentas.values.Cargo;
import co.com.sofka.Brujula.domain.registroVentas.values.EmpleadoId;
import co.com.sofka.Brujula.domain.registroVentas.values.VentaId;
import co.com.sofka.Brujula.usecases.RegistroVentas.ActualizarEmpleadoUseCase;
import co.com.sofka.Brujula.usecases.RegistroVentas.AgregarEmpleadoUseCase;
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

public class ActualizarEmpleadoUseCaseTest {
    private static final String ID_EMPLEADO = "E-1";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar la funcion de actualizar un empleado al registroVentas ")
    void actualizarEmpleadoEnRegistroVentas() {
        //arrange
        var command = new ActualizarEmpleado(
                VentaId.of("V-1"),
                new EmpleadoId(ID_EMPLEADO),
                new Nombre("Ciro Sanchez"),
                new Celular("3142277059"),
                new Cargo("Gerente")

        );
        var useCase = new ActualizarEmpleadoUseCase();
        Mockito.when(repository.getEventsBy(ID_EMPLEADO)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ID_EMPLEADO)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventEmpleadoActualizado = (EmpleadoActualizado) events.get(0);
        Assertions.assertEquals("Ciro Sanchez", eventEmpleadoActualizado.getNombre().value());
        Assertions.assertEquals(ID_EMPLEADO, eventEmpleadoActualizado.getEmpleadoId().value());
        Assertions.assertEquals("3142277059", eventEmpleadoActualizado.getCelular().value());
        Assertions.assertEquals("Gerente", eventEmpleadoActualizado.getCargo().value());
        Mockito.verify(repository).getEventsBy(ID_EMPLEADO);
    }

    private List<DomainEvent> EventStored() {
        return List.of(

        );
    }

}