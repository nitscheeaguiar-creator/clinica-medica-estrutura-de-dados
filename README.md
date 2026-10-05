# Sistema de Gerenciamento de Clínica Médica

## Aluno

Nitsche Aguiar Araujo dos Santos

## Disciplina

Estrutura de Dados I

## Instituição

Centro Universitário Alves Faria — UNIALFA

## Professor

George Mendes Marra

## Tema

Sistema de Gerenciamento de Clínica Médica

## Descrição

Programa de console em Java que simula o cadastro de pacientes de uma clínica médica. O objetivo é praticar as estruturas de dados vistas na primeira etapa da disciplina: Array, Enum e Pilha, integradas em um único programa com menu.

## Estruturas utilizadas

- **Array**: os pacientes ficam em um array `Paciente[]` (capacidade de 100) na classe `Main`. Ele é usado para criação, inserção (cadastro), percurso (listagem), busca sequencial por nome e ordenação por seleção (*selection sort*).
- **Enum**: `Especialidade` (Clínica Geral, Cardiologia, Dermatologia, Ortopedia e Pediatria) define a especialidade de cada paciente e é mostrada no menu de cadastro.
- **Pilha**: a classe `Pilha` (própria, baseada em array) guarda o histórico de operações do sistema (cadastros e ordenações). Possui `empilhar` (push), `desempilhar` (pop), `consultarTopo` (peek) e `estaVazia`. A última operação fica no topo (LIFO).
- **Métodos/modularização**: cada opção do menu chama um método próprio (`cadastrarPaciente`, `listarPacientes`, `buscarPaciente`, `ordenarPacientes`, `mostrarTopoPilha`, `desempilharOperacao`), e o `main()` só controla o laço do menu.

## Funcionamento

Pelo menu o usuário pode:

1. Cadastrar paciente (nome, idade e especialidade);
2. Listar todos os pacientes;
3. Buscar paciente pelo nome (ou parte dele);
4. Ordenar pacientes por nome;
5. Ver o topo da pilha de operações;
6. Desempilhar a última operação (remove apenas o registro do histórico, não o paciente);
0. Sair.

## Como executar

Na pasta do projeto (`clinica-medica`), execute:

```
javac -encoding UTF-8 -d bin src/*.java
java -cp bin Main
```

No Windows, se os acentos aparecerem errados no terminal, rode antes `chcp 65001`.

## Conteúdos da ementa cobertos até o momento

- Array
- Enum
- Pilha
- Programação modular (início)

## Observação

Esta é a **primeira etapa (N1)** do Projeto de Estrutura de Dados. Os demais itens da ementa (lista, fila, recursividade e os módulos em C) serão desenvolvidos na N2.
