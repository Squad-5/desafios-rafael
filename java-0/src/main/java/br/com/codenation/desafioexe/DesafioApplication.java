package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

import br.com.codenation.TestadorFibonacci;
import br.com.codenation.annotation.Desafio;

public class DesafioApplication {

	public static void main(String[] args) {
		new TestadorFibonacci().testaDesafio(DesafioApplication.class);
	}

	@Desafio("Fibonacci")
	public static List<Integer> fibonacci() {

		List<Integer> numeros = new ArrayList<>();

		int i = 0;
		int j = 1;
		int t;

		numeros.add(i);


		do{
			t = i + j;
			i = j;
			j = t;
			numeros.add(i);

		} while (t < 350);

		return numeros;
	}

	@Desafio("isFibonacci")
	public static Boolean isFibonacci(Integer a) {

		return fibonacci().contains(a);
	}

}
