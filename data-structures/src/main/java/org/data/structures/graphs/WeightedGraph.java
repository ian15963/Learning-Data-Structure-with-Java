package org.data.structures.graphs;

import org.data.structures.hasmap.CustomHashMap;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph<T> {

    private CustomHashMap<T, List<CustomHashMap<T, Integer>>> map = new CustomHashMap<>();

    public void addVertex(T vertex){
        map.put(vertex, new ArrayList<>());
    }

    public void addEdge(T source, T destination, int weight){

        if(!map.containsKey(source)){
            map.put(source, new ArrayList<>());
        }

        if (!map.containsKey(destination)){
            map.put(destination, new ArrayList<>());
        }
        CustomHashMap<T, Integer> customHashMap = new CustomHashMap<>();
        customHashMap.put(destination, weight);
        map.get(source).add(customHashMap);

    }

    public int getVertexCount(){
        return map.keySet().size();
    }

    public int getEdgeCount(){
        int total = 0;
        for (T key: map.keySet()){
            total += map.get(key).size();
        }
        return total;
    }

    public List<CustomHashMap<T, Integer>> neighbours(T vertex){
        return map.get(vertex);
    }
}
