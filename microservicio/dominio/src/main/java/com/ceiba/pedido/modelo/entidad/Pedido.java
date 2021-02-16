package com.ceiba.pedido.modelo.entidad;

import com.ceiba.producto.modelo.entidad.Producto;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Pedido {

    private static final String SE_DEBE_INGRESAR_EL_EMAIl = "Se debe ingresar el correo electrónico";
    private static final String SE_DEBE_INGRESAR_UN_EMAIL_VALIDO     = "Se debe ingresar un correo electrónico válido";
    private static final String SE_DEBEN_INGRESAR_NOMBRES_Y_APELLIDOS = "Se debe ingresar nombres y apellidos";
    private static final String SE_DEBEN_ELEGIR_PRODUCTOS = "Se debe elegir al menos un producto";
    private static final String SE_DEBE_INGRESAR_PERSONA_QUE_RECIBE = "Se debe ingresar la persona que recibe";
    private static final String SE_DEBE_INGRESAR_LA_DIRECCION_DE_ENTREGA = "Se debe ingresar la dirección de entrega";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_CELULAR = "Se debe ingresar el número de celular";
    private static final String SE_DEBE_INGRESAR_VALORES_NUMERICOS = "Se debe ingresar valores numericos";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_ENTREGA = "Se debe ingresar la fecha de entrega";
    private static final String SE_DEBE_INGRESAR_FECHA_ENTREGA_MAYOR_A_FECHA_ACTUAL = "La fecha de entrega debe ser mayor a la fecha actual";
    private static final String REGEX = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";

    private Long id;
    private String email;
    private String nombresApellidos;
    private List<Producto> producto;
    private String envia;
    private String recibe;
    private String direccion;
    private String barrio;
    private String celular;
    private String mensaje;
    private Double domicilioZona;
    private Double subtotalProductos;
    private Double total;
    private LocalDateTime fechaPedido;
    private LocalDate fechaEntrega;
    private String estado;

    public Pedido(Long id, String email, String nombresApellidos, List<Producto> producto, String envia, String recibe, String direccion,
                  String barrio, String celular, String mensaje, Double domicilioZona, LocalDate fechaEntrega) {
        validarObligatorio(email,SE_DEBE_INGRESAR_EL_EMAIl);
        validarRegex(email,REGEX, SE_DEBE_INGRESAR_UN_EMAIL_VALIDO);
        validarObligatorio(nombresApellidos,SE_DEBEN_INGRESAR_NOMBRES_Y_APELLIDOS);
        validarNoVacio(producto, SE_DEBEN_ELEGIR_PRODUCTOS);
        validarObligatorio(recibe,SE_DEBE_INGRESAR_PERSONA_QUE_RECIBE);
        validarObligatorio(direccion,SE_DEBE_INGRESAR_LA_DIRECCION_DE_ENTREGA);
        validarObligatorio(celular,SE_DEBE_INGRESAR_EL_NUMERO_DE_CELULAR);
        validarNumerico(celular, SE_DEBE_INGRESAR_VALORES_NUMERICOS);
        validarObligatorio(fechaEntrega,SE_DEBE_INGRESAR_LA_FECHA_DE_ENTREGA);
        validarMenor(LocalDateTime.now(),fechaEntrega.atStartOfDay(), SE_DEBE_INGRESAR_FECHA_ENTREGA_MAYOR_A_FECHA_ACTUAL);
        this.id = id;
        this.email = email;
        this.nombresApellidos = nombresApellidos;
        this.producto = producto;
        this.envia = envia;
        this.recibe = recibe;
        this.direccion = direccion;
        this.barrio = barrio;
        this.celular = celular;
        this.mensaje = mensaje;
        this.domicilioZona = domicilioZona;
        this.subtotalProductos = 0.0;
        this.total = 0.0;
        this.fechaPedido = LocalDateTime.now();
        this.fechaEntrega = fechaEntrega;
        this.estado = "GENERADO";
    }

    public void calcularSubTotal(){
        for (Producto item: this.producto){
            this.subtotalProductos += item.getPrecio() * item.getCantidad();
        }
    }

    public void calcularDomicilioTotal() {
        int month = this.fechaEntrega.getMonthValue();
        int year = this.fechaEntrega.getYear();
        int day = this.fechaEntrega.getDayOfMonth();

        String url = "https://holidays.abstractapi.com/v1/?api_key=93693915bbb74c2991519130aa292982&country=CO"+"&year="+year+"&month="+month+"&day="+day;
        String respuesta = "";

        try {
            respuesta = peticionHttpGet(url);
            if (!respuesta.equals("[]")){
                this.domicilioZona = this.domicilioZona + 10000;
            }
        } catch (Exception e) {
            // Manejar excepción
            e.printStackTrace();
        }
    }

    public void calcularTotal(){
        this.total = this.subtotalProductos + this.domicilioZona;
    }

    private String peticionHttpGet(String urlParaVisitar) throws Exception {
        // Esto es lo que vamos a devolver
        StringBuilder resultado = new StringBuilder();
        // Crear un objeto de tipo URL
        URL url = new URL(urlParaVisitar);

        // Abrir la conexión e indicar que será de tipo GET
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        // Búferes para leer
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }
        // Cerrar el BufferedReader
        rd.close();
        // Regresar resultado, pero como cadena, no como StringBuilder
        return resultado.toString();
    }

}
