package aop.domain;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import aop.domain.portsout.Registro;

@Component
@ComponentScan
public class ABMPersona {

	private Registro registro;

	public ABMPersona(Registro registro) {
		this.registro = registro;
	}

	public void darDeAlta(String datos, int cant) {

		for (int i = 0; i < cant; i++) {
			registro.insertar((i + 1) + " " + datos);
		}

	}
}
