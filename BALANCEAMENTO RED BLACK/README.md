# Red-Black Tree for Event Management

This project implements a **Red-Black Tree** (a type of self-balancing binary search tree) in Java to manage events based on their start and end times. The system allows adding, removing, and querying events efficiently.

## Features

- **Add events**: Insert events with a unique ID, start time, end time, and description.
- **Query events**:
  - Find events at an exact start time.
  - Find events within a specified time range.
- **Remove events**: Remove events based on their start time.
- **In-order traversal**: Print the events in ascending order of their start time.

## How to Use

### Prerequisites

- Java 8 or higher installed on your machine.

### Running the Project

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/your-username/your-repository.git
    ```

2. Navigate to the project directory:

    ```bash
    cd your-repository
    ```

3. Compile and run the `Main.java` file:

    ```bash
    javac Main.java
    java Main
    ```

### Example Usage

When you run the program, it will:

1. Add events to the Red-Black tree.
2. Print the events in ascending order by start time.
3. Query events at a specific time (e.g., time 10).
4. Query events within a time range (e.g., between times 10 and 16).
5. Remove an event by its start time.
6. Print the updated event list.

### Sample Output

Events in Order:
ID: 3, description: Evento 3, Start: 8, End: 10, Color: Black
ID: 1, description: Evento 1, Start: 10, End: 12, Color: Red
ID: 5, description: Evento 5, Start: 12, End: 14, Color: Red
ID: 2, description: Evento 2, Start: 14, End: 16, Color: Black
ID: 4, description: Evento 4, Start: 16, End: 18, Color: Black

Events at time 10:
ID: 1, description: Evento 1, Start: 10, End: 12

Events between 10 and 16:
ID: 1, description: Evento 1, Start: 10, End: 12
ID: 5, description: Evento 5, Start: 12, End: 14
ID: 2, description: Evento 2, Start: 14, End: 16

Removing event starting at time 10:
Event with start time 10 removed.

Events after removal:
ID: 3, description: Evento 3, Start: 8, End: 10, Color: Black
ID: 5, description: Evento 5, Start: 12, End: 14, Color: Red
ID: 2, description: Evento 2, Start: 14, End: 16, Color: Black
ID: 4, description: Evento 4, Start: 16, End: 18, Color: Black


## How the Red-Black Tree Works

- The Red-Black tree is a balanced binary search tree with additional properties that maintain balance during insertion and deletion. The tree automatically adjusts its structure using rotations and color changes to ensure that it remains balanced, which guarantees O(log n) time complexity for most operations.
  
- **Key properties of the Red-Black Tree**:
  - Every node is either red or black.
  - The root is always black.
  - Red nodes cannot have red children.
  - Every path from a node to its descendants contains the same number of black nodes.

## Contributing

Feel free to fork this project and create pull requests. If you have any questions or suggestions, open an issue, and I'll be happy to assist.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
