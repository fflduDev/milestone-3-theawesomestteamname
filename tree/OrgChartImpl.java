package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public class OrgChartImpl implements OrgChart{

	//Employee is your generic 'E'..
	private List<GenericTreeNode<Employee>> nodes = new ArrayList<>();
	private GenericTreeNode<Employee> root = null;

	public void addRoot(Employee e) {
		// if there is no orgchart, start it

		if (root == null) {
			
			root = new GenericTreeNode<Employee>(e);
			nodes.add(root);
			
		}

	}
	
	public void clear() {
		// get rid of the org chart
		nodes.clear();


	}

	public void addDirectReport(Employee manager, Employee newPerson) {
		// add the newPerson as a direct report (child) of manager
		GenericTreeNode<Employee> managerNode = findEmployee(manager);
		GenericTreeNode<Employee> newNode = findEmployee(newPerson);

		if (managerNode == null) {

			return;

		}

		if (newNode == null) {

			newNode = new GenericTreeNode<Employee>(newPerson);

		}

		managerNode.addChild(managerNode);

	}
	
	public void removeEmployee(Employee firedPerson) {
		// remove the employee, give their direct reports to their supervisor
		//GenericTreeNode<



	}
	
	public void showOrgChartDepthFirst() {
		showOrgChartDepthFirstRecursive(root);
	}
	
	public void showOrgChartDepthFirstRecursive(GenericTreeNode<Employee> e) {
		if (e.children.isEmpty() == false) e.children.forEach(i -> showOrgChartDepthFirstRecursive(i));
		System.out.println(e.data.getName());
	}
	
	public void showOrgChartBreadthFirst() {
		Queue<GenericTreeNode<Employee>> stack = new LinkedList<>();
		
		stack.add(root);
		GenericTreeNode<Employee> cur;
		
		while (!stack.isEmpty()) {
			cur = stack.remove();
			System.out.println(cur.data.getName());
			
			if (cur.children.isEmpty() == false) {
				cur.children.forEach(i -> stack.add(i));
			}
		}
		
	}
	
	public GenericTreeNode<Employee> findSupervisor(Employee employee) {


	}

	public GenericTreeNode<Employee> findEmployee(Employee employee) {
		
		for (GenericTreeNode<Employee> node : nodes) {
			if (node.data.equals(employee)) return node;
		}
		return null;

	}
	
	
}
