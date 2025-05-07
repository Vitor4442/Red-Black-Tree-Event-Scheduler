Red-Black Tree Event Scheduler

This Java project implements a Red-Black Tree to manage and schedule events, providing efficient insertion, deletion, and querying of events based on their start times and time ranges. The implementation ensures the tree remains balanced using Red-Black Tree properties, guaranteeing O(log n) time complexity for most operations.

Features





Event Management: Add, remove, and query events with unique IDs, start times, end times, and descriptions.



Red-Black Tree Structure: Maintains balance with red and black nodes to ensure efficient operations.



Queries:





Find events at a specific time.



Find events within a given time range.



Print all events in-order (sorted by event ID).



Operations:





Insertion with automatic balancing.



Deletion with proper tree rebalancing.



In-order traversal for displaying events.

Project Structure

The project consists of the following Java classes:





Evento.java: Represents an event with properties like event_id, start_time, end_time, and description.



RedBlackNode.java: Defines a node in the Red-Black Tree, including methods for insertion, deletion, balancing, and querying.



Btree.java: Manages the Red-Black Tree, providing a high-level interface for adding, removing, and querying events.



Main.java: Contains the main method with example usage of the Red-Black Tree for event scheduling.

Prerequisites





Java Development Kit (JDK) 8 or higher.



A Java IDE (e.g., IntelliJ IDEA, Eclipse) or a command-line environment to compile and run the code.

How to Run





Clone the repository:

git clone <repository-url>



Navigate to the project directory:

cd <project-directory>



Compile the Java files:

javac *.java



Run the main class:

java Main

The Main.java file includes a sample program that:





Adds five events to the tree.



Prints events in-order.



Queries events at a specific time (e.g., 10).



Queries events within a time range (e.g., 10 to 16).



Removes an event by start time and prints the updated tree.

Example Output

Running Main.java produces output similar to:

Eventos em Ordem:
ID: 1, descrição: Evento 1, Inicio: 10, Fim: 12, Cor: Preto
ID: 2, descrição: Evento 2, Inicio: 14, Fim: 16, Cor: Vermelho
ID: 3, descrição: Evento 3, Inicio: 8, Fim: 10, Cor: Preto
ID: 4, descrição: Evento 4, Inicio: 16, Fim: 18, Cor: Vermelho
ID: 5, descrição: Evento 5, Inicio: 12, Fim: 14, Cor: Preto

Eventos no horário 10:
ID: 1, descrição: Evento 1, Inicio: 10, Fim: 12

Eventos entre 10 e 16:
ID: 1, descrição: Evento 1, Inicio: 10, Fim: 12
ID: 2, descrição: Evento 2, Inicio: 14, Fim: 16
ID: 5, descrição: Evento 5, Inicio: 12, Fim: 14

Removendo evento com início em 10:

Eventos após remoção:
ID: 2, descrição: Evento 2, Inicio: 14, Fim: 16, Cor: Vermelho
ID: 3, descrição: Evento 3, Inicio: 8, Fim: 10, Cor: Preto
ID: 4, descrição: Evento 4, Inicio: 16, Fim: 18, Cor: Vermelho
ID: 5, descrição: Evento 5, Inicio: 12, Fim: 14, Cor: Preto

Usage

To use the Red-Black Tree for your own event scheduling:





Create Evento objects with the desired event_id, start_time, end_time, and description.



Instantiate a Btree object.



Use the addEvent, removeEvent, findEventsAtTime, or findEventsInRange methods to manage and query events.



Use printInorder to display all events in sorted order.

Example:

Btree b = new Btree();
b.addEvent(new Evento(1, 10, 12, "Meeting"));
b.findEventsAtTime(10);
b.printInorder();

Notes





The tree is sorted by event_id, but queries are based on start_time and end_time.



The Red-Black Tree ensures balanced operations, but the findEventsAtTime and findEventsInRange methods may traverse multiple nodes, depending on the data.



The implementation assumes unique event_id values for simplicity.

Contributing

Contributions are welcome! Please submit a pull request or open an issue for any bugs, improvements, or feature requests.

License

This project is licensed under the MIT License. See the LICENSE file for details.