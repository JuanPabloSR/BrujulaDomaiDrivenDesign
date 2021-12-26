package co.com.sofka.Brujula.usecases.factura;


import co.com.sofka.Brujula.domain.factura.commands.CrearFactura;
import co.com.sofka.Brujula.domain.factura.events.FacturaCreada;
import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.factura.values.MetodoPago;
import co.com.sofka.Brujula.domain.generics.values.Fecha;
import co.com.sofka.Brujula.usecases.Factura.CrearFacturaUseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CrearFacturaUseCaseTest {
    @Test
    @DisplayName("test para validad la funcion de crear una factura")
    void crearFactura() {
        //arrange
        var command = new CrearFactura(
                FacturaId.of("001"),
                new Fecha(),
                MetodoPago.EFECTIVO
        );
        var useCase = new CrearFacturaUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (FacturaCreada) events.get(0);
        Assertions.assertEquals(LocalDate.now(), event.getFecha().value());
        Assertions.assertEquals("EFECTIVO", event.getMetodoPago().name());
    }

}