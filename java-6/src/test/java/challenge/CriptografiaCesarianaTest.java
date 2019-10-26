package challenge;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CriptografiaCesarianaTest {


    private static final String TEXTO_CRIPTOGRAFADO = "d oljhlud udsrvd pduurp vdowrx vreuh r fdfkruur fdqvdgr";
    private static final String TEXTO_DESCRIPTOGRAFADO = "a ligeira raposa marrom saltou sobre o cachorro cansado";

    private Criptografia criptografia;

    @Before
    public void before() {
        criptografia = new CriptografiaCesariana();
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarErroQuandoOCriptografaTextoEhVazio() {
        criptografia.criptografar("");
    }

    @Test(expected = NullPointerException.class)
    public void deveRetornarErroQuandoCriptografaTextoEhNulo() {
        criptografia.criptografar(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarErroQuandoODesCriptografaTextoEhVazio() {
        criptografia.descriptografar("");
    }

    @Test(expected = NullPointerException.class)
    public void deveRetornarErroQuandoDesCriptografaTextoEhNulo() {
        criptografia.descriptografar(null);
    }

    @Test
    public void deveCriptografarTexto() {
        assertEquals(TEXTO_CRIPTOGRAFADO, criptografia.criptografar(TEXTO_DESCRIPTOGRAFADO));
    }

    @Test
    public void deveDescriptografarTexto() {
        assertEquals(TEXTO_DESCRIPTOGRAFADO, criptografia.descriptografar(TEXTO_CRIPTOGRAFADO));
    }

    @Test
    public void deveManterOsNumerosNaCriptografia() {
        String texto = "sejam bem vindos ao Acelera Brasil 2019";
        assertEquals("vhmdp ehp ylqgrv dr dfhohud eudvlo 2019", criptografia.criptografar(texto));
    }

    @Test
    public void deveManterOsNumerosNaDescriptografia() {
        String textoCifrado = "vhmdp ehp ylqgrv dr dfhohud eudvlo 2019";
        assertEquals("sejam bem vindos ao acelera brasil 2019", criptografia.descriptografar(textoCifrado));
    }

    @Test
    public void deveConverterCaracteresParaMinusculoNaCriptografia() {
        String texto = "Aprender Java gera felicidade";
        assertEquals("dsuhqghu mdyd jhud iholflgdgh", criptografia.criptografar(texto));
    }

    @Test
    public void deveConverterCaracteresParaMinusculoNaDescriptografia() {
        String textoCifrado = "Dsuhqghu Mdyd jhud iholflgdgh";
        assertEquals("aprender java gera felicidade", criptografia.descriptografar(textoCifrado));
    }
}
