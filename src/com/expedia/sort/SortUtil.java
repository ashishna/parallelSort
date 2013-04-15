package com.expedia.sort;

import java.util.ArrayList;
import java.util.List;

public class SortUtil {

	
	/**
	 * This method is used to merge the already sorted two lists.
	 * 
	 * @param leftList
	 * @param rightList
	 * @return
	 */
	public static List<Employee> merge(List<Employee> leftList, List<Employee> rightList) {
		
		//Final list containing individually merged items.
		List<Employee> finalList = new ArrayList<>(leftList.size() + rightList.size());
		int total = leftList.size() + rightList.size();
		int indexLeft = 0;
		int indexRight = 0;
		int finalIndex = 0;
		
		
		//Merge the sorted elements in another list.
		while(finalIndex < total) {
			if(indexLeft < leftList.size()  && indexRight < rightList.size()) {
				if(leftList.get(indexLeft).getSalary() < rightList.get(indexRight).getSalary()) {
					Employee e = leftList.get(indexLeft++);
					finalList.add(e);
					finalIndex++;
				} else {
					Employee e = rightList.get(indexRight++);
					finalList.add(e);
					finalIndex++;
				} 
			} else {
				//Left List is over, copy all the elements from Right list.
				if(indexLeft >= leftList.size()) {
					while(indexRight < rightList.size()) {
						Employee e = rightList.get(indexRight++);
						finalList.add(e);
						finalIndex++;
					}
				}
				//Right List is over, copy all the elements from Left list.
				if(indexRight >= rightList.size()) {
					while(indexLeft < leftList.size()) {
						Employee e = leftList.get(indexLeft++);
						finalList.add(e);
						finalIndex++;
					}
				}
			}
		}
		return finalList;
	}
}
