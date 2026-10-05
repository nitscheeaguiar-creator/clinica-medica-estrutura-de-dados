
public class Paciente {
    private int id;
    private String nome;
    private int idade;
    private Especialidade especialidade;

    public Paciente(int id, String nome, int idade, Especialidade especialidade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.especialidade = especialidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return String.format("ID: %-3d | Nome: %-20s | Idade: %-3d | Especialidade: %s",
                id, nome, idade, especialidade.getDescricao());
    }
}
