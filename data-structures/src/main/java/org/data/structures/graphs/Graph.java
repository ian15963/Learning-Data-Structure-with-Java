package org.data.structures.graphs;

import org.data.structures.hasmap.CustomHashMap;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {

    private CustomHashMap<T, List<T>> map = new CustomHashMap<>();
    private T firstVertex = null;

    public void addVertex(T vertex){
        if (firstVertex == null){
            firstVertex = vertex;
        }
        map.put(vertex, new ArrayList<>());
    }

    public void addEdge(T source, T destination, boolean bidirection){

        if (firstVertex == null){
            firstVertex = source;
        }

        if (!map.containsKey(source)){
            map.put(source, new ArrayList<>());
        }

        if (!map.containsKey(destination)){
            map.put(destination, new ArrayList<>());
        }

        map.get(source).add(destination);

        if (bidirection){
            map.get(destination).add(source);
        }

    }

    public int getVertexCount(){
        return map.keySet().size();
    }

    public int getEdgeCount(boolean bidirection){
        int count = 0;
        for (T key: map.keySet()){
            count += map.get(key).size();
        }
        if (bidirection) {
            count = count/2;
        }
        return count;
    }

    public List<T> neighbours(T vertex){
        return map.get(vertex);
    }

    public T getFirstVertex() {
        return firstVertex;
    }
}
