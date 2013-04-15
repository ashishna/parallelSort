package com.expedia.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultiThreadedRecursiveSort {

	public static void main(String[] args) throws InterruptedException {
		List<Employee> empList = new ArrayList<>();
		for(int i=0;i<10;i++) {
			empList.add(new Employee("Abc", "xyz", (new Random().nextInt(500000) / 100)));
		}
		List<Employee> sortedList = mergeSort(empList);
		for(Employee e: sortedList) {
			System.out.println(e.getSalary());
		}
        
    }

	private static List<Employee> mergeSort(List<Employee> employeeList) throws InterruptedException  {
        if (employeeList.size() > 1) {
            int q = employeeList.size() / 2;

            final List<Employee>  leftList	 = employeeList.subList(0, q);
            final List<Employee>  rightList  = employeeList.subList(q, employeeList.size());

            Thread t1= new Thread() {
            	@Override
            	public void run() {
					try {
						mergeSort(leftList);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
            	}
        	};
        	t1.start();
         	//t1.join();
        	Thread t2 =  new Thread() {
             	public void run() {
					try {
						mergeSort(rightList);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
             	}
         	};
         	
         	t2.start();
        	t2.join();
        	return  SortUtil.merge(leftList,rightList);
        }
        return employeeList;
    }

}
