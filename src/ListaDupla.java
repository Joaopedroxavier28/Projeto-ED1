public class ListaDupla {
    private Pedido head;

    // Inserir pedido
    public void inserirPedido(String descricao, int quantidade, double total) {
        Pedido novoPedido = new Pedido(descricao, quantidade, total);
        if (head == null) {
            head = novoPedido;
        } else {
            Pedido atual = head;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoPedido;
            novoPedido.anterior = atual;
        }
    }

    // Remover pedido
    public void removerPedido(String descricao) {
        if (head == null) return;

        Pedido atual = head;
        while (atual != null && !atual.descricao.equals(descricao)) {
            atual = atual.proximo;
        }

        if (atual != null) {
            if (atual.anterior != null) {
                atual.anterior.proximo = atual.proximo;
            } else {
                head = atual.proximo;
            }

            if (atual.proximo != null) {
                atual.proximo.anterior = atual.anterior;
            }
        }
    }

    // Buscar pedido
    public Pedido buscarPedido(String descricao) {
        Pedido atual = head;
        while (atual != null) {
            if (atual.descricao.equals(descricao)) {
                return atual;
            }
            atual = atual.proximo;
        }
        return null;
    }

    // Atualizar pedido
    public void atualizarPedido(String descricao, int novaQuantidade, double novoTotal) {
        Pedido pedido = buscarPedido(descricao);
        if (pedido != null) {
            pedido.quantidade = novaQuantidade;
            pedido.total = novoTotal;
        }
    }

    // Exibir pedidos
    public void exibirPedidos() {
        Pedido atual = head;
        while (atual != null) {
            System.out.println("Descrição: " + atual.descricao + ", Quantidade: " + atual.quantidade + ", Total: " + atual.total);
            atual = atual.proximo;
        }
    }
}
