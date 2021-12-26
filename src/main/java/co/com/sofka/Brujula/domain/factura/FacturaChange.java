package co.com.sofka.Brujula.domain.factura;

import co.com.sofka.Brujula.domain.factura.entities.Cliente;
import co.com.sofka.Brujula.domain.factura.entities.Detalle;
import co.com.sofka.Brujula.domain.factura.entities.Vendedor;
import co.com.sofka.Brujula.domain.factura.events.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class FacturaChange extends EventChange {
    public FacturaChange(Factura factura) {
        apply((FacturaCreada event) -> {
            factura.fecha = event.getFecha();
            factura.metodoPago = event.getMetodoPago();
            factura.vendedores = new HashSet<>();
            factura.detalles = new HashSet<>();
        });
        apply((ClienteAgregado event) -> {
            factura.cliente = new Cliente(event.getClienteId(), event.getNombre(), event.getEdad(), event.getCelular(), event.getEmail());
        });

        apply((VendedorAgregado event) -> {
            factura.vendedores.add(
                    new Vendedor(
                            event.getSucursalBrujulaId(),
                            event.getVendedorId(),
                            event.getNombre(),
                            event.getEdad(),
                            event.getCelular())
            );
        });
        apply((VendedorActualizado event) -> {
            Vendedor vendedor = factura.obtenerVendedorPorId(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("No existe un vendedor con ID " + event.getEntityId()));
            vendedor.actualizarNombre(event.getNombre());
            vendedor.actualizarEdad(event.getEdad());
            vendedor.actualizarCelular(event.getCelular());
        });
        apply((ClienteActualizado event) -> {
            factura.cliente.actualizarNombre(event.getNombre());
            factura.cliente.actualizarEdad(event.getEdad());
            factura.cliente.actualizarCelular(event.getCelular());
            factura.cliente.actualizarEmail(event.getEmail());
        });

        apply((DetalleAgregado event) -> {
            factura.detalles.add(
                    new Detalle(event.getEntityId(),
                            event.getDeporte(),
                            event.getCantidadCupos()
                    )
            );
        });

        apply((CantidadCuposActualizado event) -> {
            Detalle detalle = Factura.obtenerDetallePorId(event.getEntityId()).orElseThrow(
                    () -> new IllegalArgumentException("No existe un detalle con ID" + event.getEntityId()));
            detalle.actualizarCantidadCupos(event.getCantidadCupos());

        });

        apply((CostoFinalCalculado event) -> {
            factura.costoFinal = event.getCostoFinal();
        });

        apply((PromocionAsignada event) -> {
            factura.promocion = event.getPromocion();
        });

    }
}
