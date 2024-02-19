package Aluno;

import java.util.Arrays;

public enum EnumStatusMatricula {
    ATIVO("A"),
    TRANCADO("T"),
    FORMADO("F");
    private final String sigla;
    EnumStatusMatricula(String sigla) {
        this.sigla = sigla;
    }

    public String getSigla() {
        return this.sigla;
    }

    public static EnumStatusMatricula getStatusBySigla(final String sigla){
        return Arrays.stream(values())
                .filter(value -> value.getSigla().equals(sigla))
                .findFirst()
                .orElseThrow();
    }
}
