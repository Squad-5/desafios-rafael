package challenge;

public class CriptografiaCesariana implements Criptografia {

	@Override
	public String criptografar(String texto) {
		if (!texto.isEmpty() && texto != null) {

			Frase frase = new Frase();
			frase.setFrase(texto);
			return frase.criptografar();

		} else
			throw new java.lang.IllegalArgumentException();

	}

	@Override
	public String descriptografar(String texto) {
		if (!texto.isEmpty() && texto != null) {

			Frase frase = new Frase();

			frase.setFrase(texto);

			return frase.descriptografar();
		} else
			throw new java.lang.IllegalArgumentException();

	}
}
