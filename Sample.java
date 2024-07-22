// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || image[0].length == 0) return image;

        int m = image.length;
        int n = image[0].length;
        int startColor = image[sr][sc];

        if (startColor == color) return image;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cr = current[0];
            int cc = current[1];

            for (int[] dir : dirs) {
                int nr = cr + dir[0];
                int nc = cc + dir[1];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == startColor) {
                    queue.add(new int[]{nr, nc});
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }
}

//------------------------------------

public class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        // Initialize the distance matrix and queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        // Define the 4 possible directions to move in the matrix
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // BFS traversal
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currRow = current[0];
            int currCol = current[1];
            
            // Check all 4 neighbors
            for (int[] dir : directions) {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];
                
                // Check if the new position is within bounds and if we found a shorter path
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    if (dist[newRow][newCol] > dist[currRow][currCol] + 1) {
                        dist[newRow][newCol] = dist[currRow][currCol] + 1;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
        
        return dist;
    }
}

//---------------------------------------//