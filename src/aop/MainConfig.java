package aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import aop.domain.portsout.Registro;
import aop.infraestructure.data.RegistroPersonas;

@Configuration
public class MainConfig {

	@Bean
	public Registro registro() {
		String ruta = "C:\\Users\\Usuario\\Documents\\2 - UNIVERSIDAD RODRI\\Orientacion a Objetos 2\\Persistencia\\Personas.txt";
		return new RegistroPersonas(ruta);
	}

}
