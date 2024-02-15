package Aluno;

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
}
