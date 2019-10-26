package challenge;

public class Frase {

    private String frase = new String();
    private final int inicioRange = 97;
    private final int fimRange = 122;
    private int numeroCasas = 3;
    StringBuilder fraseFinal = new StringBuilder();


    public String criptografar() {

        for (int i = 0; i < frase.length(); i++) {

            char charactereAtual = frase.charAt(i);
            int charConvertido = converteEmASCII(frase.charAt(i));

            if (validaCharacterDentroRangeLimite(charactereAtual) && validaExtrapolacaoSuperiorTabelaASCII(charactereAtual)) {

                fraseFinal.append((char) (inicioRange + verificaExtrapolacaoSuperiorTabelaASCII(charConvertido)));

            } else if (validaCharacterDentroRangeLimite(charactereAtual) && !validaExtrapolacaoSuperiorTabelaASCII(charactereAtual)) {

                fraseFinal.append((char) (charConvertido + numeroCasas));

            } else {

                fraseFinal.append(charactereAtual);

            }
        }

        return fraseFinal.toString();
    }

    public String descriptografar() {

        for (int i = 0; i < frase.length(); i++) {

            char charactereAtual = frase.charAt(i);
            int charConvertido = converteEmASCII(frase.charAt(i));

            if (validaCharacterDentroRangeLimite(charactereAtual) && validaExtrapolacaoInferiorTabelaASCII(charactereAtual)) {

                fraseFinal.append((char) (fimRange - verificaExtrapolacaoInferiorTabelaASCII(charConvertido)));

            } else if (validaCharacterDentroRangeLimite(charactereAtual) && !validaExtrapolacaoInferiorTabelaASCII(charactereAtual)) {

                fraseFinal.append((char) (charConvertido - numeroCasas));

            } else {

                fraseFinal.append(charactereAtual);

            }
        }

        return fraseFinal.toString();
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase.toLowerCase();
    }

    public int getNumeroCasas() {
        return numeroCasas;
    }

    public void setNumetoCasas(int numeroCasas) {
        this.numeroCasas = numeroCasas;
    }

    private boolean validaCharacterDentroRangeLimite(char c) {

        int numeroASCII = ((int) c);

        return (numeroASCII >= inicioRange && (int) numeroASCII <= fimRange);

    }

    private boolean validaExtrapolacaoSuperiorTabelaASCII(char c) {

        int numeroASCII = ((int) c);

        return (numeroASCII + numeroCasas > fimRange);
    }

    private boolean validaExtrapolacaoInferiorTabelaASCII(char c) {

        int numeroASCII = ((int) c);

        return (numeroASCII - numeroCasas < inicioRange);

    }

    private int converteEmASCII(char c) {

        return ((int) c);

    }

    private int verificaExtrapolacaoSuperiorTabelaASCII(int i) {

        int numeroExtrapolado = 0;

        if (i + numeroCasas > fimRange) {

            numeroExtrapolado = (i + numeroCasas - fimRange);

        }

        return numeroExtrapolado;
    }

    private int verificaExtrapolacaoInferiorTabelaASCII(int i) {

        int numeroExtrapolado = 0;

        if (i - numeroCasas < inicioRange) {

            numeroExtrapolado = (inicioRange - (i - numeroCasas));

        }

        return numeroExtrapolado;
    }

    public StringBuilder getFraseFinal() {
        return fraseFinal;
    }

    public void setFraseFinal(StringBuilder fraseFinal) {
        this.fraseFinal = fraseFinal;
    }
}

