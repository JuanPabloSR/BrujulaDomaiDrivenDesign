package co.com.sofka.Brujula.domain.registroVentas.commands;

import co.com.sofka.Brujula.domain.registroVentas.values.Cedula;
import co.com.sofka.Brujula.domain.registroVentas.values.DocumentosId;
import co.com.sofka.Brujula.domain.registroVentas.values.SeguroRiesgos;
import co.com.sofka.Brujula.domain.registroVentas.values.VentaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarDocumentos extends Command {


    private final VentaId ventaId;
    private final DocumentosId documentosId;
    private final Cedula cedula;
    private final SeguroRiesgos seguroRiesgos;

    public ActualizarDocumentos(VentaId ventaId, DocumentosId documentosId, Cedula cedula, SeguroRiesgos seguroRiesgos) {
        this.ventaId = ventaId;
        this.documentosId = documentosId;
        this.cedula = cedula;
        this.seguroRiesgos = seguroRiesgos;
    }

    public VentaId getVentaId() {
        return ventaId;
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
