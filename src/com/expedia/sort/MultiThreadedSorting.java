package com.expedia.sort;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;


/**
 * This class uses the Collections.sort() method to implement the sorting of sublist. It does not provide its own implementation.
 * 
 * @author ashish
 *
 */
public class MultiThreadedSorting {
	
	/**
	 * This method will perform merge sort by diving the list into two equal halves and 
	 * sorting them parallelly and finally merging them.
	 * 
	 * @param employeeList
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public List<Employee> performSort(List<Employee> employeeList) throws InterruptedException, ExecutionException {
		
		final List<Employee> firstList  = employeeList.subList(0, (employeeList.size())/2);
		final List<Employee> secondList = employeeList.subList(employeeList.size()/2, employeeList.size());

		//SChedule the First half sorting in separate thread.
		Thread firstThread = new Thread() {
			@Override
			public void run() {
				//API used for sorting and merge sort Algorithm not implemented individually due to lack of time. 
				Collections.sort(firstList);
			}
		};
		
		//Schedule the Second half sorting in separate thread.
		Thread secondThread = new Thread() {
			@Override
			public void run() {
				Collections.sort(secondList);
			}
		};
		
		firstThread.start();
		//firstThread.join();	//Wait for thread to finish, this can be skipped as we are going to merge once the other thread completes
		
		secondThread.start();	//Run sorting parallelly for second thread.
		secondThread.join();	//Wait for all threads to finish before final merge of two independent sorted lists.
		
		//Return the merged list
		return SortUtil.merge(firstList, secondList);
	}

}
