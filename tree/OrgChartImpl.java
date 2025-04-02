package tree;

import java.util.ArrayList;
import java.util.List;
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
		GenericTreeNode<



	}
	
	public void showOrgChartDepthFirst() {




	}
	
	public void showOrgChartBreadthFirst() {



		
	}
	
	public GenericTreeNode<Employee> findSupervisor(Employee employee) {



	}

	public GenericTreeNode<Employee> findEmployee(Employee employee) {

		

	}
	
	
}
