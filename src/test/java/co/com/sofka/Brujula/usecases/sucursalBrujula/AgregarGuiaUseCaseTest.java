package co.com.sofka.Brujula.usecases.sucursalBrujula;

import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.Brujula.domain.sucursalBrujula.commands.AgregarGuia;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.GuiaAgregado;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.SucursalCreada;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.DeportePrincipal;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.GuiaId;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.NombreSucursal;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
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
class AgregarGuiaUseCaseTest {
    private static final String ID_GUIA = "G-1";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar la funcion de agregar un guia a la sucursal")
    void agregarGuiaEnSucursal() {
        //arrange
        var command = new AgregarGuia(
                SucursalBrujulaId.of("S-1"),
                new GuiaId(ID_GUIA),
                new Nombre("Ciro Sanchez"),
                new Celular("3142277059"),
                new DeportePrincipal("Rafting")
                
        );
        var useCase = new AgregarGuiaUseCase();
        Mockito.when(repository.getEventsBy(ID_GUIA)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ID_GUIA)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventGuiaAgregado = (GuiaAgregado) events.get(0);
        Assertions.assertEquals("Ciro Sanchez", eventGuiaAgregado.getNombre().value());
        Assertions.assertEquals(ID_GUIA, eventGuiaAgregado.getGuiaId().value());
        Assertions.assertEquals("3142277059", eventGuiaAgregado.getCelular().value());
        Assertions.assertEquals("Rafting", eventGuiaAgregado.getDeportePrincipal().value());
        Mockito.verify(repository).getEventsBy(ID_GUIA);
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new SucursalCreada(
                        new NombreSucursal("Sucursal Brujula Malecon")
                )
        );
    }


}