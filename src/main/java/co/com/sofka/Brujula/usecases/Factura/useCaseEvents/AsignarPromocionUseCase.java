package co.com.sofka.Brujula.usecases.Factura.useCaseEvents;

import co.com.sofka.Brujula.domain.factura.Factura;
import co.com.sofka.Brujula.domain.factura.events.FacturaCreada;
import co.com.sofka.Brujula.domain.factura.values.CostoFinal;
import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class AsignarPromocionUseCase extends UseCase<TriggeredEvent<FacturaCreada>, ResponseEvents> {
    private static final Double PROMOCION=50000D;
    @Override
    public void executeUseCase(TriggeredEvent<FacturaCreada> facturaCreadaTriggeredEvent) {
        var event = facturaCreadaTriggeredEvent.getDomainEvent();
        var factura= Factura.from(FacturaId.of(event.aggregateRootId()),this.retrieveEvents());
        if(factura.costoFinal().value()>500000){
            factura.asignarPromocion(PROMOCION);
            factura.calcularCostoFinal(new CostoFinal(factura.costoFinal().value()-PROMOCION));
            emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
        }
    }
}
