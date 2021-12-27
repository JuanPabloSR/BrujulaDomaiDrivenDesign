package co.com.sofka.Brujula.domain.registroVentas.events;

import co.com.sofka.Brujula.domain.factura.values.CantidadCupos;
import co.com.sofka.Brujula.domain.factura.values.DetalleId;
import co.com.sofka.Brujula.domain.generics.values.Deporte;
import co.com.sofka.Brujula.domain.registroVentas.values.Cedula;
import co.com.sofka.Brujula.domain.registroVentas.values.DocumentosId;
import co.com.sofka.Brujula.domain.registroVentas.values.SeguroRiesgos;
import co.com.sofka.domain.generic.DomainEvent;

public class DocumentoAgregado extends DomainEvent {
    private final DocumentosId documentosId;
    private final Cedula cedula;
    private final SeguroRiesgos seguroRiesgos;

    public DocumentoAgregado(DocumentosId documentosId, Cedula cedula, SeguroRiesgos seguroRiesgos) {
        super("sucursalbrujula.sucursal.documentosAgregados");
        this.documentosId = documentosId;
        this.cedula = cedula;
        this.seguroRiesgos = seguroRiesgos;
    }

    public DocumentosId getDocumentosId() {
        return documentosId;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public SeguroRiesgos getSeguroRiesgos() {
        return seguroRiesgos;
    }
}
