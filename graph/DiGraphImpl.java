package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
 

public class DiGraphImpl implements DiGraph{

	private List<GraphNode> nodeList = new ArrayList<>();

	public Boolean addNode(GraphNode node) {
		
		if (getNode(node.getValue()) != null) return false;

		nodeList.add(node);
		
		return true;
	
	}

	public Boolean removeNode(GraphNode node) {

		GraphNode removeNode = getNode(node.getValue());

		if (removeNode != null) {

			nodeList.forEach(g -> {
				if (nodesAreAdjacent(g, node)) removeEdge(g, node);
			});

			nodeList.remove(removeNode);

			return true;
		
		}

		return false;

	}

	public Boolean setNodeValue(GraphNode node, String newNodeValue) {

		GraphNode updateNode = getNode(node.getValue());

		if (updateNode != null) {

			updateNode.setValue(newNodeValue);
			return true;

		}

		return false;

	}
	
	public String getNodeValue(GraphNode node) {

		GraphNode newNode = getNode(node.getValue());

		if (newNode != null) {

			return newNode.getValue();

		}

		return null;

	}
	
	public Boolean addEdge(GraphNode fromNode, GraphNode toNode, Integer weight) {return null;}
	public Boolean removeEdge(GraphNode fromNode, GraphNode toNode) {return null;}
	public Boolean setEdgeValue(GraphNode fromNode, GraphNode toNode, Integer newWeight) {return null;}
	public Integer getEdgeValue(GraphNode fromNode, GraphNode toNode) {return null;}

	public List<GraphNode> getAdjacentNodes(GraphNode node) {return null;}
	public Boolean nodesAreAdjacent(GraphNode fromNode, GraphNode toNode) {return null;}
	public Boolean nodeIsReachable(GraphNode fromNode, GraphNode toNode) {
		
		GraphNode start = getNode(fromNode.getValue());
		GraphNode goal = getNode(fromNode.getValue());
		
		Queue<GraphNode> checkQueue = new LinkedList<>();
		HashSet<GraphNode> checkedNodes = new HashSet<>();
		
		checkQueue.add(start);
		start.getNeighbors().forEach(g -> checkQueue.add(g));
		
		GraphNode cur;
		while (!checkQueue.isEmpty()) {
			cur = checkQueue.remove();
			if (cur.getNeighbors().contains(goal)) {
				return true;
			} else {
				if (!cur.getNeighbors().isEmpty() && !checkedNodes.contains(cur)) {
					cur.getNeighbors().forEach(g -> checkQueue.add(g));
				}
			}
			checkedNodes.add(cur);
		}
		return false;
	}
	public Boolean hasCycles() {return null;}
	

	public List<GraphNode> getNodes() {

		return nodeList;

	}

	public GraphNode getNode(String nodeValue) {
		
		for (GraphNode node : nodeList) {

			if (node.getValue().equals(nodeValue)) return node;

		}

		return null;
	
	}

	
	public int fewestHops(GraphNode fromNode, GraphNode toNode) {

		return getFewestHopsPath(fromNode, toNode).size() - 1;

	}

	public int shortestPath(GraphNode fromNode, GraphNode toNode) {
		
		return getShortestPath(fromNode, toNode).size() - 1;
	
	}

	public void addEdgeStr(String a, String b, int c) {

		GraphNode aNode = getNode(a); GraphNode bNode = getNode(b);
		if (aNode != null && bNode != null) aNode.addNeighbor(bNode, c);

	}

	public List<GraphNode> getFewestHopsPath(GraphNode fromNode, GraphNode toNode) {return null;}
	public List<GraphNode> getShortestPath(GraphNode fromNode, GraphNode toNode) { return null;
	}
	
	
	
}
