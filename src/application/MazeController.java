package application;

import java.awt.Point;
import searches.*;
 
public class MazeController {
	/* 
	 * Logic of the program
	 */
	// The search algorithms
//	private Greedy greedy;				
//	private BFS bfs;
//	private DFS dfs;
//	private RandomWalk rand;
//	private Magic magic;
	private SearchAlgorithm search;		// This string tells which algorithm is currently chosen.  Anything other than 
	// the implemented search class names will result in no search happening.

	// Where to start and stop the search
	private Point start;
	private Point goal;

	// The maze to search
	private Maze maze;
	
	//MazeDisplay Variable
	MazeDisplay mazeDisplay;
	
	//SearchFactory Variable
	SearchFactory searchFactory;
	
	
	//Constructor
	public MazeController(int numRows, int numColumns, MazeDisplay mD) {
		start = new Point(1,1);
		goal = new Point(numRows-2, numColumns-2);
		maze = new Maze(numRows,numColumns);
		mazeDisplay = mD;
		searchFactory = new SearchFactory();
	}
	
	public void startSearch(String searchName) {
		maze.reColorMaze();
		
		// Restart the search.  Since I don't know 
		// which one, I'll restart all of them.
		
		search = searchFactory.makeSearch(searchName, maze, start, goal);
	}
	
	//Executes a single step of the search algorithm
	public void doOneStep(double elapsedTime){
		if(search!=null) {
			search.step();
		}
		mazeDisplay.redraw();
	}
	
	//Gets specific cell state
	public int getCellState(Point position) {
		return maze.get(position);
	}
	
	//Creates new maze from scratch
	public void newMaze() {
		maze.createMaze(maze.getNumRows(),maze.getNumCols());
		mazeDisplay.redraw();
	}
	
}
