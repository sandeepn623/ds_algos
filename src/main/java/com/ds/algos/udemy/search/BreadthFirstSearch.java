package com.ds.algos.udemy.search;


import com.ds.algos.advanced.Graph;

import java.util.*;

public class BreadthFirstSearch {

    public Set<String> breadthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String label = queue.poll();
            for (Graph.Vertex vertex : (List<Graph.Vertex>)graph.getAdjacentVertices(label)) {
                if (!visited.contains(vertex.getLabel())) {
                    visited.add(vertex.getLabel().toString());
                    queue.add(vertex.getLabel().toString());
                }
            }
        }
        return visited;
    }
}
