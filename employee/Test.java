package employee;

import employee.Solution.Employee;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		List<Employee> list = s.contructTree();
		Employee manager0 = s.lca(list.get(0), list.get(1), list.get(2));
		Employee manager1 = s.lca(list.get(0), list.get(0), list.get(2));
		System.out.println(manager0.name);
		System.out.println(manager1.name);


	}

}
