package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OrgChartImpl implements OrgChart{

	//Employee is your generic 'E'..
	private List<GenericTreeNode<Employee>> nodes = new ArrayList<>();
	private GenericTreeNode<Employee> root = null;

	public void addRoot(Employee e) {
		// if there is no orgchart, start it

		if (root == null) {
			
			root = new GenericTreeNode<Employee>(e);

			nodes.add(root);

		} else {

			root.data = e;

		}

	}
	
	public void clear() {
		// get rid of the org chart

		nodes.clear();

		root = null;


	}

	public void addDirectReport(Employee manager, Employee newPerson) {
		// add the newPerson as a direct report (child) of manager
		GenericTreeNode<Employee> managerNode = findEmployee(manager);

		if (managerNode == null) {

			return;

		}

		managerNode.addChild(new GenericTreeNode<Employee>(newPerson));

	}
	
	public void removeEmployee(Employee firedPerson) {
		// remove the employee, give their direct reports to their supervisor
		GenericTreeNode<Employee> supervisor = findSupervisor(firedPerson);

		if (supervisor != null) {

			supervisor.removeChild(firedPerson);

		}

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
	
	private GenericTreeNode<Employee> findSupervisor(Employee employee) {

		for (GenericTreeNode<Employee> node : nodes) {

			for (GenericTreeNode<Employee> child : node.children) {

				if (child.data.equals(employee)) return node;

			}

		}
		
		return null;

	}

	private GenericTreeNode<Employee> findEmployee(Employee employee) {

		for (GenericTreeNode<Employee> node : nodes) {

			if (node.data.equals(employee)) return node;

		}

		return null;

	}
	
}
