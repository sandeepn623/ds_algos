package com.ds.algos.udemy.search;

import com.ds.algos.advanced.Graph;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearch {

    public Set<String> depthFirstTraversal(Graph graph, String start,  String end) {
        Set<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(start);
        String label = "";
        while (!stack.isEmpty()) {
            label = stack.pop();
            if(!visited.contains(label)) {
                if(!graph.getAdjacentVertices(label).isEmpty()) {
                    visited.add(label);
                } else if(label.equals(end)) {
                    visited.add(label);
                    break;
                }
                for (Graph.Vertex vertex: graph.getAdjacentVertices(label)) {
                    stack.push(vertex.getLabel());
                }
            }
        }
        if(!label.equals(end)) {
            visited.clear();
        }
        return visited;
    }
}
