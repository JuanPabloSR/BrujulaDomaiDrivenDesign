package co.com.sofka.Brujula.domain.registroVentas;

import co.com.sofka.Brujula.domain.generics.values.*;
import co.com.sofka.Brujula.domain.registroVentas.entities.Documento;
import co.com.sofka.Brujula.domain.registroVentas.entities.Empleado;
import co.com.sofka.Brujula.domain.registroVentas.entities.ServiciosExtras;
import co.com.sofka.Brujula.domain.registroVentas.events.*;
import co.com.sofka.Brujula.domain.registroVentas.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class RegistroVentas extends AggregateEvent<VentaId> {
    protected static Set<Empleado> empleados;
    public Documento documento;
    protected Fecha fecha;
    protected ValorTotal valorTotal;
    protected Set<Documento> documentos;
    protected Set<ServiciosExtras> serviciosExtras;

    public RegistroVentas(VentaId ventaId, Fecha fecha, ValorTotal valorTotal) {
        super(ventaId);
        Objects.requireNonNull(fecha);
        Objects.requireNonNull(valorTotal);
        appendChange(new VentaCreada(fecha, valorTotal)).apply();
    }

    private RegistroVentas(VentaId ventaId) {
        super(ventaId);
        subscribe(new RegistroVentasChange(this));
    }

    public static RegistroVentas from(VentaId ventaId, List<DomainEvent> events) {
        RegistroVentas ventas = new RegistroVentas(ventaId);
        events.forEach(ventas::applyEvent);
        return ventas;
    }

    public void AgregarDocumento(DocumentosId documentosId, Cedula cedula, SeguroRiesgos seguroRiesgos) {
        Objects.requireNonNull(documentosId);
        Objects.requireNonNull(cedula);
        Objects.requireNonNull(seguroRiesgos);
        appendChange(new DocumentoAgregado(documentosId, cedula, seguroRiesgos)).apply();
    }

    public void AgregarEmpleado(EmpleadoId empleadoId, VentaId ventaId, Nombre nombre, Celular celular, Cargo cargo) {
        Objects.requireNonNull(ventaId);
        Objects.requireNonNull(empleadoId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(celular);
        Objects.requireNonNull(cargo);
        appendChange(new EmpleadoAgregado(empleadoId, nombre, celular, cargo)).apply();
    }

    public void actualizarEmpleado(VentaId ventaId, EmpleadoId empleadoId, Nombre nombre, Celular celular, Cargo cargo) {
        Objects.requireNonNull(ventaId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(celular);
        Objects.requireNonNull(cargo);
        appendChange(new EmpleadoActualizado(ventaId, empleadoId, nombre, celular, cargo)).apply();
    }

    public void ActualizarDocumentos(Cedula cedula, SeguroRiesgos seguroRiesgos) {
        Objects.requireNonNull(cedula);
        Objects.requireNonNull(seguroRiesgos);
        appendChange(new DocumentosActualizados(cedula, seguroRiesgos)).apply();
    }

    public void AgregarServiciosExtras(ServiciosExtraId entityId,Servicio servicio, ValorServicio valorServicio) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(servicio);
        Objects.requireNonNull(valorServicio);
        appendChange(new ServiciosExtrasAgregados(entityId, servicio, valorServicio)).apply();
    }

    public void calcularValorTotal(ValorTotal valorTotal) {
        Objects.requireNonNull(valorTotal);
        appendChange(new ValorTotalCalculado(valorTotal)).apply();
    }

    public Set<Empleado> empleados() {
        return empleados;
    }
    public Fecha fecha() {
        return fecha;
    }


    public ValorTotal ValorTotal() {
        return valorTotal;
    }

    public Set<Documento> documentos() {
        return documentos;
    }
    public Set<ServiciosExtras> serviciosExtras() {
        return serviciosExtras;
    }

    public Optional<Empleado> obtenerEmpleadoPorId(EmpleadoId empleadoId) {
        return empleados.stream()
                .filter(empleado -> empleado.identity().equals(empleadoId))
                .findFirst();
    }

    public void ActualizarNombre(Nombre nombre) {
    }

    public void ActualizarCelular(Celular celular) {
    }

    public void ActualizarCargo(Cargo cargo) {
    }

    public void AgregarServiciosExtras(Servicio servicio, ValorServicio valorServicio) {
    }
}
