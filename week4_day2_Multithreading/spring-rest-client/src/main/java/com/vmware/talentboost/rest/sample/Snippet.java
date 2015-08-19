package com.vmware.talentboost.rest.sample;

import java.util.ArrayList;

public class Snippet {

    public static void main(String[] args) throws InterruptedException {
        String server = "localhost";
        int port = 8080;
        GarbageWarsClient garbageWarsClient = new GarbageWarsClient(server, port);
        System.err.println(garbageWarsClient.getRoots(1));
        System.err.println(garbageWarsClient.getObjects(1));
        // garbageWarsClient.collectTrajectory(1, "StudentTown", trajectory)

         String graphAsString =
         "1 2 1 6 2 20 2 30 4 6 6 9 6 1223 1223 8 8 111 111 222 4 7 108 94 108 7 100 101 101 100";
         
         String roots = "4 6 9";
//         Graph graph = new Graph();
//        
//         graph.createGraph(graphAsString, roots);
//         ArrayList<String> list = graph.iterateOverGraph();
        
//         for (String string : list) {
//         System.out.println(string);
//         }
         
//         graph.visualizeGraph();

        Graph graph = new Graph();
        graph.createGraph(garbageWarsClient.getObjects(1), garbageWarsClient.getRoots(1));
        ArrayList<String> list = graph.iterateOverGraph();
        for (int i = 0; i < list.size(); i++) {
            garbageWarsClient.collectTrajectory(1, "StudentTown", list.get(i).toString());
        }
//        
//        for (int i = 1; i < 11; i++) {
//            int j = i;
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    // TODO Auto-generated method stub
//                    Graph graph = new Graph();
//                    graph.createGraph(garbageWarsClient.getObjects(j), garbageWarsClient.getRoots(j));
//                    ArrayList<String> list = graph.iterateOverGraph();
//                    for (int i = 0; i < list.size(); i++) {
//                        garbageWarsClient.collectTrajectory(j, "StudentTown", list.get(i));
//                    }
//
//                }
//            });
//            thread.start();
//
//        }

    }

}
