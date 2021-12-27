package co.com.sofka.Brujula.domain.sucursalBrujula.commands;

import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.DeportePrincipal;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.GuiaId;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.domain.generic.Command;

public class AgregarGuia extends Command {
    private final SucursalBrujulaId sucursalBrujulaId;
    private final GuiaId guiaId;
    private final Nombre nombre;
    private final Celular celular;
    private final DeportePrincipal deportePrincipal;

    public AgregarGuia(SucursalBrujulaId sucursalBrujulaId, GuiaId guiaId, Nombre nombre, Celular celular, DeportePrincipal deportePrincipal) {
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
