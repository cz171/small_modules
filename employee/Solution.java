package employee;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	//class里有一个directreport的list， string name， name是相当于id，独一无二），
	//然后实现method， input是employee ceo， string emp1, string emp2， 
	//找到emp1和emp2共同的manager。
	class Employee {
		List<Employee> directReport = new ArrayList<>();  //上报给此employee的人
		String name;
	}
	
	public List<Employee> contructTree() {
		Employee ceo = new Employee();
		ceo.name = "Mark";
		Employee staff0 = new Employee();
		staff0.name = "Jack";
		Employee staff1 = new Employee();
		staff1.name = "Marry";
		Employee staff2 = new Employee();
		staff1.name = "Jeff";
		
		ArrayList<Employee> subs = new ArrayList<>();
		subs.add(staff0);
		subs.add(staff1);
		subs.add(staff2);
		ceo.directReport = new ArrayList<>(subs);
		
		List<Employee> forTest = new ArrayList<>();
		forTest.add(ceo);
		forTest.add(staff0);
		forTest.add(staff1);
		forTest.add(staff2);
		return forTest;

		
		
	}
	
	public Employee lca(Employee ceo, Employee emp1, Employee emp2) {
		if (ceo == null || ceo == emp1 || ceo == emp2) {
			return ceo;
		}
		
		List<Employee> list = new ArrayList<>();
		for(Employee e: ceo.directReport) {
			if (lca(e, emp1, emp2) != null) {
				list.add(e); 
			}
		}
		
		if (list.size() == 2) {
			return ceo;
		}
		
		return list.size() == 1 ? list.get(0) : null;
	}
}
