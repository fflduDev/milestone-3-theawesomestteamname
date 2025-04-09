package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
	public Boolean nodeIsReachable(GraphNode fromNode, GraphNode toNode) {return null;}
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
	public List<GraphNode> getShortestPath(GraphNode fromNode, GraphNode toNode) {

		/**
         *  Each time a node is traversed, new PathedNode is created with previous node 
         *  and total path weight. Allows pairing of node, weight, and traceable path.
         */
        class PathedNode {

            GraphNode node;
            PathedNode prev;
            Double weight;

            /**
             *  Constructor for starting node. Separate constructors so if-statement doesn't
             *  need to run each instantiation. Probably saves negative time.
             */
            PathedNode(GraphNode node, Double weight) {

                this.node = node;
                this.prev = null;
                this.weight = weight;

            }

            PathedNode(GraphNode node, PathedNode prev, Double weight) {

                this.node = node;
                this.prev = prev;
                this.weight = prev.weight + weight;

            }

        }

        //  Handle start and destinations being the same
        if (toNode == this) return new ArrayList<>(Arrays.asList(this));

        //  Queue of paths to keep following/searching
        Queue<PathedNode> nodeQueue = new LinkedList<>();

        //  Possible optimization? Map stores the smallest weight a node can be reached at.
        //  If any path to that node has greater weight, that path is ignored.
        Map<GraphNode,Double> minWeights = new HashMap<>();

        PathedNode initPathedNode = new PathedNode(this, 0.0);

        //  Init queue with children of starting node
        nodeWeights.entrySet().forEach(entry -> {

            nodeQueue.add(new PathedNode(entry.getKey(), initPathedNode, entry.getValue()));

            minWeights.put(entry.getKey(), entry.getValue());

        });


        PathedNode cur;

        //  Stores smallest weight to reach destination of all paths discovered.
        //  If any path is greater than this weight, it is ignored.
        //  Inits to NaN as all doubles compare less than, so all paths are valid until one is found.
        Double maxWeight = Double.NaN;

        //  Store PathedNode of the destination node of the smallest-weight path.
        //  Allows for retracing path at end.
        PathedNode shortestPath = null;

        //  All new paths become invalid when every possible 
        //  path is longer than shortest discovered path.
        //  At that point, shortest discovered path is shortest path, 
        //  so every path remaining in queue is skipped.
        while (!nodeQueue.isEmpty()) {

            cur = nodeQueue.remove();

            //  Must be a valid path
            if (cur.weight.compareTo(maxWeight) < 0) {

                //  Reached destination logic
                if (cur.node == toNode) {

                    maxWeight = cur.weight;

                    shortestPath = cur;

                }

                //  Adding children of current node to queue with proper weights.
                //  Only adds new nodes if path to new node is better than previously found paths.
                for (Entry<WeightedNode,Double> childEntry : cur.node.nodeWeights.entrySet()) {

                    if (!minWeights.containsKey(childEntry.getKey()) || minWeights.get(childEntry.getKey()) > cur.weight + childEntry.getValue())

                        nodeQueue.add(new PathedNode(childEntry.getKey(), cur, childEntry.getValue()));

                        minWeights.put(childEntry.getKey(), cur.weight + childEntry.getValue());

                }

            }

        }

        //  Constructing list of nodes on path by retracing PathedNodes.
        //  List is built from destination to start, so needs to be reversed.
        List<WeightedNode> toReturn = new ArrayList<>();

        PathedNode loopCur = shortestPath;

        while (loopCur != null) {

            toReturn.add(loopCur.node);
            loopCur = loopCur.prev;

        }

        return toReturn.reversed();



	}
	
	
	
}
