package co.com.sofka.Brujula.domain.registroVentas.commands;

import co.com.sofka.Brujula.domain.factura.values.ClienteId;
import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Edad;
import co.com.sofka.Brujula.domain.generics.values.Email;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.Brujula.domain.registroVentas.values.Cedula;
import co.com.sofka.Brujula.domain.registroVentas.values.DocumentosId;
import co.com.sofka.Brujula.domain.registroVentas.values.SeguroRiesgos;
import co.com.sofka.Brujula.domain.registroVentas.values.VentaId;
import co.com.sofka.domain.generic.Command;

public class AgregarDocumentos extends Command {

    private final VentaId ventaId;
    private final DocumentosId documentosId;
    private final Cedula cedula;
    private final SeguroRiesgos seguroRiesgos;

    public AgregarDocumentos(VentaId ventaId, DocumentosId documentosId, Cedula cedula, SeguroRiesgos seguroRiesgos) {
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
