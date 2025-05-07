public class RedBlackNode{
   public Evento x;
    public RedBlackNode esq, dir, pai;
    public boolean cor; // true -> Vermelho, false -> Preto

    public RedBlackNode(Evento x) {
        this.x = x;
        this.esq = this.dir = this.pai = null;
        this.cor = true; // Nó inserido inicialmente como vermelho
    }

    // Método de inserção no nó
    public RedBlackNode addEvent(RedBlackNode raiz, RedBlackNode novo) {
        if (raiz == null) {
            return novo;
        }

        // Inserção padrão da árvore binária de busca
        if (novo.x.getEvent_id() < raiz.x.getEvent_id()) {
            raiz.esq = addEvent(raiz.esq, novo);
            raiz.esq.pai = raiz;
        } else {
            raiz.dir = addEvent(raiz.dir, novo);
            raiz.dir.pai = raiz;
        }

        // Verificar e corrigir a árvore Red-Black
        return balancear(raiz);
    }

    // Balanceamento da árvore Red-Black após inserção
    public RedBlackNode balancear(RedBlackNode raiz) {
        if (raiz.dir != null && raiz.dir.cor && raiz.cor) {
            raiz = rotacionarEsquerda(raiz);
        }
        if (raiz.esq != null && raiz.esq.cor && raiz.esq.esq != null && raiz.esq.esq.cor) {
            raiz = rotacionarDireita(raiz);
        }
        if (raiz.esq != null && raiz.esq.cor && raiz.dir != null && raiz.dir.cor) {
            inverterCores(raiz);
        }
        return raiz;
    }

    // Rotações
    private RedBlackNode rotacionarEsquerda(RedBlackNode raiz) {
        RedBlackNode aux = raiz.dir;
        raiz.dir = aux.esq;
        if (aux.esq != null) {
            aux.esq.pai = raiz;
        }
        aux.pai = raiz.pai;
        if (raiz.pai == null) {
            raiz = aux;
        } else if (raiz == raiz.pai.esq) {
            raiz.pai.esq = aux;
        } else {
            raiz.pai.dir = aux;
        }
        aux.esq = raiz;
        raiz.pai = aux;
        return aux;
    }

    private RedBlackNode rotacionarDireita(RedBlackNode raiz) {
        RedBlackNode aux = raiz.esq;
        raiz.esq = aux.dir;
        if (aux.dir != null) {
            aux.dir.pai = raiz;
        }
        aux.pai = raiz.pai;
        if (raiz.pai == null) {
            raiz = aux;
        } else if (raiz == raiz.pai.dir) {
            raiz.pai.dir = aux;
        } else {
            raiz.pai.esq = aux;
        }
        aux.dir = raiz;
        raiz.pai = aux;
        return aux;
    }

    // Inverter as cores de um nó e seus filhos
    private void inverterCores(RedBlackNode raiz) {
        raiz.cor = !raiz.cor;
        if (raiz.esq != null) {
            raiz.esq.cor = !raiz.esq.cor;
        }
        if (raiz.dir != null) {
            raiz.dir.cor = !raiz.dir.cor;
        }
    }

    // Impressão em ordem
    public void printInorder(RedBlackNode raiz) {
        if (raiz.esq != null) {
            printInorder(raiz.esq);
        }
        System.out.println("ID: " + raiz.x.getEvent_id() + ", descrição: " + raiz.x.getDescription() +
                ", Inicio: " + raiz.x.getStart_time() + ", Fim: " + raiz.x.getEnd_time() +
                ", Cor: " + (raiz.cor ? "Vermelho" : "Preto"));
        if (raiz.dir != null) {
            printInorder(raiz.dir);
        }
    }

    // Método para encontrar eventos no horário exato
    public void findEventsAtTime(RedBlackNode raiz, int start_time) {
        if (raiz == null) {
            return;
        }
        if (raiz.x.getStart_time() == start_time) {
            System.out.println("ID: " + raiz.x.getEvent_id() + ", descrição: " + raiz.x.getDescription() +
                    ", Inicio: " + raiz.x.getStart_time() + ", Fim: " + raiz.x.getEnd_time());
        }
        if (start_time < raiz.x.getStart_time()) {
            findEventsAtTime(raiz.esq, start_time);
        } else if (start_time > raiz.x.getStart_time()) {
            findEventsAtTime(raiz.dir, start_time);
        }
    }

    // Método para encontrar eventos em um intervalo de tempo
    public void findEventsInRange(RedBlackNode raiz, int start_time, int end_time) {
        if (raiz == null) {
            return;
        }
        if (raiz.x.getStart_time() >= start_time && raiz.x.getEnd_time() <= end_time) {
            System.out.println("ID: " + raiz.x.getEvent_id() + ", descrição: " + raiz.x.getDescription() +
                    ", Inicio: " + raiz.x.getStart_time() + ", Fim: " + raiz.x.getEnd_time());
        }
        if (start_time < raiz.x.getStart_time()) {
            findEventsInRange(raiz.esq, start_time, end_time);
        }
        if (end_time > raiz.x.getEnd_time()) {
            findEventsInRange(raiz.dir, start_time, end_time);
        }
    }

    // Método para remover evento
    public RedBlackNode removeEvent(RedBlackNode raiz, int start_time) {
        if (raiz == null) {
            return raiz;
        }
        if (start_time < raiz.x.getStart_time()) {
            raiz.esq = removeEvent(raiz.esq, start_time);
        } else if (start_time > raiz.x.getStart_time()) {
            raiz.dir = removeEvent(raiz.dir, start_time);
        } else {
            if (raiz.esq == null || raiz.dir == null) {
                RedBlackNode temp = (raiz.esq != null) ? raiz.esq : raiz.dir;
                if (temp == null) {
                    temp = raiz;
                    raiz = null;
                } else {
                    raiz = temp;
                }
            } else {
                RedBlackNode temp = min(raiz.dir);
                raiz.x = temp.x;
                raiz.dir = removeEvent(raiz.dir, temp.x.getStart_time());
            }
        }
        if (raiz == null) {
            return raiz;
        }
        return balancear(raiz);
    }

    private RedBlackNode min(RedBlackNode raiz) {
        while (raiz.esq != null) {
            raiz = raiz.esq;
        }
        return raiz;
    }
}