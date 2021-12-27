package co.com.sofka.Brujula.domain.factura;

import co.com.sofka.Brujula.domain.factura.entities.Cliente;
import co.com.sofka.Brujula.domain.factura.entities.Detalle;
import co.com.sofka.Brujula.domain.factura.entities.Vendedor;
import co.com.sofka.Brujula.domain.factura.events.*;
import co.com.sofka.Brujula.domain.factura.values.*;
import co.com.sofka.Brujula.domain.factura.values.MetodoPago;
import co.com.sofka.Brujula.domain.generics.values.*;
import co.com.sofka.Brujula.domain.sucursalBrujula.values.SucursalBrujulaId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Factura extends AggregateEvent<FacturaId> {
    protected static Set<Detalle> detalles;
    protected Fecha fecha;
    protected MetodoPago metodoPago;
    protected CostoFinal costoFinal;
    protected Set<Vendedor> vendedores;
    protected Cliente cliente;
    protected Double promocion;

    public Factura(FacturaId entityId, Fecha fecha, MetodoPago metodoPago) {
        super(entityId);
        Objects.requireNonNull(fecha);
        Objects.requireNonNull(metodoPago);
        appendChange(new FacturaCreada(fecha, metodoPago)).apply();
    }

    private Factura(FacturaId entityId) {
        super(entityId);
        subscribe(new FacturaChange(this));
    }

    public static Factura from(FacturaId entityID, List<DomainEvent> events) {
        Factura factura = new Factura(entityID);
        events.forEach(factura::applyEvent);
        return factura;
    }

    public void agregarCliente(ClienteId clienteId, Nombre nombre, Edad edad, Celular celular, Email email) {
        Objects.requireNonNull(clienteId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(edad);
        Objects.requireNonNull(celular);
        Objects.requireNonNull(email);
        appendChange(new ClienteAgregado(clienteId, nombre, edad, celular, email)).apply();
    }

    public void agregarVendedor(VendedorId vendedorId, SucursalBrujulaId sucursalBrujulaId, Nombre nombre, Edad edad, Celular celular) {
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(edad);
        Objects.requireNonNull(celular);
        appendChange(new VendedorAgregado(sucursalBrujulaId, vendedorId, nombre, edad, celular)).apply();
    }

    public void actualizarVendedor(VendedorId entityId, SucursalBrujulaId sucursalBrujulaId, Nombre nombre, Edad edad, Celular celular) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(edad);
        Objects.requireNonNull(celular);
        appendChange(new VendedorActualizado(sucursalBrujulaId, entityId, nombre, edad, celular)).apply();
    }

    public void ActualizarCliente(Nombre nombre, Edad edad, Celular celular, Email email) {
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(edad);
        Objects.requireNonNull(celular);
        Objects.requireNonNull(email);
        appendChange(new ClienteActualizado(nombre, edad, celular, email)).apply();
    }

    public void agregarDetalle(DetalleId entityId,Deporte deporte, CantidadCupos cantidadCupos) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(deporte);
        Objects.requireNonNull(cantidadCupos);
        appendChange(new DetalleAgregado(entityId, deporte, cantidadCupos)).apply();
    }

    public void actualizarCantidadCupos(DetalleId entityId, CantidadCupos cantidadCupos) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(cantidadCupos);
        appendChange(new CantidadCuposActualizado(entityId, cantidadCupos));
    }

    public void calcularCostoFinal(CostoFinal costoFinal) {
        Objects.requireNonNull(costoFinal);
        appendChange(new CostoFinalCalculado(costoFinal)).apply();
    }
    public void asignarPromocion(Double promocion){
        appendChange(new PromocionAsignada(promocion)).apply();
    }

    public void asignarDescuentoPorPagoEnEfectivo(Double descuento){
        appendChange(new DescuentoPagoEnEfectivoAsignado(descuento)).apply();
    }

    public Fecha fecha() {
        return fecha;
    }

    public MetodoPago metodoPago() {
        return metodoPago;
    }

    public CostoFinal costoFinal() {
        return costoFinal;
    }

    public Set<Vendedor> vendedores() {
        return vendedores;
    }

    public Cliente cliente() {
        return cliente;
    }

    public static Set<Detalle> detalles() {
        return detalles;
    }

    public Double Promocion() {
        return promocion;
    }

    public static Optional<Detalle> obtenerDetallePorId(DetalleId detalleId) {
        return detalles().stream()
                .filter(detalle -> detalle.identity().equals(detalleId))
                .findFirst();
    }

    public Optional<Vendedor> obtenerVendedorPorId(VendedorId vendedorId) {
        return vendedores().stream()
                .filter(vendedor -> vendedor.identity().equals(vendedorId))
                .findFirst();
    }
}