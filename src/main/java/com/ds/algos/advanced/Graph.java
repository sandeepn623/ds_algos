package com.ds.algos.advanced;

import com.ds.algos.udemy.search.BreadthFirstSearch;
import com.ds.algos.udemy.search.DepthFirstSearch;
import lombok.Data;

import java.util.*;

@Data
public class Graph {

    private int vertices;
    private Map<Vertex, List<Vertex>> adjacentVertices;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacentVertices = new LinkedHashMap<>();
    }

    public void addVertex(Vertex vertex) {
        adjacentVertices.putIfAbsent(vertex, new ArrayList<>());
    }
    public void addEdge(String source, String destination) {
        Vertex sourceVertex = new Vertex(source);
        Vertex destinationVertex = new Vertex(destination);
        addVertex(new Vertex(source));
        addVertex(new Vertex(destination));
        adjacentVertices.get(sourceVertex).add(destinationVertex);
        //For undirected graphs
        //adjacentVertices.get(destinationVertex).add(sourceVertex);
    }

    public List<Vertex> getAdjacentVertices(String label) {
        return adjacentVertices.get(new Vertex(label));
    }
    public static void main(String[] args) {

        Graph stringGraph = new Graph(5);

        stringGraph.addEdge("approveInvoice", "invoice_approved");
        stringGraph.addEdge("invoice_approved", "prepareBankTransfer");
        stringGraph.addEdge("invoice_approved", "reviewInvoice");
        stringGraph.addEdge("prepareBankTransfer", "ServiceTask_1");
        stringGraph.addEdge("ServiceTask_1", "invoiceProcessed");

        System.out.println(stringGraph.printGraph());
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        Set<String> path = depthFirstSearch.depthFirstTraversal(stringGraph, "approveInvoice", "test");
        System.out.println(path);
        if(path.isEmpty()) {
            System.exit(-1);
        }
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        System.out.println(breadthFirstSearch.breadthFirstTraversal(stringGraph, "approveInvoice"));

    }

    public String printGraph() {
        StringBuffer sb = new StringBuffer();
        for(Vertex vertex: adjacentVertices.keySet()) {
            sb.append(vertex).append(" ");
            sb.append(adjacentVertices.get(vertex)).append(" ");
        }
        return sb.toString();
    }

    @Data
    public static class Vertex {
        private String label;

        public Vertex(String label) {
            this.label = label;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return label.equals(vertex.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }

        @Override
        public String toString() {
            return label.toString();
        }
    }
}
