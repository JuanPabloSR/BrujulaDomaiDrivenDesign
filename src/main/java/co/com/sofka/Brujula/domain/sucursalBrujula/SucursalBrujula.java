package co.com.sofka.Brujula.domain.sucursalBrujula;

import co.com.sofka.Brujula.domain.factura.values.FacturaId;
import co.com.sofka.Brujula.domain.generics.values.Celular;
import co.com.sofka.Brujula.domain.generics.values.Deporte;
import co.com.sofka.Brujula.domain.generics.values.Nombre;
import co.com.sofka.Brujula.domain.sucursalBrujula.entities.Actividad;
import co.com.sofka.Brujula.domain.sucursalBrujula.entities.Guia;
import co.com.sofka.Brujula.domain.sucursalBrujula.entities.Plan;
import co.com.sofka.Brujula.domain.sucursalBrujula.events.*;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class SucursalBrujula extends AggregateEvent<SucursalBrujulaId> {
    protected NombreSucursal nombreSucursal;
    protected Set<Guia> guias;
    protected Set<Actividad> actividades;
    protected Set<Plan> planes;
    protected Set<FacturaId> facturas;

    public SucursalBrujula(SucursalBrujulaId entityId, NombreSucursal nombreSucursal) {
        super(entityId);
        Objects.requireNonNull(nombreSucursal);
        appendChange(new SucursalCreada(nombreSucursal)).apply();
    }
    private SucursalBrujula(SucursalBrujulaId entityId) {
        super(entityId);
        subscribe(new SucursalBrujulaChange(this));
    }


    public static SucursalBrujula from(SucursalBrujulaId entityId, List<DomainEvent> events) {
        SucursalBrujula sucursalBrujula = new SucursalBrujula(entityId);
        events.forEach(sucursalBrujula::applyEvent);
        return sucursalBrujula;
    }
    public void agregarGuia(GuiaId entityId, SucursalBrujulaId sucursalBrujulaId, Nombre nombre, Celular celular, DeportePrincipal deportePrincipal){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(sucursalBrujulaId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(celular);
        Objects.requireNonNull(deportePrincipal);
        appendChange(new GuiaAgregado(sucursalBrujulaId, entityId, nombre, celular, deportePrincipal)).apply();
    }
    public void agregarActividad(ActividadId actividadId,SucursalBrujulaId sucursalBrujulaId, Deporte deporte, ValorPorPersona valorPorPersona, RangoDePeligro rangoDePeligro, EdadMinima edadMinima){
        Objects.requireNonNull(actividadId);
        Objects.requireNonNull(sucursalBrujulaId);
        Objects.requireNonNull(deporte);
        Objects.requireNonNull(valorPorPersona);
        Objects.requireNonNull(rangoDePeligro);
        Objects.requireNonNull(edadMinima);
        appendChange(new ActividadAgregada(sucursalBrujulaId, actividadId, deporte, valorPorPersona, rangoDePeligro,edadMinima)).apply();
    }

    public void agregarPlanes(PlanId planesId, NombrePlan nombrePlan, ValorPlan valorPlan, CuposMaximos cuposMaximos) {
        Objects.requireNonNull(planesId);
        Objects.requireNonNull(nombrePlan);
        Objects.requireNonNull(valorPlan);
        Objects.requireNonNull(cuposMaximos);
        appendChange(new PlanAgregado(planesId, nombrePlan, valorPlan, cuposMaximos)).apply();
    }

    public void agregarFactura(FacturaId facturaId){
        Objects.requireNonNull(facturaId);
        appendChange(new FacturaAgregada(facturaId)).apply();
    }
    public void actualizarGuia(GuiaId entityId, SucursalBrujulaId sucursalBrujulaId, Nombre nombre, Celular celular, DeportePrincipal deportePrincipal){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(sucursalBrujulaId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(celular);
        Objects.requireNonNull(deportePrincipal);
        appendChange(new GuiaActualizado(sucursalBrujulaId, entityId, nombre, celular, deportePrincipal)).apply();
    }
    public void actualizarActividad(ActividadId actividadId,SucursalBrujulaId sucursalBrujulaId, Deporte deporte, ValorPorPersona valorPorPersona, RangoDePeligro rangoDePeligro, EdadMinima edadMinima){
        Objects.requireNonNull(actividadId);
        Objects.requireNonNull(deporte);
        Objects.requireNonNull(valorPorPersona);
        Objects.requireNonNull(rangoDePeligro);
        Objects.requireNonNull(edadMinima);
        appendChange(new ActividadActualizada(sucursalBrujulaId, actividadId, deporte, valorPorPersona, rangoDePeligro,edadMinima)).apply();
    }

    public void actualizarValorPlan(PlanId planId, ValorPlan valorPlan) {
        Objects.requireNonNull(planId);
        Objects.requireNonNull(valorPlan);
        appendChange(new ValorPlanActualizado(planId, valorPlan)).apply();
    }
    public Optional<Guia> obtenerGuiaPorId(GuiaId guiaId) {
        return guias.stream()
                .filter(guia -> guia.identity().equals(guiaId))
                .findFirst();
    }
    public Optional<Actividad> obtenerActividadPorId(ActividadId actividadId) {
        return actividades.stream()
                .filter(actividad -> actividad.identity().equals(actividadId))
                .findFirst();
    }
    public Optional<Plan> obtenerPlanesPorId(PlanId planesId) {
        return planes.stream()
                .filter(planes -> planes.identity().equals(planesId))
                .findFirst();
    }

    public NombreSucursal NombreSucursal() {
        return nombreSucursal;
    }

    public void setGuias(Set<Guia> guias) {
        this.guias = guias;
    }

    public void setActividades(Set<Actividad> actividades) {
        this.actividades = actividades;
    }

    public void setPlanes(Set<Plan> planes) {
        this.planes = planes;
    }

    public void setFacturas(Set<FacturaId> facturas) {
        this.facturas = facturas;
    }
}
