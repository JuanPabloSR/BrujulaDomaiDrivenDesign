package co.com.sofka.Brujula.usecases.sucursalBrujula;

import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.Brujula.domain.sucursalBrujula.commands.ActualizarGuia;
import co.com.sofka.Brujula.domain.sucursalBrujula.commands.AgregarGuia;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.GuiaActualizado;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.GuiaAgregado;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.SucursalCreada;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.DeportePrincipal;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.GuiaId;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.NombreSucursal;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.Brujula.usecases.SucursalBrujula.ActualizarGuiaUseCase;
import co.com.sofka.Brujula.usecases.SucursalBrujula.AgregarGuiaUseCase;
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
class ActualizarGuiaUseCaseTest {
    private static final String ID_GUIA = "G-1";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar la funcion de actualizar un guia a la sucursal")
    void actualizarGuiaEnSucursal() {
        //arrange
        var command = new ActualizarGuia(
                 SucursalBrujulaId.of("S-1"),
                new GuiaId(ID_GUIA),
                new Nombre("Ciro Sanchez"),
                new Celular("3142277059"),
                new DeportePrincipal("Rafting")
                
        );
        var useCase = new ActualizarGuiaUseCase();
        Mockito.when(repository.getEventsBy(Mockito.any())).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ID_GUIA)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventGuiaActualizado = (GuiaActualizado) events.get(0);
        Assertions.assertEquals("Ciro Sanchez", eventGuiaActualizado.getNombre().value());
        Assertions.assertEquals(ID_GUIA, eventGuiaActualizado.getGuiaId().value());
        Assertions.assertEquals("3142277059", eventGuiaActualizado.getCelular().value());
        Assertions.assertEquals("Rafting", eventGuiaActualizado.getDeportePrincipal().value());
        Mockito.verify(repository).getEventsBy(ID_GUIA);
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new SucursalCreada(
                        new NombreSucursal("Sucursal Brujula Malecon")
                ),
                new GuiaActualizado(
                        new SucursalBrujulaId("S-2"),
                        new GuiaId(ID_GUIA),
                        new Nombre("Pablo Sanchez"),
                        new Celular("3197989449"),
                        new DeportePrincipal("Torrentismo")
                )
        );
    }


}