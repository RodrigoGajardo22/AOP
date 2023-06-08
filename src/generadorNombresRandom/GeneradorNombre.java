/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadorNombresRandom;

import java.util.Random;

/**
 *
 * @author Ana Teresa
 */
public class GeneradorNombre {

	private VectorManager vocales;
	private VectorManager consonantes;

	private Random        r;

	public GeneradorNombre() {
		initVector();
		initRandom();
	}

	private void initRandom() {
		r = new Random();
	}

	private void initVector() {
		char tempv[] = { 'a', 'e', 'i', 'o', 'u' };
		char tempc[] = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', '�', 'p', 'q', 'r', 's', 't', 'v', 'w',
				'x', 'y', 'z' };
		vocales     = new VectorManager(tempv);
		consonantes = new VectorManager(tempc);
	}

	/**
	 * Método que genera un número random, según el tamaño máximo
	 */
	private int generarTamanno(int maximo) {
		if (maximo <= 3) {
			return 3;
		}
		int tam = r.nextInt(maximo - 3) + 3;
		return tam;
	}

	/**
	 * Método que se encarga de formar el nombre alternando entre vocales y
	 * consonantes de manera random
	 *
	 * @param tamannoMax recibe el tamaño máximo del nombre
	 * @return el nombre formado
	 */
	public String crearNombre(int tamannoMax) {
		String nombre = "";
		tamannoMax = generarTamanno(tamannoMax);
		boolean vocal = r.nextBoolean();
		for (int i = 0; i <= tamannoMax; i++) {
			if (vocal) {
				nombre += vocales.letraRandom();
			} else {
				nombre += consonantes.letraRandom();
			}
			vocal = !vocal;
		}
		return nombre;
	}
}
