/*******************************************************

Author : K Pradeepkumar Reddy
Date : 03-01-2016
Program : Sorting Algorithms Benchmarking Application

********************************************************/ 

class SortingAlgorithms{
	public static void bubbleSort(int[] arr){
		int temp;
		boolean flag=true;
				
		for(int i=1; i<arr.length; i++){
			flag=true;
			for(int j=0; j<(arr.length-i); j++){
				if(arr[j] > arr[j+1]){
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					flag=false;
				}
			}
			if(flag){
				return;
			}
		}
	}
	public static void selectionSort(int[] arr){
		int temp;
				
		for(int i=0; i<arr.length; i++){
			for(int j=i+1; j<arr.length; j++){
				if(arr[i] > arr[j]){
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
	public static void insertionSort(int[] arr){
		for(int i=1; i<arr.length; i++){
			for(int j=0; j<i; j++){
				if(arr[i] < arr[j])
					insert(arr,j,i);  
			}
		}
	}
	// insert i element before j element in array. This method is used for insertion sort.
	private static void insert(int[] arr, int j, int i){
		int temp = arr[i];
		for(int k=i-1; k>=j; k--)
			arr[k+1] = arr[k];
		arr[j] = temp;
	}
	private static void swap(int[] arr, int i, int j){
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
	public static void quickSort(int[] arr, int low, int high){
		int pivot, i, j;
		
		if(low < high){
			pivot=arr[low];
			i = low+1;
			j = high;
			while(i <= j){
				while((i <= high)&&(arr[i] <= pivot))
					i++;
				while((j >= low)&&(arr[j] > pivot))
					j--;
				if(j > i)
					swap(arr, i, j);
			}
			
			swap(arr,j,low);	// position of the pivot element is finalized.
			quickSort(arr, low, j-1);
			quickSort(arr, j+1, high);	
		}
	}
	public static void mergeSort(int[] arr, int len){
		int[] list1 = new int[len/2];
		int[] list2 = new int[((len%2)!=0)?(len/2)+1:len/2];
		
		if(len > 1){
			for(int i=0; i<len/2; i++)
				list1[i] = arr[i];
			for(int i=0, j=len/2; j < len; j++,i++)
				list2[i] = arr[j];
		
			mergeSort(list1, list1.length);
			mergeSort(list2, list2.length);
			
			int i=0, j=0, k=0;
			while((i<list1.length)&&(j<list2.length)){
				if(list1[i] < list2[j])
					arr[k++] = list1[i++];
				else
					arr[k++] = list2[j++];
			}
			while(i<list1.length){
				arr[k++] = list1[i++];
			}	
			while(j<list2.length){
				arr[k++] = list2[j++];
			}	
		}
	}
	public static int[] heapSort(int[] arr){
		int i=0,len=arr.length;
		int[] sorted = new int[arr.length];
		
		while(len>1){
			buildMinHeap(arr, len); // Minheap : all the parent nodes will have 'value' less than their children. 
			sorted[i++] = arr[0];
			arr[0] = arr[len-1];
			len--;
		}
		sorted[i] = arr[0]; // only one element left in the array
		
		return sorted;
	}
	/* This method is used in heap sort  */
	private static void buildMinHeap(int[] arr, int len){
		int temp, child1, child2;
		for(int parent=0; parent<len/2; parent++){ // len/2 gives the last parent node having children
			child1 = (2*parent)+1;
			child2 = (2*parent)+2;
			temp = parent;
			while(parent >= 0){
				if(arr[parent] > arr[child1]){
					if((child2<len)&&(arr[child2] < arr[child1])){
						swap(arr, parent, child2);
					}
					else{
						swap(arr, parent, child1);
					}
				}else if((child2<len)&&(arr[parent] > arr[child2])){
					swap(arr, parent, child2);
				}else{ // when the parent's 'value' is less than both of its children, break from inner loop
					break;
				}
				if((parent%2)==0){  // after swapping, set the nodes for further checking towards root of the tree 
					child2 = parent;
					child1 = parent-1;
					parent = (parent/2) - 1;
				}else{
					child1 = parent;
					child2 = parent+1;
					parent = parent/2;
				}
			}
			parent = temp;
		}
	}
	public static void shellSort(int[] arr){
		int subListLen = arr.length/2;
		while(subListLen > 0){
			for(int i=0; i<subListLen; i++){
				gapInsertionSort(arr, i, subListLen);
			}
			subListLen /= 2;
		}
	}
	/* This method is used in shellSort() */ 
	private static void gapInsertionSort(int[] arr, int start, int gap){
		int position, currentValue;
		for(int i=start+gap; i<arr.length; i+=gap){
			currentValue = arr[i];
			position = i;
				
			while((position >= gap) && (arr[position-gap] > currentValue)){
				arr[position] = arr[position-gap];
				position -= gap;
			}
			arr[position] = currentValue;
		}
	}
}