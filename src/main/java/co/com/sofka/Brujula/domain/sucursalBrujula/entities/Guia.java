package co.com.sofka.Brujula.domain.sucursalBrujula.entities;

import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Deporte;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.*;
import co.com.sofka.domain.generic.Entity;


public class Guia extends Entity<GuiaId> {
    private SucursalBrujulaId sucursalBrujulaId;
    private GuiaId guiaId;
    private Nombre nombre;
    private Celular celular;
    private DeportePrincipal deportePrincipal;

    public Guia(SucursalBrujulaId sucursalBrujulaId, GuiaId entityId, Nombre nombre, Celular celular, DeportePrincipal deportePrincipal) {
        super(entityId);
        this.sucursalBrujulaId = sucursalBrujulaId;
        this.guiaId = guiaId;
        this.nombre = nombre;
        this.celular = celular;
        this.deportePrincipal = deportePrincipal;
    }

    public void ActualizarNombre (Nombre nombre) {
        this.nombre = nombre;
    }
    public void ActualizarCelular (Celular celular) {
        this.celular = celular;
    }
   public void ActualizardeportePrincipal (DeportePrincipal deportePrincipal) {
        this.deportePrincipal = deportePrincipal;
   }

    public SucursalBrujulaId SucursalBrujulaId() {
        return sucursalBrujulaId;
    }

    public GuiaId GuiaId() {
        return guiaId;
    }

    public Nombre Nombre() {
        return nombre;
    }

    public Celular Celular() {
        return celular;
    }

    public DeportePrincipal DeportePrincipal() {
        return deportePrincipal;
    }
}
