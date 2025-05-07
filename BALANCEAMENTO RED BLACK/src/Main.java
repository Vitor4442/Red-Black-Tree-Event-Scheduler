public class Main {
    public static void main(String[] args) {
        
        Btree b = new Btree();

        // Adicionando eventos
        b.addEvent(new Evento(1, 10, 12, "Evento 1"));
        b.addEvent(new Evento(2, 14, 16, "Evento 2"));
        b.addEvent(new Evento(3, 8, 10, "Evento 3"));
        b.addEvent(new Evento(4, 16, 18, "Evento 4"));
        b.addEvent(new Evento(5, 12, 14, "Evento 5"));

        // Testando a impressão em ordem (Inorder)
        System.out.println("Eventos em Ordem:");
        b.printInorder();

        // Testando consulta por horário exato
        System.out.println("\nEventos no horário 10:");
        b.findEventsAtTime(10);

        // Testando consulta por intervalo de tempo
        System.out.println("\nEventos entre 10 e 16:");
        b.findEventsInRange(10, 16);

        // Removendo um evento (por horário de início)
        System.out.println("\nRemovendo evento com início em 10:");
        b.removeEvent(10);

        // Imprimindo a árvore após a remoção
        System.out.println("\nEventos após remoção:");
        b.printInorder();
    }
}