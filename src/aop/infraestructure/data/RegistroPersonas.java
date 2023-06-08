package aop.infraestructure.data;

import java.io.File;
import java.io.FileWriter;

import org.springframework.beans.factory.annotation.Value;

import aop.domain.portsout.Registro;
import aop.domain.portsout.RegistroException;

public class RegistroPersonas implements Registro {

	private String ruta;

	public RegistroPersonas(@Value("${ruta.archivo}") String ruta) {
		this.ruta = ruta;
	}

	public String insertar(String dato) {

		try {

			File       archivo  = new File(ruta);
			FileWriter escribir = new FileWriter(archivo, true);

			escribir.write(dato);
			escribir.write("\r\n");
			escribir.close();

		} // Si existe un problema al escribir cae aqui
		catch (Exception e) {
			throw new RegistroException("Error al intentar escribir datos en Archivo.");
		}

		return dato;

	}
}
