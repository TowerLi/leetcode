package com.watercoldtoday;

/**
 * 841. Keys and Rooms
 * https://leetcode-cn.com/problems/keys-and-rooms/
 */
import java.util.*;
public class Leetcode_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms,visited,0);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
    private void dfs(List<List<Integer>> rooms,boolean[] visited,int i) {
        visited[i] = true;
        if (rooms.get(i).size() == 0) return;
        for (int j = 0; j < rooms.get(i).size(); j++) {
            int cur = rooms.get(i).get(j);
            if (!visited[cur]) {
                dfs(rooms,visited,cur);
            }
        }
    }

    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(0);
        visited[0] = true;
        int nums = 0;
        while (!q.isEmpty()) {
            int cur = q.peek();
            q.poll();
            nums++;
            for (int i : rooms.get(cur)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return nums == n;
    }
}
