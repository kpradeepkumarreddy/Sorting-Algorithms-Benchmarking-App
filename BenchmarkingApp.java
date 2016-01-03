/*******************************************************

Author : K Pradeepkumar Reddy
Date : 03-01-2016
Program : Sorting Algorithms Benchmarking Application

********************************************************/ 

import java.util.*;

class BenchmarkingApp{
	public static void main(String[] args){
		while(true){
			System.out.println("\t@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("\n\t@@@  Sorting Algorithms Benchmarking App  @@@\n");
			System.out.println("\t@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			int arrSize;
			while(true){
				try{
					System.out.print("Enter array size : ");
					Scanner scanner = new Scanner(System.in);
					arrSize = scanner.nextInt();
					break;
				}catch(InputMismatchException inMisEx){
					System.out.println("enter a valid number for array size");
					continue;
				}
			}// end of Array size input loop
			
			int[] arr = new int[arrSize];
			int complexity;
			/* start of complexity selection loop */
			while(true){
				try{
					System.out.println("\n1) Best Case");
					System.out.println("2) Average Case");
					System.out.println("3) Worst Case");
					System.out.print("Choose Complexity : ");
					Scanner scanner = new Scanner(System.in);
					complexity = scanner.nextInt();
					
				}catch(InputMismatchException inMisEx){
					System.out.println("Invalid input. Please enter a number of the menu item");
					continue;
				}
				System.out.println();
				switch(complexity){
					case 1:
							for(int i=0; i<arr.length; i++){
								arr[i] = i+1;
							}
							String str1 ="Ascending sorted array of size "+arrSize+" created for best case.";
							for(int i=0; i<str1.length(); i++)
								System.out.print("*");
							System.out.println("\n"+str1);
							for(int i=0; i<str1.length(); i++)
								System.out.print("*");
							System.out.println();
							break;
					case 2:
							Random r = new Random();
							for(int i=0; i<arr.length; i++){
								arr[i] = r.nextInt(arrSize);
							}
							String str2 ="Random array of size "+arrSize+" created for average case.";
							for(int i=0; i<str2.length(); i++)
								System.out.print("*");
							System.out.println("\n"+str2);
							for(int i=0; i<str2.length(); i++)
								System.out.print("*");
							System.out.println();
							break;
					case 3:
							for(int i=arrSize,j=0; j<arr.length; i--,j++){
								arr[j] = i;
							}
							String str3 ="Descending sorted array of size "+arrSize+" created for worst case.";
							for(int i=0; i<str3.length(); i++)
								System.out.print("*");
							System.out.println("\n"+str3);
							for(int i=0; i<str3.length(); i++)
								System.out.print("*");
							System.out.println();
							break;
					default:
							System.out.println("Invalid input. Please enter a number of the menu item");
							continue;
				}
				break;
			} // end of complexity selection loop
			
			/* start of sorting algorithm selection menu loop */
			while(true){
				int algorithmSelect;
				try{
					System.out.println("\n1) Bubble Sort");
					System.out.println("2) Selection Sort");
					System.out.println("3) Insertion Sort");
					System.out.println("4) Quick Sort");
					System.out.println("5) Merge Sort");
					System.out.println("6) Heap Sort");
					System.out.println("7) Shell Sort");
					System.out.println("8) Benchmark All");
					System.out.println("9) Start Over Again");
					System.out.println("10) Exit");
					System.out.print("Choose an option : ");
					Scanner scanner = new Scanner(System.in);
					algorithmSelect = scanner.nextInt(); 
			}catch(InputMismatchException inMisEx){
				System.out.println("Invalid input. Please enter a number of the menu item"+inMisEx);
				continue;
			}
						
			if(algorithmSelect == 9)
				break;
			int[] cloneArr = arr.clone();
			
			long startTime=0,stopTime=0;
			switch(algorithmSelect){
				case 1:
						startTime = System.currentTimeMillis();
						SortingAlgorithms.bubbleSort(cloneArr); 
						stopTime = System.currentTimeMillis();
						System.out.println("\n\t Bubble Sort Completed in "+(stopTime - startTime)+" milli seconds.");
						break;
				case 2:
						startTime = System.currentTimeMillis();
						SortingAlgorithms.selectionSort(cloneArr); 
						stopTime = System.currentTimeMillis();
						System.out.println("\n\t Selection Sort Completed in "+(stopTime - startTime)+" milli seconds.");
						break;
				case 3:
						startTime = System.currentTimeMillis();
						SortingAlgorithms.insertionSort(cloneArr); 
						stopTime = System.currentTimeMillis();
						System.out.println("\n\t Insertion Sort Completed in "+(stopTime - startTime)+" milli seconds.");
						break;
				case 4:
						startTime = System.currentTimeMillis();
						SortingAlgorithms.quickSort(cloneArr, 0, cloneArr.length-1); 
						stopTime = System.currentTimeMillis();
						System.out.println("\n\t Quick Sort Completed in "+(stopTime - startTime)+" milli seconds.");
						break;
				case 5:
						startTime = System.currentTimeMillis();
						SortingAlgorithms.mergeSort(cloneArr, cloneArr.length); 
						stopTime = System.currentTimeMillis();
						System.out.println("\n\t Merge Sort Completed in "+(stopTime - startTime)+" milli seconds.");
						break;
				case 6:
						startTime = System.currentTimeMillis();
						SortingAlgorithms.heapSort(cloneArr); 
						stopTime = System.currentTimeMillis();
						System.out.println("\n\t Heap Sort Completed in "+(stopTime - startTime)+" milli seconds.");
						break;
				case 7:
						startTime = System.currentTimeMillis();
						SortingAlgorithms.shellSort(cloneArr); 
						stopTime = System.currentTimeMillis();
						System.out.println("\n\t Shell Sort Completed in "+(stopTime - startTime)+" milli seconds.");
						break;
				case 8:
						benchmarkAll(arr);
						break;
				case 10:
						System.exit(0);
						break;
				default:
						System.out.println("\nInvalid input. Please enter a number of the menu item");
						continue;
				}// end of switch statement
			} //end of sorting menu loop
		}// end of start over loop
	}// end of main method
	
	/*  Method to calculate the time consumption of all sorting algorithms  */
	static void benchmarkAll(int[] arr) {
		long startTime=0, stopTime=0;
		int[] cloneArr = arr.clone();
		System.out.println("\n\t@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("\t Summary of time consumption of all sorting algorithms");
		System.out.println("\t@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
		
		startTime = System.currentTimeMillis();
		SortingAlgorithms.bubbleSort(cloneArr); 
		stopTime = System.currentTimeMillis();
		System.out.println("\t1) Bubble Sort Completed in "+(stopTime - startTime)+" milli seconds.");
				
		cloneArr = arr.clone();
		startTime = System.currentTimeMillis();
		SortingAlgorithms.selectionSort(cloneArr); 
		stopTime = System.currentTimeMillis();
		System.out.println("\t2) Selection Sort Completed in "+(stopTime - startTime)+" milli seconds.");
		
		cloneArr = arr.clone();
		startTime = System.currentTimeMillis();
		SortingAlgorithms.insertionSort(cloneArr); 
		stopTime = System.currentTimeMillis();
		System.out.println("\t3) Insertion Sort Completed in "+(stopTime - startTime)+" milli seconds.");
		
		cloneArr = arr.clone();
		startTime = System.currentTimeMillis();
		SortingAlgorithms.quickSort(cloneArr, 0, cloneArr.length-1); 
		stopTime = System.currentTimeMillis();
		System.out.println("\t4) Quick Sort Completed in "+(stopTime - startTime)+" milli seconds.");
		
		cloneArr = arr.clone();
		startTime = System.currentTimeMillis();
		SortingAlgorithms.mergeSort(cloneArr, cloneArr.length); 
		stopTime = System.currentTimeMillis();
		System.out.println("\t5) Merge Sort Completed in "+(stopTime - startTime)+" milli seconds.");
		
		cloneArr = arr.clone();
		startTime = System.currentTimeMillis();
		SortingAlgorithms.heapSort(cloneArr); 
		stopTime = System.currentTimeMillis();
		System.out.println("\t6) Heap Sort Completed in "+(stopTime - startTime)+" milli seconds.");
		
		cloneArr = arr.clone();
		startTime = System.currentTimeMillis();
		SortingAlgorithms.shellSort(cloneArr); 
		stopTime = System.currentTimeMillis();
		System.out.println("\t7) Shell Sort Completed in "+(stopTime - startTime)+" milli seconds.");
		System.out.println();
	}
}