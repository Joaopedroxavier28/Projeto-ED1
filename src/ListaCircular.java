public class ListaCircular {
    private Evento head;

    // Inserir evento
    public void inserirEvento(String nome, String data, String local, int capacidade) {
        Evento novoEvento = new Evento(nome, data, local, capacidade);
        if (head == null) {
            head = novoEvento;
            head.proximo = head;
        } else {
            Evento atual = head;
            while (atual.proximo != head) {
                atual = atual.proximo;
            }
            atual.proximo = novoEvento;
            novoEvento.proximo = head;
        }
    }

    // Remover evento
    public void removerEvento(String nome) {
        if (head == null) return;

        if (head.nome.equals(nome) && head.proximo == head) {
            head = null;
            return;
        }

        Evento atual = head;
        Evento anterior = null;

        do {
            if (atual.nome.equals(nome)) {
                if (anterior != null) {
                    anterior.proximo = atual.proximo;
                } else {
                    Evento temp = head;
                    while (temp.proximo != head) {
                        temp = temp.proximo;
                    }
                    head = atual.proximo;
                    temp.proximo = head;
                }
                return;
            }
            anterior = atual;
            atual = atual.proximo;
        } while (atual != head);
    }

    // Buscar evento
    public Evento buscarEvento(String nome) {
        Evento atual = head;
        if (head == null) return null;

        do {
            if (atual.nome.equals(nome)) {
                return atual;
            }
            atual = atual.proximo;
        } while (atual != head);

        return null;
    }

    // Exibir eventos
    public void exibirEventos() {
        if (head == null) return;

        Evento atual = head;
        do {
            System.out.println("Nome: " + atual.nome + ", Data: " + atual.data + ", Local: " + atual.local + ", Capacidade: " + atual.capacidade);
            atual = atual.proximo;
        } while (atual != head);
    }
}
