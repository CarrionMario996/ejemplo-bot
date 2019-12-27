package cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.core.MediaType;

import entity.Conductor;
import entity.Vehiculo;

public class CreacionConductorVehiculo {
	Conductor c = new Conductor();
	Vehiculo v = new Vehiculo();

	public String guardarConductorVehiculo(String telefono1,String dui1,String placa1) {
		String resultado = "";
		try {
			URL url = new URL("http://localhost:8080/RIDE-WS-DEV/api/driver/guardarDatos?placa=" +placa1
					+ "&marca=" + "toyota" + "&modelo=" +"antra" + "&color=" +"rojo" + "&fecha="
					+ "2019" + "&id_tipo_vehiculo=" +1+ "&nombre=" + "Henry"
					+ "&apellido=" + "Cortez" + "&dui=" + dui1 + "&numLicencia=" + "0123456789"
					+ "&direccion=" + "zaragoza" + "&id_municipio=" +5 + "&email="
					+ "correo@gmail.com" + "&telefono=" + telefono1 + "&estado=" + 1);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");

			conn.setRequestProperty("Accept", MediaType.APPLICATION_JSON);
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String output;
			while ((output = br.readLine()) != null) {
				resultado = output;
			}
		} catch (Exception e) {
			System.out.println("error insertar datos " + e);
		}
		return resultado;
	}
}
