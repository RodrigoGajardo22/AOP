package aop.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import aop.domain.Time;
import aop.domain.portsin.User;
import aop.domain.portsin.Users;
import aop.domain.portsout.Registro;
import generadorNombresRandom.GeneradorNombre;

@RestController
public class UserController {

	private Users    users;
	private Registro registro;

	public UserController(Users users, Registro registro) {
		this.users    = users;
		this.registro = registro;
	}

	@GetMapping("/users")
	public List<User> allUsers() {
		return this.users.users();
	}

	@GetMapping("/users/{id}")
	public User usersById(@PathVariable int id) {
		return this.users.userById(id);
	}

	@GetMapping("/users/search/{username}")
	public User usersByName(@PathVariable String username) {
		return this.users.usersByName(username);
	}

	@GetMapping("/darDeAlta10")
	@Time
	public void darDeAlta10() {

		List<String> listaDeNombres = generarNombres(10);
		listaDeNombres.forEach(datos -> registro.insertar(datos));

	}

	@GetMapping("/darDeAlta100")
	@Time
	public void darDeAlta100() {

		List<String> listaDeNombres = generarNombres(100);
		listaDeNombres.forEach(datos -> registro.insertar(datos));

	}

	private List<String> generarNombres(int cant) {

		GeneradorNombre gn      = new GeneradorNombre();
		List<String>    nombres = new ArrayList<String>();

		while (cant > 0) {
			nombres.add(gn.crearNombre(10));
			cant--;
		}

		return nombres;
	}

}
