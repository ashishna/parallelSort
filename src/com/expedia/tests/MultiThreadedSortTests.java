package com.expedia.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.expedia.sort.Employee;
import com.expedia.sort.MultiThreadedSorting;

public class MultiThreadedSortTests {

	private List<Employee> employeeList = null;
	private MultiThreadedSorting multiThreadedSorting;
	
	@Before
	public void setup() {
		//Put some random numbers in the list's salary field.
		multiThreadedSorting = new MultiThreadedSorting();
	}
	
	@Test
	public void testMergeSortForEqualElements() throws Exception {
		populateList(1000);
		List<Employee> empList = multiThreadedSorting.performSort(employeeList);
		Assert.assertNotNull(empList);
		Assert.assertEquals(employeeList.size(), empList.size());
	}
	
	@Test
	public void testMergeOddNumberOfElements() throws Exception {
		populateList(199);
		List<Employee> empList = multiThreadedSorting.performSort(employeeList);
		Assert.assertNotNull(empList);
		Assert.assertEquals(employeeList.size(), empList.size());
	}
	
	@Test
	public void testSingleElementList() throws Exception {
		populateList(1);
		List<Employee> empList = multiThreadedSorting.performSort(employeeList);
		Assert.assertNotNull(empList);
		Assert.assertEquals(employeeList.size(), empList.size());
		Assert.assertEquals(employeeList.get(0).getSalary(), empList.get(0).getSalary());
	}
	
	@Test
	public void testMergeSortWithMinMaxValues() throws Exception {
		employeeList = null;
		employeeList = new ArrayList<>();
		employeeList.add(new Employee("Abc", "XYZ", 1300));
		employeeList.add(new Employee("Abc", "XYZ", 1100));
		employeeList.add(new Employee("Abc", "XYZ", 1600));
		employeeList.add(new Employee("Abc", "XYZ", 1800));
		employeeList.add(new Employee("Abc", "XYZ", 100));
		
		List<Employee> sortedList = multiThreadedSorting.performSort(employeeList);
		Assert.assertNotNull(sortedList);
		Assert.assertEquals(employeeList.size(), sortedList.size());
		Assert.assertEquals(sortedList.get(0).getSalary(), 100);
		Assert.assertEquals(sortedList.get(4).getSalary(), 1800);
	}
	
	private void populateList(int noOfSamples) {
		employeeList = new ArrayList<>();
		Random random = new Random();
		for(int i=0;i < noOfSamples;i++) {
			employeeList.add(new Employee("Abc", "xyz", (random.nextInt(500000) / 100)));	
		}
	}
	
	@After
	public void tearDown() {
		employeeList = null;
	}
}
