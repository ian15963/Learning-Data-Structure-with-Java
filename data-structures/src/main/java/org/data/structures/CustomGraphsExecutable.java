package org.data.structures;

import org.data.structures.algorithm.PesquisaEmLargura;
import org.data.structures.graphs.Graph;
import org.data.structures.graphs.WeightedGraph;

import java.util.PriorityQueue;
import java.util.Queue;

public class CustomGraphsExecutable {

    public static void main(String[] args) {

        Graph<String> stringGraph = new Graph<>();
        stringGraph.addVertex("Valor");
        stringGraph.addVertex("Batata");
        stringGraph.addVertex("Macarrão");
        stringGraph.addEdge("Valor", "Batata", true);
        stringGraph.addEdge("Valor", "Macarrão", true);
        System.out.println(stringGraph.getEdgeCount(false));
        System.out.println(stringGraph.getVertexCount());
        System.out.println(stringGraph.neighbours("Valor"));

        WeightedGraph<String> weightedGraph = new WeightedGraph<>();
        weightedGraph.addVertex("Valor");
        weightedGraph.addVertex("Batata");
        weightedGraph.addVertex("Macarrão");
        weightedGraph.addEdge("Valor", "Batata", 4);
        System.out.println(PesquisaEmLargura.search(stringGraph, "Macarrão"));

    }
}
