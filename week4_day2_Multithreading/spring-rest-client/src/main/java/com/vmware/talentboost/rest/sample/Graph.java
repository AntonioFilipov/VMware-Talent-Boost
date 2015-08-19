package com.vmware.talentboost.rest.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JFrame;

import org.jgraph.JGraph;
import org.jgrapht.DirectedGraph;
import org.jgrapht.EdgeFactory;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.GraphIterator;

public class Graph {
    private DirectedGraph<Vertex, DefaultEdge> graph = new DefaultDirectedGraph<Vertex, DefaultEdge>(DefaultEdge.class);
    private HashSet<Vertex> roots;
    private HashSet<Vertex> notCollectable;

    public DirectedGraph<Vertex, DefaultEdge> getGraph() {
        return this.graph;
    }

    public Graph() {
        this.roots = new HashSet<Vertex>();
        this.notCollectable = new HashSet<Vertex>();

    }

    public void createGraph(String graphAsString, String rootsAsString) {

        this.setRoots(rootsAsString);

        String[] array = graphAsString.split("\\s+");
        for (int i = 0; i < array.length - 1; i += 2) {

            Vertex first = new Vertex(array[i], false);
            Vertex second = new Vertex(array[i + 1], false);
            
            if (this.roots.contains(first)) {
                first.setSystemRoot(true);
                first.setCollectable(false);
            }

            if (this.roots.contains(second)) {
                second.setSystemRoot(true);
                second.setCollectable(false);
            }
            

            if (this.graph.containsVertex(first)) {
                GraphIterator<Vertex, DefaultEdge> iterator = new DepthFirstIterator<Vertex, DefaultEdge>(graph);

                while (iterator.hasNext()) {
                    Vertex next = iterator.next();
                    if (next.equals(first)) {
                        if (!next.isCollectable()) {
                            second.setCollectable(false);
                        }
                        next.getChildrens().add(second);
                        break;
                    }
                    
                }
            }else{
                if (!first.isCollectable()) {
                    second.setCollectable(false);
                }
                first.getChildrens().add(second);
                this.graph.addVertex(first);
            }
            
            
            if (!first.isCollectable()) {
                second.setCollectable(false);
            }
            
            this.graph.addVertex(second);
            this.graph.addEdge(first, second);

        }
    }

    public void visualizeGraph() {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        JGraph jgraph = new JGraph(new JGraphModelAdapter(this.getGraph()));
        frame.getContentPane().add(jgraph);
        frame.setVisible(true);
        // while (true) {
        // Thread.sleep(2000);
        // }
    }

    public void setRoots(String rootsAsString) {
        String[] splittedRoots = rootsAsString.split("\\s+");
        for (String string : splittedRoots) {
            this.roots.add(new Vertex(string, true));
        }
    }

    public ArrayList<String> iterateOverGraph() {
        GraphIterator<Vertex, DefaultEdge> iterator = new DepthFirstIterator<Vertex, DefaultEdge>(graph);
        String result="";
        ArrayList<String> str = new ArrayList<String>();
        while (iterator.hasNext()) {
            Vertex next = iterator.next();
//            System.out.println("value:"+next + " childrens:"+next.getChildrens());
            System.out.println("Next value:"+next.getValue() + "  is Collectable:"+next.isCollectable());
            if (next.isCollectable()) {
                result = result+" "+next.getValue();
                System.out.println(result.trim());

                if(next.getChildrens().isEmpty()){
                    str.add(result.trim());
                    result="";
                }
            }else{ 
                continue;
            }
        }
        
        return str;
    }

}
