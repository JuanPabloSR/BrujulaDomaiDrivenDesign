package co.com.sofka.Brujula.domain.registroVentas;

import co.com.sofka.Brujula.domain.factura.Factura;
import co.com.sofka.Brujula.domain.factura.entities.Detalle;
import co.com.sofka.Brujula.domain.factura.entities.Vendedor;
import co.com.sofka.Brujula.domain.factura.events.*;
import co.com.sofka.Brujula.domain.registroVentas.commands.CalcularValorTotal;
import co.com.sofka.Brujula.domain.registroVentas.entities.Documento;
import co.com.sofka.Brujula.domain.registroVentas.entities.Empleado;
import co.com.sofka.Brujula.domain.registroVentas.entities.ServiciosExtras;
import co.com.sofka.Brujula.domain.registroVentas.events.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class RegistroVentasChange extends EventChange {
    public RegistroVentasChange(RegistroVentas registroVentas) {
        apply((VentaCreada event) -> {
            registroVentas.fecha = event.getFecha();
            registroVentas.valorTotal = event.getValorTotal();
            registroVentas.empleados = new HashSet<>();
            registroVentas.serviciosExtras = new HashSet<>();
            registroVentas.documentos = new HashSet<>();
        });
        apply((DocumentoAgregado event) -> {
            registroVentas.documento = new Documento(event.getDocumentosId(), event.getCedula(), event.getSeguroRiesgos());
        });

        apply((EmpleadoActualizado event) -> {
            Empleado empleado = registroVentas.obtenerEmpleadoPorId(event.getEmpleadoId())
                    .orElseThrow(() -> new IllegalArgumentException("No existe un empleado con ID " + event.getEmpleadoId()));
            registroVentas.ActualizarNombre(event.getNombre());
            registroVentas.ActualizarCelular(event.getCelular());
            registroVentas.ActualizarCargo(event.getCargo());
        });




    }
}
