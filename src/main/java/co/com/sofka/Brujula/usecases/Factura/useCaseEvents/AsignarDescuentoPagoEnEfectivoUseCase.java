package co.com.sofka.Brujula.usecases.Factura.useCaseEvents;

import co.com.sofka.Brujula.domain.factura.Factura;
import co.com.sofka.Brujula.domain.factura.events.FacturaCreada;
import co.com.sofka.Brujula.domain.factura.values.CostoFinal;
import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.factura.values.MetodoPago;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class AsignarDescuentoPagoEnEfectivoUseCase extends UseCase<TriggeredEvent<FacturaCreada>, ResponseEvents> {
    private static final double PORCENTAJE_DESCUENTO = 0.025;

    @Override
    public void executeUseCase(TriggeredEvent<FacturaCreada> facturaCreadaTriggeredEvent) {
        var event = facturaCreadaTriggeredEvent.getDomainEvent();
        var factura = Factura.from(FacturaId.of(event.aggregateRootId()), this.retrieveEvents());
        //el pago debe ser con efectivo y superios a 600.000 para que se haga efectivo el descuento del 0.030%
        if (factura.metodoPago().equals(MetodoPago.EFECTIVO)&&factura.costoFinal().value()>=600000D) {
            factura.asignarDescuentoPorPagoEnEfectivo(PORCENTAJE_DESCUENTO);
            var descuento = factura.costoFinal().value() * PORCENTAJE_DESCUENTO;
            factura.calcularCostoFinal(new CostoFinal(factura.costoFinal().value() - descuento));
            emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
        }
    }
}
