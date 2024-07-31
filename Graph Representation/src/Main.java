import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user to choose a graph representation method
        System.out.println("Choose the graph representation method:");
        System.out.println("1. Adjacency Matrix (regular 2D array)");
        System.out.println("2. Adjacency Matrix (ragged array)");
        System.out.println("3. Adjacency List");
        int choice = sc.nextInt();

        // Call the appropriate method based on user choice
        switch (choice) {
            case 1:
                adjacencyMatrixRegular();
                break;
            case 2:
                adjacencyMatrixRagged();
                break;
            case 3:
                adjacencyList();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    // Method to create and display a graph using a regular adjacency matrix
    public static void adjacencyMatrixRegular() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int v = sc.nextInt();  // Number of vertices
        int[][] matrix = new int[v][v];  // Initialize a 2D array

        // Loop through each vertex to get its adjacent vertices
        for (int i = 0; i < v; i++) {
            System.out.print("Enter the total count of vertices adjacent to " + (char)(i+'a') + ": ");
            int e = sc.nextInt();  // Number of adjacent vertices
            System.out.println("Now enter the adjacent vertices to " + (char)(i+'a') + ": ");
            sc.nextLine();  // Consume newline character
            for (int j = 0; j < e; j++) {
                char c = sc.nextLine().charAt(0);  // Get adjacent vertex
                matrix[i][c - 'a'] = 1;  // Mark the adjacency in the matrix
            }
        }

        // Print the adjacency matrix
        System.out.println("The graph's adjacency matrix is:- ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to create and display a graph using a ragged adjacency matrix
    public static void adjacencyMatrixRagged() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int v = sc.nextInt();  // Number of vertices
        char[][] matrix = new char[v][];  // Initialize a ragged array

        // Loop through each vertex to get its adjacent vertices
        for (int i = 0; i < v; i++) {
            System.out.print("Enter the total count of vertices adjacent to " + (char)(i+'a') + ": ");
            int e = sc.nextInt();  // Number of adjacent vertices
            matrix[i] = new char[e];  // Initialize array for adjacent vertices
            System.out.println("Now enter the adjacent vertices to " + (char)(i+'a') + ": ");
            sc.nextLine();  // Consume newline character
            for (int j = 0; j < e; j++) {
                char c = sc.nextLine().charAt(0);  // Get adjacent vertex
                matrix[i][j] = c;  // Store adjacent vertex
            }
        }

        // Print the ragged adjacency matrix
        System.out.println("The graph is:- ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print((char)(i+'a') + " -> " );
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to create and display a graph using an adjacency list
    public static void adjacencyList() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int v = sc.nextInt();  // Number of vertices
        ArrayList<ArrayList<String>> list = new ArrayList<>();  // Initialize the list

        System.out.print("Enter the vertices now (space-separated): ");
        sc.nextLine();  // Consume newline character
        String[] vertices = sc.nextLine().split(" ");  // Get the vertices

        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());  // Initialize list for each vertex
        }

        // Loop through each vertex to get its adjacent vertices
        for (int i = 0; i < v; i++) {
            System.out.print("Now enter the adjacent vertices to " + vertices[i] + "(space-separated): ");
            String[] edges = sc.nextLine().split(" ");  // Get adjacent vertices
            for (String edge : edges) {
                list.get(i).add(edge);  // Add adjacent vertices to the list
            }
        }

        // Print the adjacency list
        System.out.println("The graph's adjacency list is:- ");
        for (int i = 0; i < v; i++) {
            System.out.print(vertices[i] + " -> ");
            for (String adj : list.get(i)) {
                System.out.print(adj + " ");
            }
            System.out.println();
        }
    }
}
