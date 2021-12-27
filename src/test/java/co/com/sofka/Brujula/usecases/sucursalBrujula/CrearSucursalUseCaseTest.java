package co.com.sofka.Brujula.usecases.sucursalBrujula;

import co.com.sofka.Brujula.domain.sucursalBrujula.commands.CrearSucursal;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.SucursalCreada;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.NombreSucursal;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.Brujula.usecases.SucursalBrujula.CrearSucursalUseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CrearSucursalUseCaseTest {
    @Test
    @DisplayName("Test para crear una sucurasal")
    void crearSucursal() {
        //arrange
        var command = new CrearSucursal(
                SucursalBrujulaId.of("S-1111"),
                new NombreSucursal("Sucursal Brujula norte")
        );
        var useCase = new CrearSucursalUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (SucursalCreada) events.get(0);
        Assertions.assertEquals("Sucursal Brujula norte", event.getNombreSucursal().value());
    }
}