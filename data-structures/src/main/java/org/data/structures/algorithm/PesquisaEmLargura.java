package org.data.structures.algorithm;

import org.data.structures.array.CustomArrayList;
import org.data.structures.graphs.Graph;
import org.data.structures.queue.CustomQueue;

public class PesquisaEmLargura<T> {

    public static <T> T search(Graph<T> graph, T valor){
        PesquisaEmLarguraEstrutura<T> pesquisaEstrutura = new PesquisaEmLarguraEstrutura<>(graph);
        return search(valor, pesquisaEstrutura);
    }

    public static <T> T search(T valor, PesquisaEmLarguraEstrutura<T> pesquisaEstrutura){
        CustomQueue<T> queue = pesquisaEstrutura.getQueue();
        Graph<T> graph = pesquisaEstrutura.getGraph();
        CustomArrayList<T> elementosRemovidos = pesquisaEstrutura.getElementosRemovidos();
        if (queue.peek() != null){
            T elementoRemovido = queue.poll();
            elementosRemovidos.add(elementoRemovido);
            if (elementoRemovido.equals(valor)){
                return valor;
            }
            graph.neighbours(elementoRemovido).stream().filter(vertex -> !elementosRemovidos.contains(vertex))
                    .forEach(queue::add);
            return search(valor, pesquisaEstrutura);
        }
        return null;
    }

    private static class PesquisaEmLarguraEstrutura<T> {

        private Graph<T> graph;
        private CustomQueue<T> queue;
        private CustomArrayList<T> elementosRemovidos;

        public PesquisaEmLarguraEstrutura(Graph<T> graph) {
            this.graph = graph;
            this.queue = new CustomQueue<>();
            queue.add(graph.getFirstVertex());
            this.elementosRemovidos = new CustomArrayList<>();
        }

        public Graph<T> getGraph() {
            return graph;
        }

        public CustomQueue<T> getQueue() {
            return queue;
        }

        public CustomArrayList<T> getElementosRemovidos() {
            return elementosRemovidos;
        }
    }


}
