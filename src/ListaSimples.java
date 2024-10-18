public class ListaSimples {
    private Paciente head;

    // Inserir paciente
    public void inserirPaciente(String nome, int idade, String historicoMedico, String ultimaConsulta) {
        Paciente novoPaciente = new Paciente(nome, idade, historicoMedico, ultimaConsulta);
        if (head == null) {
            head = novoPaciente;
        } else {
            Paciente atual = head;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoPaciente;
        }
    }

    // Remover paciente
    public void removerPaciente(String nome) {
        if (head == null) return;

        if (head.nome.equals(nome)) {
            head = head.proximo;
            return;
        }

        Paciente atual = head;
        while (atual.proximo != null && !atual.proximo.nome.equals(nome)) {
            atual = atual.proximo;
        }

        if (atual.proximo != null) {
            atual.proximo = atual.proximo.proximo;
        }
    }

    // Buscar paciente
    public Paciente buscarPaciente(String nome) {
        Paciente atual = head;
        while (atual != null) {
            if (atual.nome.equals(nome)) {
                return atual;
            }
            atual = atual.proximo;
        }
        return null;
    }

    // Atualizar última consulta
    public void atualizarUltimaConsulta(String nome, String novaConsulta) {
        Paciente paciente = buscarPaciente(nome);
        if (paciente != null) {
            paciente.ultimaConsulta = novaConsulta;
        }
    }

    // Exibir pacientes
    public void exibirPacientes() {
        Paciente atual = head;
        while (atual != null) {
            System.out.println("Nome: " + atual.nome + ", Idade: " + atual.idade + ", Última Consulta: " + atual.ultimaConsulta);
            atual = atual.proximo;
        }
    }

}

