package graph;

import java.util.ArrayList;
import java.util.List;
 

public class DiGraphImpl implements DiGraph{

	private List<GraphNode> nodeList = new ArrayList<>();

	public Boolean addNode(GraphNode node) {return null;}
	public Boolean removeNode(GraphNode node) {return null;}
	public Boolean setNodeValue(GraphNode node, String newNodeValue) {return null;}
	public String getNodeValue(GraphNode node) {return null;}
	
	public Boolean addEdge(GraphNode fromNode, GraphNode toNode, Integer weight) {return null;}
	public Boolean removeEdge(GraphNode fromNode, GraphNode toNode) {return null;}
	public Boolean setEdgeValue(GraphNode fromNode, GraphNode toNode, Integer newWeight) {return null;}
	public Integer getEdgeValue(GraphNode fromNode, GraphNode toNode) {return null;}

	public List<GraphNode> getAdjacentNodes(GraphNode node) {return null;}
	public Boolean nodesAreAdjacent(GraphNode fromNode, GraphNode toNode) {return null;}
	public Boolean nodeIsReachable(GraphNode fromNode, GraphNode toNode) {return null;}
	public Boolean hasCycles() {return null;}
	
	public List<GraphNode> getNodes() {return null;}
	public GraphNode getNode(String nodeValue) {return null;}
	
	public int fewestHops(GraphNode fromNode, GraphNode toNode) {return 0;}
	public int shortestPath(GraphNode fromNode, GraphNode toNode) {return 0;}

	public void addEdgeStr(String a, String b, int c) {}
	public List<GraphNode> getFewestHopsPath(GraphNode fromNode, GraphNode toNode) {return null;}
	public List<GraphNode> getShortestPath(GraphNode fromNode, GraphNode toNode) {return null;}
	
	
	
}
