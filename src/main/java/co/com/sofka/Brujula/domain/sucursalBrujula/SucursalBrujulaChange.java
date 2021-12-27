package co.com.sofka.Brujula.domain.sucursalBrujula;

import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.sucursalBrujula.entities.Actividad;
import co.com.sofka.Brujula.domain.sucursalBrujula.entities.Guia;
import co.com.sofka.Brujula.domain.sucursalBrujula.entities.Plan;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class SucursalBrujulaChange extends EventChange {
    public SucursalBrujulaChange(SucursalBrujula sucursalBrujula){
        apply((SucursalCreada event) -> {
            sucursalBrujula.nombreSucursal = event.getNombreSucursal();
            sucursalBrujula.guias = new HashSet<>();
            sucursalBrujula.actividades = new HashSet<>();
            sucursalBrujula.planes = new HashSet<>();
        });

        apply((GuiaAgregado event) -> {
            sucursalBrujula.guias.add(new Guia(
                    event.getSucursalBrujulaId(),
                    event.getGuiaId(),
                    event.getNombre(),
                    event.getCelular(),
                    event.getDeportePrincipal()
            ));
        });

        apply((PlanAgregado event) -> {
            sucursalBrujula.planes.add(new Plan(
                    event.getPlanId(),
                    event.getNombrePlan(),
                    event.getValorPlan(),
                    event.getCuposMaximos()
            ));
        });

        apply((ActividadAgregada event) -> {
            sucursalBrujula.actividades.add(new Actividad(
                    event.getActividadId(),
                    event.getSucursalBrujulaId(),
                    event.getDeporte(),
                    event.getValorPorPersona(),
                    event.getRangoDePeligro(),
                    event.getEdadMinima()
            ));
        });

        apply((FacturaAgregada event) -> {
            sucursalBrujula.facturas.add(new FacturaId(event.getFacturaId().value()));
        });

        apply((GuiaActualizado event) -> {
            var guia = sucursalBrujula.obtenerGuiaPorId(event.getGuiaId())
                    .orElseThrow(() -> new IllegalArgumentException("No existe ningun guia con el id " + event.getGuiaId()));
            guia.ActualizarNombre(event.getNombre());
            guia.ActualizarCelular(event.getCelular());
            guia.ActualizardeportePrincipal(event.getDeportePrincipal());
        });

        apply((ActividadActualizada event) -> {
            var actividad = sucursalBrujula.obtenerActividadPorId(event.getActividadId())
                    .orElseThrow(() -> new IllegalArgumentException("No existe ninguna actividad con ese Id " + event.getActividadId()));
            actividad.actualizarDeporte(event.getDeporte());
            actividad.actualizarEdadMinima(event.getEdadMinima());
            actividad.actualizarValorPorPersona(event.getValorPorPersona());
            actividad.actualizarRangoDePeligro(event.getRangoDePeligro());
            actividad.actualizarEdadMinima(event.getEdadMinima());
        });

        apply((ValorPlanActualizado event) -> {
            var plan = sucursalBrujula.obtenerPlanesPorId(event.getPlanId())
                    .orElseThrow(() -> new IllegalArgumentException("No existe ningún plan con el id " + event.getPlanId()));
            plan.actualizarValorPlan(event.getValorPlan());
        });


    }
}
