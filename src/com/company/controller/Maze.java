package com.company.controller;


import java.util.ArrayList;

//class to manage the maze
public class Maze {
    private final int maze[][];
    private int startPosition[] = { -1, -1 };

    public Maze(int maze[][]) {
        this.maze = maze;
    }

    public int[] getStartPosition() {
    // Check if we've already found start position
        if (this.startPosition[0] != -1 && this.startPosition[1] != -1) {
            return this.startPosition;
        }
        // Default return value
        int startPosition[] = { 0, 0 };
        // Loop over rows
        for (int rowIndex = 0; rowIndex < this.maze.length; rowIndex++) {
        // Loop over columns
            for (int colIndex = 0; colIndex < this.maze[rowIndex]. length; colIndex++) {
                // 2 is the type for start position
                if (this.maze[rowIndex][colIndex] == 2) { this.startPosition = new int[] { colIndex, rowIndex };
                    return new int[] { colIndex, rowIndex };
                }
            }
        }
        return startPosition;
    }

    public int getPositionValue(int x, int y) {
        if (x < 0 || y < 0 || x >= this.maze.length || y >= this.maze[0].length) {
            return 1; }
        return this.maze[y][x];
    }

    public boolean isWall(int x, int y) {
        return (this.getPositionValue(x, y) == 1);
    }

    public int getMaxX() {
        return this.maze[0].length - 1;
    }

    public int getMaxY() {
        return this.maze.length - 1;
    }

    public int scoreRoute(ArrayList<int[]> route) {
        int score = 0;
        boolean visited[][] = new boolean[this.getMaxY() + 1][this.getMaxX() + 1];
        // Loop over route and score each move
        for (Object routeStep : route) {
            int step[] = (int[]) routeStep;
            if (this.maze[step[1]][step[0]] == 3 && visited[step[1]][step[0]] == false) {
                // Increase score for correct move
                score++;
                // Remove reward visited[step[1]][step[0]] = true;

            }
        }
        return score;
    }




}
