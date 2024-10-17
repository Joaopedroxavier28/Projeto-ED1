public class Pedido {
    String descricao;
    int quantidade;
    double total;

    Pedido anterior;
    Pedido proximo;

    Pedido(String descricao, int quantidade, double total) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.total = total;
        this.anterior = null;
        this.proximo = null;
    }
}

