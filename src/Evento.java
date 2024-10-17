public class Evento {
    String nome;
    String data;
    String local;
    int capacidade;

    Evento proximo;

    Evento(String nome, String data, String local, int capacidade) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidade = capacidade;
        this.proximo = null;
    }
}
