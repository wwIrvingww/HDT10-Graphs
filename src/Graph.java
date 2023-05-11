import java.util.ArrayList;

public class Graph {

    // Una lista de listas para representar una lista de adyacencia
    List<List<Node>> adjList = new ArrayList<>();

    // Constructor para construir un grafo
    public Graph(List<Edge> edges)
    {
        // encuentra el vértice máximo numerado
        int n = 0;
        for (Edge e: edges) {
            n = Integer.max(n, Integer.max(e.src, e.dest));
        }

        // asignar memoria para la lista de adyacencia
        for (int i = 0; i <= n; i++) {
            adjList.add(i, new ArrayList<>());
        }

        // agrega bordes al grafo dirigido
        for (Edge e: edges)
        {
            // asignar un nuevo nodo en la lista de adyacencia de src a dest
            adjList.get(e.src).add(new Node(e.dest, e.weight));

            // elimine el comentario debajo de la línea para el graph no dirigido

            // asignar un nuevo nodo en la lista de adyacencia de dest a src
            // adjList.get(e.dest).add(new Node(e.src, e.weight));
        }
    }

    // Función para imprimir la representación de la lista de adyacencia de un graph
    public static void printGraph(Graph graph)
    {
        int src = 0;
        int n = graph.adjList.size();

        while (src < n)
        {
            // imprime el vértice actual y todos sus vértices vecinos
            for (Node edge: graph.adjList.get(src)) {
                System.out.printf("%d ——> %s\t", src, edge);
            }

            System.out.println();
            src++;
        }
    }

}
