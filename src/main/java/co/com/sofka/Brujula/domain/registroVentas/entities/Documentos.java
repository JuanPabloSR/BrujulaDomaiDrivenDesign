package co.com.sofka.Brujula.domain.registroVentas.entities;

import co.com.sofka.Brujula.domain.factura.values.ClienteId;
import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Edad;
import co.com.sofka.Brujula.domain.generics.values.Email;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.Brujula.domain.registroVentas.values.Cedula;
import co.com.sofka.Brujula.domain.registroVentas.values.DocumentosId;
import co.com.sofka.Brujula.domain.registroVentas.values.SeguroRiesgos;
import co.com.sofka.Brujula.domain.registroVentas.values.VentaId;
import co.com.sofka.domain.generic.Entity;

public class Documentos extends Entity<ClienteId> {
    private  VentaId ventaId;
    private  DocumentosId documentosId;
    private  Cedula cedula;
    private  SeguroRiesgos seguroRiesgos;

    public Documentos(ClienteId entityId, VentaId ventaId, DocumentosId documentosId, Cedula cedula, SeguroRiesgos seguroRiesgos) {
        super(entityId);
        this.ventaId = ventaId;
        this.documentosId = documentosId;
        this.cedula = cedula;
        this.seguroRiesgos = seguroRiesgos;
    }

    public void actualizarCedula(Cedula cedula) {
        this.cedula = cedula;
    }

    public void actualizarSeguroRiesgos(SeguroRiesgos seguroRiesgos) {
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
