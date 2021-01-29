package Graph;

import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair> {
        int wsf;
        String psf;
        Pair(int wsf, String psf){
            this.wsf = wsf;
            this.psf = psf;
        }
        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }

    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3, 40));
        graph[0].add(new Edge(0, 1, 10));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 0, 10));

        graph[2].add(new Edge(2, 3, 10));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 5, 10));

        graph[3].add(new Edge(3, 0, 40));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 3));

        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 2, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 5, 3));
        graph[6].add(new Edge(6, 4, 8));

        int src = 0;
        int dest = 6;
        boolean[] visited = new boolean[vertices];
        boolean pathFlag = hasPath(graph, 0, 6, visited);
//        System.out.println(pathFlag);

        boolean[] visitedAllPath = new boolean[vertices];
        String path = "";
        printAllPaths(graph, src, dest, visitedAllPath, src + "");

        int criteria = 3;
        int k = 3;

        boolean[] visitedmultisolver = new boolean[7];

        multisolver(graph, src, dest, visitedmultisolver, criteria, k, src + "", 0);

        System.out.println("Smallest Path = " + spath + "@" + spathwt);
        System.out.println("Largest Path = " + lpath + "@" + lpathwt);
        System.out.println("Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
        System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
        System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);



    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
        // Will use recursion - floodfill type of questions
        if (src == dest) {
            return true;
        }
        visited[src] = true;
        for (Edge e : graph[src]) {
            if (!visited[e.nbr]) {
                boolean hasNbrPath = hasPath(graph, e.nbr, dest, visited); //nbr se destination ka path hai kya?
                if (hasNbrPath) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf) {
        if (src == dest) {
            System.out.println(psf);
            return;
        }
        visited[src] = true;

        for (Edge e : graph[src]) {
            if (!visited[e.nbr]) {
                printAllPaths(graph, e.nbr, dest, visited, psf + e.nbr);
            }
        }
        visited[src] = false;
    }

    static String spath;
    static Integer spathwt = Integer.MAX_VALUE;
    static String lpath;
    static Integer lpathwt = Integer.MIN_VALUE;
    static String cpath;
    static Integer cpathwt = Integer.MAX_VALUE;
    static String fpath;
    static Integer fpathwt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
        if (src == dest) {
            if(wsf < spathwt){
                spathwt = wsf;
                spath = psf;
            }

            if(wsf > lpathwt){
                lpathwt = wsf;
                lpath = psf;
            }

            if(wsf < criteria && wsf > fpathwt){
                fpathwt = wsf;
                fpath = psf;
            }

            if(wsf > criteria && wsf < cpathwt){
                cpathwt = wsf;
                cpath = psf;
            }

            if(pq.size() <  k){
                pq.add(new Pair(wsf, psf));
            } else if(wsf > pq.peek().wsf){
                pq.remove();
                pq.add(new Pair(wsf, psf));
            }
            return;
        }

        visited[src] = true;
        for (Edge e : graph[src]) {
            if (!visited[e.nbr]) {
                multisolver(graph, e.nbr, dest, visited, criteria, k, psf + e.nbr, wsf + e.wt);
            }
        }
        visited[src] = false;
    }




}































