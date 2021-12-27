package co.com.sofka.Brujula.domain.registroVentas.events;

import co.com.sofka.Brujula.domain.registroVentas.values.Cedula;
import co.com.sofka.Brujula.domain.registroVentas.values.DocumentosId;
import co.com.sofka.Brujula.domain.registroVentas.values.SeguroRiesgos;
import co.com.sofka.domain.generic.DomainEvent;

public class DocumentosActualizados extends DomainEvent {
    private final Cedula cedula;
    private final SeguroRiesgos seguroRiesgos;

    public DocumentosActualizados(Cedula cedula, SeguroRiesgos seguroRiesgos) {
        super("sucursalbrujula.sucursal.documentosActualizados");
        this.cedula = cedula;
        this.seguroRiesgos = seguroRiesgos;
    }


    public Cedula getCedula() {
        return cedula;
    }

    public SeguroRiesgos getSeguroRiesgos() {
        return seguroRiesgos;
    }
}
