
package material.graphs;

import material.Position;
import material.tree.Tree;
import material.tree.narytree.LinkedTree;

import java.util.*;

/**
 *
 * @author mayte
 * @param <V>
 * @param <E>
 */
public class Algoritmos<V,E> {
    public Tree<Vertex<V>> minimumSpanningTree(Graph<V,E> grafo){
        throw new RuntimeException("Not implemented yet.");
    }

    // Estructuras y métodosa auxiliares para definir el comparador de la cola de prioridad
//    HashMap<Vertex<V>, Double> distanceMap2;
//    private Double getDistance(Vertex<V> v){
//        return distanceMap2.get(v);
//    }
//
//    private class DistanceComparator implements Comparator<Vertex<V>>{
//        HashMap<Vertex<V>, Double> distances;
//        DistanceComparator(HashMap<Vertex<V>, Double> map){
//            distances = map;
//        }
//
//        @Override
//        public int compare(Vertex<V> o1, Vertex<V> o2) {
//            return (int)(distances.get(o1) - distances.get(o2)) ;
//        }
//    }

    private Tree<Vertex<V>> buildTree(Graph<V, E> g, Vertex<V> source, HashMap<Vertex<V>, Vertex<V>> previousMap){
        LinkedTree<Vertex<V>> tree = new LinkedTree<>();
        Position<Vertex<V>> current = tree.addRoot(source);
        
        while (!previousMap.isEmpty()){
            for (Map.Entry<Vertex<V>, Vertex<V>> entry : previousMap.entrySet()){
                if (entry.getValue().equals(current)){
                    tree.add(entry.getKey(), current);
                }
            }
        }

        return null;
    }

    public Tree<Vertex<V>> dijkstra(Graph<V, E> grafo, Vertex<V> source){
        Set<Vertex<V>> visited = new HashSet<>();
        HashMap<Vertex<V>, Double> distanceMap = new HashMap<>();
        HashMap<Vertex<V>, Vertex<V>> previousMap = new HashMap<>();

        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparing(distanceMap::get));

        // Otras opciones para inicializar un comparador para la cola de prioridad
//        PriorityQueue<Vertex<V>> queue2 = new PriorityQueue<>(Comparator.comparing(this::getDistance));
//        DistanceComparator distanceComparator = new DistanceComparator(distanceMap);
//        PriorityQueue<Vertex<V>> queue3 = new PriorityQueue<>(distanceComparator);

        if (grafo.vertices().isEmpty()){
            return new LinkedTree<>();
        }

        queue.add(source);
        distanceMap.put(source, 0.0d);

        while (!queue.isEmpty()){
            Vertex<V> current = queue.poll();
            visited.add(current);

            for (Edge<E> edge : grafo.incidentEdges(current)){
                Vertex<V> opp = grafo.opposite(current, edge);

                if (!visited.contains(opp)){
                   double distance =  distanceMap.get(current) + (Double) edge.getElement();

                   if (!distanceMap.containsKey(opp) || distance < distanceMap.get(opp)){
                       distanceMap.put(opp, distance);
                       previousMap.put(opp, current);
                       queue.add(opp);
                   }
                }
            }
        }
        return buildTree(grafo, source, previousMap);
    }


}
