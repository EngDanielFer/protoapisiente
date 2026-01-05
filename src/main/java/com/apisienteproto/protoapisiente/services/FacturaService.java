package com.apisienteproto.protoapisiente.services;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apisienteproto.protoapisiente.models.Factura;
import com.apisienteproto.protoapisiente.models.FacturaDTO;
import com.apisienteproto.protoapisiente.models.FacturaResponseDTO;
import com.apisienteproto.protoapisiente.models.ProductoFacturaDTO;
import com.apisienteproto.protoapisiente.repositories.FacturaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class FacturaService {

    private final FacturaRepository facturaRepository;
    private final EntityManager entityManager;
    private final ObjectMapper objectMapper;

    // public FacturaService(FacturaRepository facturaRepository) {
    //     this.facturaRepository = facturaRepository;
    // }
    // @Transactional
    // public int crearfactura(FacturaRequestDTO request) throws Exception {
    //     return facturaRepository.insertarFactura(
    //             request.getNombreCliente(),
    //             request.getApellidoCliente(),
    //             request.getEmailCliente(),
    //             request.getDireccionCliente(),
    //             request.getComplementoDireccion(),
    //             request.getTelefonoCliente(),
    //             request.getPaisCliente(),
    //             request.getRegionCliente(),
    //             request.getCiudadCliente(),
    //             request.getProductos(),
    //             request.getPrecioEnvio(),
    //             request.getMetodoPago()
    //     );
    // }
    @Transactional
    public FacturaResponseDTO crearFactura(FacturaDTO facturaDTO) {
        try {
            log.info("Iniciando creación de factura para cliente: {} {}",
                    facturaDTO.getDatosCliente().getNombre_cliente(),
                    facturaDTO.getDatosCliente().getApellido_cliente());

            log.debug("Datos del cliente: {}", facturaDTO.getDatosCliente());
            log.debug("Productos: {}", facturaDTO.getProductos());
            log.debug("Precio envío: {}", facturaDTO.getPrecio_envio());
            log.debug("Método pago: {}", facturaDTO.getMetodo_pago());

            String productosJson = convertirProductrosAJson(facturaDTO.getProductos());
            log.debug("JSON de productos generado: {}", productosJson);

            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("p_insertar_factura");

            query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);  // n_cliente
            query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);  // ap_cliente
            query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);  // mail_cliente
            query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);  // direcc_cliente
            query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);  // comp_direcc_cliente
            query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);  // telef_cliente
            query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);  // country_cliente
            query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);  // reg_cliente
            query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);  // city_cliente
            query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN); // lista_productos
            query.registerStoredProcedureParameter(11, BigDecimal.class, ParameterMode.IN); // envio_cliente
            query.registerStoredProcedureParameter(12, String.class, ParameterMode.IN); // pago_cliente
            query.registerStoredProcedureParameter(13, String.class, ParameterMode.IN); // tipo_precio
            query.registerStoredProcedureParameter(14, Integer.class, ParameterMode.OUT); // out_id_factura

            String complemento = facturaDTO.getDatosCliente().getComplemento_direccion();
            if (complemento == null || complemento.trim().isEmpty()) {
                complemento = null;
            }

            query.setParameter(1, facturaDTO.getDatosCliente().getNombre_cliente());
            query.setParameter(2, facturaDTO.getDatosCliente().getApellido_cliente());
            query.setParameter(3, facturaDTO.getDatosCliente().getEmail_cliente());
            query.setParameter(4, facturaDTO.getDatosCliente().getDireccion_cliente());
            query.setParameter(5, complemento);
            query.setParameter(6, facturaDTO.getDatosCliente().getTelefono_cliente());
            query.setParameter(7, facturaDTO.getDatosCliente().getPais_cliente());
            query.setParameter(8, facturaDTO.getDatosCliente().getRegion_cliente());
            query.setParameter(9, facturaDTO.getDatosCliente().getCiudad_cliente());
            query.setParameter(10, productosJson);
            query.setParameter(11, facturaDTO.getPrecio_envio());
            query.setParameter(12, facturaDTO.getMetodo_pago());
            query.setParameter(13, facturaDTO.getTipo_precio());

            log.info("Ejecutando procedimiento almacenado...");

            query.execute();

            Integer idFactura = (Integer) query.getOutputParameterValue(14);

            if (idFactura == null) {
                throw new RuntimeException("El procedimiento no retornó un ID de factura");
            }

            log.info("Factura creada exitosamente con ID: {}", idFactura);

            Factura factura = facturaRepository.findById(idFactura)
                    .orElseThrow(() -> new RuntimeException("Error al recuperar la factura creada"));

            return new FacturaResponseDTO(
                    idFactura,
                    "Factura creada exitosamente",
                    factura.getValorTotal(),
                    factura.getValorPagado(),
                    factura.getPrecioEnvio()
            );
        } catch (Exception e) {
            log.error("Error al crear factura: {}", e.getMessage(), e);

            String errorMessage = e.getMessage();
            if (errorMessage != null) {
                if (errorMessage.contains("[")) {
                    int startIndex = errorMessage.indexOf("[") + 1;
                    int endIndex = errorMessage.indexOf("]", startIndex);
                    if (endIndex > startIndex) {
                        errorMessage = errorMessage.substring(startIndex, endIndex);
                    }
                }
            }
            throw new RuntimeException(errorMessage != null ? errorMessage : "Error al procesar la factura", e);
        }
    }

    private String convertirProductrosAJson(List<ProductoFacturaDTO> productos) {
        try {
            List<Map<String, Object>> productosMap = productos.stream()
                    .map(p -> {
                        Map<String, Object> map = new HashMap<>();
                        map.put("id_producto", p.getId_producto());
                        map.put("cantidad_producto", p.getCantidad_producto());
                        return map;
                    })
                    .collect(Collectors.toList());
            return objectMapper.writeValueAsString(productosMap);
        } catch (JsonProcessingException e) {
            log.error("Error al convertir productos a JSON: {}", e.getMessage());
            throw new RuntimeException("Error al procesar los productos", e);
        }
    }

    public Factura obtenerFactura(Integer id) {
        log.info("Buscando factura con ID: {}", id);
        return facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada con ID: " + id));
    }

    public List<Factura> obtenerTodasFacturas() {
        log.info("Obteniendo todas las facturas");
        return facturaRepository.findAllOrderByFechaDesc();
    }

    public List<Factura> obtenerFacturasPorEmail(String email) {
        log.info("Buscando facturas para email: {}", email);
        return facturaRepository.findByEmailCliente(email);
    }

}
