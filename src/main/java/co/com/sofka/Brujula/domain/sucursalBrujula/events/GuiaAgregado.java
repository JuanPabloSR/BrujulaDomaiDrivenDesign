package co.com.sofka.Brujula.domain.sucursalBrujula.events;

import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.DeportePrincipal;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.GuiaId;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.domain.generic.DomainEvent;

public class GuiaAgregado extends DomainEvent {
    private final SucursalBrujulaId sucursalBrujulaId;
    private final GuiaId guiaId;
    private final Nombre nombre;
    private final Celular celular;
    private final DeportePrincipal deportePrincipal;

    public GuiaAgregado(SucursalBrujulaId sucursalBrujulaId, GuiaId guiaId, Nombre nombre, Celular celular, DeportePrincipal deportePrincipal) {
        super("sucursalbrujula.sucursal.guiaAgregado");
        this.sucursalBrujulaId = sucursalBrujulaId;
        this.guiaId = guiaId;
        this.nombre = nombre;
        this.celular = celular;
        this.deportePrincipal = deportePrincipal;
    }

    public SucursalBrujulaId getSucursalBrujulaId() {
        return sucursalBrujulaId;
    }

    public GuiaId getGuiaId() {
        return guiaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Celular getCelular() {
        return celular;
    }

    public DeportePrincipal getDeportePrincipal() {
        return deportePrincipal;
    }
}
