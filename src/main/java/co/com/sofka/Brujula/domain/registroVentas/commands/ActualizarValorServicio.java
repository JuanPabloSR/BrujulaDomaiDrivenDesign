package co.com.sofka.Brujula.domain.registroVentas.commands;

import co.com.sofka.Brujula.domain.registroVentas.RegistroVentas;
import co.com.sofka.Brujula.domain.registroVentas.values.RegistroVentasId;
import co.com.sofka.Brujula.domain.registroVentas.values.ServiciosExtraId;
import co.com.sofka.Brujula.domain.registroVentas.values.ValorServicio;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.PlanId;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.ValorPlan;
import co.com.sofka.domain.generic.Command;

public class ActualizarValorServicio extends Command {
    private final RegistroVentasId registroVentasId;
    private final ServiciosExtraId serviciosExtraId;
    private final ValorServicio valorServicio;

    public ActualizarValorServicio(RegistroVentasId registroVentasId, ServiciosExtraId serviciosExtraId, ValorServicio valorServicio) {
        this.registroVentasId = registroVentasId;
        this.serviciosExtraId = serviciosExtraId;
        this.valorServicio = valorServicio;
    }

    public RegistroVentasId getRegistroVentasId() {
        return registroVentasId;
    }

    public ServiciosExtraId getServiciosExtraId() {
        return serviciosExtraId;
    }

    public ValorServicio getValorServicio() {
        return valorServicio;
    }
}
