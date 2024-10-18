import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);

    
    static Map<String, Integer> eventosCapacidade = new HashMap<>();
    static Map<String, Integer> frequenciaPedidos = new HashMap<>();
    static Map<String, Integer> frequenciaLocais = new HashMap<>();
    static Map<String, Integer> frequenciaDatasConsultas = new HashMap<>();
    static Map<String, Integer> frequenciaDoencas = new HashMap<>();

    public static void main(String[] args) {
        ListaSimples listaPacientes = new ListaSimples();
        ListaDupla listaPedidos = new ListaDupla();
        ListaCircular listaEventos = new ListaCircular();

        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Gerenciar Clínica Médica");
            System.out.println("2. Gerenciar Restaurante");
            System.out.println("3. Gerenciar Eventos");
            System.out.println("4. Estatísticas");
            System.out.println("0. Sair");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    menuClinica(listaPacientes);
                    break;
                case 2:
                    menuRestaurante(listaPedidos);
                    break;
                case 3:
                    menuEventos(listaEventos);
                    break;
                case 4:
                    exibirEstatisticas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // Menu Clínica
    public static void menuClinica(ListaSimples listaPacientes) {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Clínica ---");
            System.out.println("1. Inserir Paciente");
            System.out.println("2. Remover Paciente");
            System.out.println("3. Buscar Paciente");
            System.out.println("4. Atualizar Última Consulta");
            System.out.println("5. Exibir Pacientes");
            System.out.println("0. Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Histórico Médico: ");
                    String historicoMedico = scanner.nextLine();
                    System.out.print("Última Consulta (yyyy-mm-dd): ");
                    String ultimaConsulta = scanner.nextLine();

                    // Atualizar frequências
                    frequenciaDatasConsultas.put(ultimaConsulta, frequenciaDatasConsultas.getOrDefault(ultimaConsulta, 0) + 1);
                    frequenciaDoencas.put(historicoMedico, frequenciaDoencas.getOrDefault(historicoMedico, 0) + 1);

                    listaPacientes.inserirPaciente(nome, idade, historicoMedico, ultimaConsulta);
                    break;
                case 2:
                    System.out.print("Nome do paciente a remover: ");
                    String nomeRemover = scanner.nextLine();
                    listaPacientes.removerPaciente(nomeRemover);
                    break;
                case 3:
                    System.out.print("Nome do paciente a buscar: ");
                    String nomeBuscar = scanner.nextLine();
                    Paciente paciente = listaPacientes.buscarPaciente(nomeBuscar);
                    if (paciente != null) {
                        System.out.println("Paciente encontrado: " + paciente.nome + ", Idade: " + paciente.idade + ", Última Consulta: " + paciente.ultimaConsulta);
                    } else {
                        System.out.println("Paciente não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Nome do paciente: ");
                    String nomeAtualizar = scanner.nextLine();
                    System.out.print("Nova data da consulta (yyyy-mm-dd): ");
                    String novaConsulta = scanner.nextLine();
                    listaPacientes.atualizarUltimaConsulta(nomeAtualizar, novaConsulta);
                    break;
                case 5:
                    listaPacientes.exibirPacientes();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // Menu Restaurante
    public static void menuRestaurante(ListaDupla listaPedidos) {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Restaurante ---");
            System.out.println("1. Inserir Pedido");
            System.out.println("2. Remover Pedido");
            System.out.println("3. Buscar Pedido");
            System.out.println("4. Atualizar Pedido");
            System.out.println("5. Exibir Pedidos");
            System.out.println("0. Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Descrição do pedido: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Total: ");
                    double total = scanner.nextDouble();

                    // Atualizar frequências
                    frequenciaPedidos.put(descricao, frequenciaPedidos.getOrDefault(descricao, 0) + 1);

                    listaPedidos.inserirPedido(descricao, quantidade, total);
                    break;
                case 2:
                    System.out.print("Descrição do pedido a remover: ");
                    String descricaoRemover = scanner.nextLine();
                    listaPedidos.removerPedido(descricaoRemover);
                    break;
                case 3:
                    System.out.print("Descrição do pedido a buscar: ");
                    String descricaoBuscar = scanner.nextLine();
                    Pedido pedido = listaPedidos.buscarPedido(descricaoBuscar);
                    if (pedido != null) {
                        System.out.println("Pedido encontrado: " + pedido.descricao + ", Quantidade: " + pedido.quantidade + ", Total: " + pedido.total);
                    } else {
                        System.out.println("Pedido não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Descrição do pedido: ");
                    String descricaoAtualizar = scanner.nextLine();
                    System.out.print("Nova Quantidade: ");
                    int novaQuantidade = scanner.nextInt();
                    System.out.print("Novo Total: ");
                    double novoTotal = scanner.nextDouble();
                    listaPedidos.atualizarPedido(descricaoAtualizar, novaQuantidade, novoTotal);
                    break;
                case 5:
                    listaPedidos.exibirPedidos();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // Menu Eventos
    public static void menuEventos(ListaCircular listaEventos) {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Eventos ---");
            System.out.println("1. Inserir Evento");
            System.out.println("2. Remover Evento");
            System.out.println("3. Buscar Evento");
            System.out.println("4. Exibir Eventos");
            System.out.println("0. Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome do evento: ");
                    String nomeEvento = scanner.nextLine();
                    System.out.print("Data (yyyy-mm-dd): ");
                    String dataEvento = scanner.nextLine();
                    System.out.print("Local: ");
                    String localEvento = scanner.nextLine();
                    System.out.print("Capacidade: ");
                    int capacidade = scanner.nextInt();

                    // Atualizar frequências
                    frequenciaLocais.put(localEvento, frequenciaLocais.getOrDefault(localEvento, 0) + 1);
                    eventosCapacidade.put(nomeEvento, capacidade);

                    listaEventos.inserirEvento(nomeEvento, dataEvento, localEvento, capacidade);
                    break;
                case 2:
                    System.out.print("Nome do evento a remover: ");
                    String nomeRemover = scanner.nextLine();
                    listaEventos.removerEvento(nomeRemover);
                    break;
                case 3:
                    System.out.print("Nome do evento a buscar: ");
                    String nomeBuscar = scanner.nextLine();
                    Evento evento = listaEventos.buscarEvento(nomeBuscar);
                    if (evento != null) {
                        System.out.println("Evento encontrado: " + evento.nome + ", Data: " + evento.data + ", Local: " + evento.local + ", Capacidade: " + evento.capacidade);
                    } else {
                        System.out.println("Evento não encontrado.");
                    }
                    break;
                case 4:
                    listaEventos.exibirEventos();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // Exibir Estatísticas
    public static void exibirEstatisticas() {
        System.out.println("\n--- Estatísticas ---");

        // Evento com maior capacidade
        String eventoMaiorCapacidade = eventosCapacidade.entrySet().stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("Nenhum evento");
        System.out.println("Evento com maior capacidade: " + eventoMaiorCapacidade);

        // Pedido mais frequente
        String pedidoMaisFrequente = frequenciaPedidos.entrySet().stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("Nenhum pedido");
        System.out.println("Pedido mais frequente: " + pedidoMaisFrequente);

        // Local mais utilizado para eventos
        String localMaisUtilizado = frequenciaLocais.entrySet().stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("Nenhum local");
        System.out.println("Local mais utilizado para eventos: " + localMaisUtilizado);

        // Data com mais consultas
        String dataMaisConsultas = frequenciaDatasConsultas.entrySet().stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("Nenhuma data");
        System.out.println("Data com mais consultas: " + dataMaisConsultas);

        // Doença mais frequente
        String doencaMaisFrequente = frequenciaDoencas.entrySet().stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("Nenhuma doença");
        System.out.println("Doença mais frequente: " + doencaMaisFrequente);
    }
}
