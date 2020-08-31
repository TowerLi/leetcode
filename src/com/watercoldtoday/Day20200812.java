package com.watercoldtoday;
import java.util.*;
public class Day20200812 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Map<Node,Node> visited= new HashMap<Node,Node>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (visited.containsKey(node)) return visited.get(node);

        Node cloneNode = new Node(node.val);
        visited.put(node,cloneNode);

        for (Node nei : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(nei));
        }
        return cloneNode;
    }


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null) return null;
        int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};
        int row = image.length;
        int col = image[0].length;
        int curColor = image[sr][sc];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(sr * col + sc);
        while (!queue.isEmpty()) {
            int curCoord = queue.poll();
            int curR = curCoord / col;
            int curC = curCoord % col;
            for (int i = 0; i < 4; i++) {
                int newR = curR + direction[i][0];
                int newC = curC + direction[i][1];
                if (newR >= 0 && newC >= 0 && newR < row && newC < col && image[newR][newC] == curColor
                    && image[newR][newC] != newColor) {
                    queue.offer(newR * col + newC);
                }
            }
            image[curR][curC] = newColor;
        }
        return image;
    }
}
