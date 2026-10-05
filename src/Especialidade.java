
public enum Especialidade {
    CLINICA_GERAL("Clínica Geral"),
    CARDIOLOGIA("Cardiologia"),
    DERMATOLOGIA("Dermatologia"),
    ORTOPEDIA("Ortopedia"),
    PEDIATRIA("Pediatria");

    private final String descricao;

    Especialidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
