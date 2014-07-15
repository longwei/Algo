package ch4;

public class Node {
	
	public enum State{
		Unvisited, Visited, Visiting;
	}
	private Node adjacent[];
	private String vertex;
	public State state;
	public int adjacentCount;
	
	public Node(String vertext, int adjLength){
		this.vertex = vertext;
		adjacentCount = 0;
		adjacent = new Node[adjLength];
	}
	
	public void addAdjacent(Node x){
		this.adjacent[adjacentCount] = x;
		adjacentCount++;
	}
	
	public Node[] getAdjacent(){
		return adjacent;
	}
	public String getVertex(){
		return this.vertex;
	}
	

}
