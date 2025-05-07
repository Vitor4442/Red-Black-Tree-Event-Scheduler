class Btree {
    private RedBlackNode raiz;

    public Btree() {
        raiz = null;
    }

    // Método para adicionar eventos
    public void addEvent(Evento e) {
        RedBlackNode novo = new RedBlackNode(e);
        if (raiz == null) {
            raiz = novo;
            raiz.cor = false; // A raiz é sempre preta
        } else {
            raiz = raiz.addEvent(raiz, novo);
        }
    }

    // Método para imprimir os eventos
    public void printInorder() {
        if (raiz != null) {
            raiz.printInorder(raiz);
        }
    }

    // Métodos para buscar eventos
    public void findEventsAtTime(int start_time) {
        if (raiz != null) {
            raiz.findEventsAtTime(raiz, start_time);
        }
    }

    public void findEventsInRange(int start_time, int end_time) {
        if (raiz != null) {
            raiz.findEventsInRange(raiz, start_time, end_time);
        }
    }

    // Método para remover evento
    public void removeEvent(int start_time) {
        raiz = raiz.removeEvent(raiz, start_time);
    }
}