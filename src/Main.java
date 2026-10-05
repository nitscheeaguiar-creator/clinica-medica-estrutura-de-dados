import java.util.Scanner;


public class Main {

    private static final int CAPACIDADE_PACIENTES = 100;
    private static final int CAPACIDADE_HISTORICO = 100;

 
    private static Paciente[] pacientes = new Paciente[CAPACIDADE_PACIENTES];
    private static int quantidadePacientes = 0;
    private static int proximoId = 1;

    
    private static Pilha historico = new Pilha(CAPACIDADE_HISTORICO);

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");
            executarOpcao(opcao);
        } while (opcao != 0);
    }

   

    private static void exibirMenu() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("             CLÍNICA MÉDICA");
        System.out.println("========================================");
        System.out.println("1 - Cadastrar paciente");
        System.out.println("2 - Listar pacientes");
        System.out.println("3 - Buscar paciente");
        System.out.println("4 - Ordenar pacientes por nome");
        System.out.println("5 - Ver topo da pilha");
        System.out.println("6 - Desempilhar última operação");
        System.out.println("0 - Sair");
        System.out.println();
    }

    private static void executarOpcao(int opcao) {
        switch (opcao) {
            case 1: cadastrarPaciente(); break;
            case 2: listarPacientes(); break;
            case 3: buscarPaciente(); break;
            case 4: ordenarPacientes(); break;
            case 5: mostrarTopoPilha(); break;
            case 6: desempilharOperacao(); break;
            case 0: System.out.println("Encerrando o sistema. Até logo!"); break;
            default: System.out.println("Opção inválida. Tente novamente.");
        }
    }

   

    private static void cadastrarPaciente() {
        if (quantidadePacientes == pacientes.length) {
            System.out.println("Não há mais espaço para cadastrar pacientes.");
            return;
        }

        System.out.print("Nome: ");
        String nome = teclado.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("O nome não pode ficar vazio.");
            return;
        }

        int idade = lerInteiro("Idade: ");
        if (idade < 0 || idade > 130) {
            System.out.println("Idade inválida.");
            return;
        }

        Especialidade especialidade = escolherEspecialidade();

        Paciente novo = new Paciente(proximoId, nome, idade, especialidade);
        pacientes[quantidadePacientes] = novo; 
        quantidadePacientes++;
        proximoId++;

        registrarOperacao("CADASTRO: " + nome);
        System.out.println("Paciente cadastrado com sucesso! (ID " + novo.getId() + ")");
    }

    private static void listarPacientes() {
        if (quantidadePacientes == 0) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }
        System.out.println("--- Pacientes cadastrados ---");
        for (int i = 0; i < quantidadePacientes; i++) { 
            System.out.println(pacientes[i]);
        }
    }

    
    private static void buscarPaciente() {
        System.out.print("Digite o nome (ou parte dele): ");
        String termo = teclado.nextLine().trim().toLowerCase();

        boolean encontrou = false;
        for (int i = 0; i < quantidadePacientes; i++) {
            if (pacientes[i].getNome().toLowerCase().contains(termo)) {
                if (!encontrou) {
                    System.out.println("--- Resultado da busca ---");
                }
                System.out.println(pacientes[i]);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum paciente encontrado.");
        }
    }

    /** Ordenação por seleção (selection sort), crescente por nome. */
    private static void ordenarPacientes() {
        if (quantidadePacientes < 2) {
            System.out.println("É preciso ter pelo menos 2 pacientes para ordenar.");
            return;
        }

        for (int i = 0; i < quantidadePacientes - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < quantidadePacientes; j++) {
                if (pacientes[j].getNome().compareToIgnoreCase(pacientes[menor].getNome()) < 0) {
                    menor = j;
                }
            }
            trocar(i, menor);
        }

        registrarOperacao("ORDENACAO: pacientes por nome");
        System.out.println("Pacientes ordenados por nome.");
        listarPacientes();
    }

    private static void trocar(int a, int b) {
        Paciente temporario = pacientes[a];
        pacientes[a] = pacientes[b];
        pacientes[b] = temporario;
    }


    private static Especialidade escolherEspecialidade() {
        Especialidade[] opcoes = Especialidade.values();
        System.out.println("Especialidade:");
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println("  " + (i + 1) + " - " + opcoes[i].getDescricao());
        }

        int escolha;
        do {
            escolha = lerInteiro("Escolha a especialidade: ");
        } while (escolha < 1 || escolha > opcoes.length);

        return opcoes[escolha - 1];
    }

  

    private static void registrarOperacao(String descricao) {
        if (!historico.empilhar(descricao)) {
            System.out.println("Aviso: histórico cheio, operação não registrada.");
        }
    }

    private static void mostrarTopoPilha() {
        String topo = historico.consultarTopo();
        if (topo == null) {
            System.out.println("A pilha está vazia.");
        } else {
            System.out.println("Topo da pilha: " + topo);
            System.out.println("Operações na pilha: " + historico.tamanho());
        }
    }

    private static void desempilharOperacao() {
        String removida = historico.desempilhar();
        if (removida == null) {
            System.out.println("A pilha está vazia.");
        } else {
            System.out.println("Operação removida da pilha: " + removida);
            System.out.println("(Apenas o registro do histórico é removido; os pacientes continuam cadastrados.)");
        }
    }

    

  
    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String linha = teclado.nextLine().trim();
            try {
                return Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }
}
