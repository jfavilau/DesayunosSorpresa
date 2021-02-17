package com.ceiba.pedido.adaptador.repositorio;

import com.ceiba.infraestructura.excepcion.ExcepcionTecnica;
import com.ceiba.pedido.puerto.repositorio.IRepositorioFestivosColombia;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

@Repository
public class RepositorioFestivosColombia implements IRepositorioFestivosColombia {
    
    private static final String HOST =  "https://holidays.abstractapi.com/v1/";
    private static final String LLAVE_API= "93693915bbb74c2991519130aa292982";
    private static final String PAIS = "CO";

    @Override
    public boolean validarDiaFestivo(LocalDate fechaEntrega) {
        int mes = fechaEntrega.getMonthValue();
        int anio = fechaEntrega.getYear();
        int dia =fechaEntrega.getDayOfMonth();

        String respuesta;

        try{
            respuesta = obtenerDiaFestivoApi(anio , mes, dia);
            if (!("[]").equals(respuesta)){
                return true;
            }
        }catch (IOException e){
            throw new ExcepcionTecnica(e.getMessage());
        }
        return false;
    }

    private String obtenerDiaFestivoApi(int anio, int mes, int dia) throws IOException {

        StringBuilder respuestaApi = new StringBuilder();

        String urlApi = HOST +
                "?api_key=" + LLAVE_API +
                "&country=" + PAIS +
                "&year=" + anio +
                "&month=" + mes +
                "&day=" + dia;

        URL url = new URL(urlApi);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        conexion.setRequestProperty("Accept", "application/json");

        BufferedReader bufferLectura = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;

        while ((linea = bufferLectura.readLine()) != null) {
            respuestaApi.append(linea);
        }

        bufferLectura.close();

        return respuestaApi.toString();
    }
}
