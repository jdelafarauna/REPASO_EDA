package material.graphs;

import java.util.*;

import material.Position;
import material.tree.Tree;
import material.tree.narytree.LinkedTree;

/**
 *
 * @author jvelez
 * @param <V>
 * @param <E>
 */
public class Recorridos<V, E> {

    /**
     * Devuelve el árbol que se genera al realizar el recorrido en profundidad
     * 
     * @param graph
     * @param source
     * @return 
     */
    
    public Tree<Vertex<V>> depthTravel(Graph<V,E> graph, Vertex<V> source){
        LinkedTree<Vertex<V>> tree = new LinkedTree<>();
        Deque<Position<Vertex<V>>> stack = new ArrayDeque<>();
        Set<Vertex<V>> visited = new HashSet<>();

        Position<Vertex<V>> aux = tree.addRoot(source);
        stack.addFirst(aux);
        visited.add(source);
        
        while (!stack.isEmpty()){
            Position<Vertex<V>> current = stack.pop();
            Vertex<V> vertex = aux.getElement();
            for (Edge<E> edge : graph.incidentEdges(vertex)){
                Vertex<V> opp = graph.opposite(current.getElement(), edge);
                if (!visited.contains(opp)) {
                    Position<Vertex<V>> inserted = tree.add(opp, current);
                    stack.addFirst(inserted);
                    visited.add(opp);
                }
            }
        }
        return tree;
    }
    
    /**
     * Devuelve el árbol que se genera al realizar el recorrido en anchura
     * 
     * @param graph
     * @param source
     * @return 
     */
    
    public Tree<Vertex<V>> widthTravel(Graph<V,E> graph, Vertex<V> source){
        LinkedTree<Vertex<V>> tree = new LinkedTree<>();
        Deque<Position<Vertex<V>>> queue = new ArrayDeque<>();
        Set<Vertex<V>> visited = new HashSet<>();
        
        Position<Vertex<V>> root = tree.addRoot(source);
        queue.add(root);
        visited.add(source);

        while (queue.size() > 0){
            Position<Vertex<V>> current = queue.pop();
            Collection <? extends Edge <E>> adjacents = graph.incidentEdges(current.getElement());
            
            for (Edge<E> edge: adjacents){
                
                Vertex<V> opp = graph.opposite(current.getElement(), edge);
                
                if (!visited.contains(opp)) {
                    Position<Vertex<V>> inserted = tree.add(opp, current);
                    queue.push(inserted);
                    visited.add(opp);
                }
            }
        }
        return tree;
    }
    
    /**
     * Get the path between two vertex with minimun number of nodes.
     *
     * @param graph
     * @param startVertex
     * @param endVertex
     * @return The edge list
     */
    public List<Edge<E>> getPath(Graph<V, E> graph, Vertex<V> startVertex, Vertex<V> endVertex) {
       List<Edge<E>> edgeList = new ArrayList<>();
       Tree<Vertex<V>> tree = widthTravel(graph, startVertex);

       Iterator<Position<Vertex<V>>> it = tree.iterator();

       Position<Vertex<V>> aux = null;

       while (it.hasNext() && (aux == null || !aux.getElement().equals(endVertex))) {
           aux = it.next();
       }

       while (!tree.isRoot(aux)){
           Position<Vertex<V>> parent = tree.parent(aux);
           Edge<E> edge = graph.areAdjacent(aux.getElement(), parent.getElement());
           edgeList.add(0, edge);
           aux = parent;
       }
       return edgeList;
    }

    /**
     * Devuelve el conjunto de vértices visitados al hacer un recorrido en profundidad partiendo de root
     * @param g
     * @param root
     * @return 
     */
    public Set<Vertex<V>> traverse(Graph<V, E> g, Vertex<V> root) {
        Set<Vertex<V>> vertexSet = new HashSet<>();
        Tree<Vertex<V>> tree = widthTravel(g, root);

        for (Position<Vertex<V>> pos : tree){
            vertexSet.add(pos.getElement());
        }
        return vertexSet;
    }
    
    
}
