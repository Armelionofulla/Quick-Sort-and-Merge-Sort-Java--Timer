
# Sorting Program


## Description
This Java program demonstrates two popular sorting algorithms: Merge Sort and Quick Sort. It generates an array of random numbers, sorts it using both algorithms, and measures the time taken for each sorting process.
## Features
* Merge Sort implementation
* Quick Sort implementation
* Random number generation and file I/O
* Performance measurement for sorting algorithms
## Usage
1-Run the Program:
* Compile and run the Sorting.java file using a Java compiler.
  
2-Input:
* Enter the size of the array when prompted.
  
3-Output:

* The program generates a file named numbers.txt with randomly generated numbers.
* It then performs Merge Sort and Quick Sort on the array and outputs the time taken for each sorting algorithm.
## File Operations
* **writeRandomNumbers(int n):** Writes n randomly generated numbers to a file named **numbers.txt.**
* **readRandomNumbers(int n)**: Reads n numbers from the **numbers.txt** file.
## Sorting Algorithms
### Merge Sort
* **mergeSort(int[] array, int start, int end):** Recursively sorts the array using the merge sort algorithm.
* **mergeTwoSides(int[] left, int[] right**:Merges two sorted arrays into a single sorted array.
### Quick Sort
* **quickSort(int[] array, int start, int end):** Recursively sorts the array using the quick sort algorithm
* **split(int[] array, int start, int end):** Partitions the array into two parts and returns the index where the partition occurs.
## Error Handling
* The program checks for positive input for the array size.
* Errors during file operations are caught and printed to the console.
## Example
```
Enter the array size: 10
Time taken for sorting an array of size 10:
Merge Sort: 0.123 ms
Quick Sort: 0.045 ms

```

## Dependencies
* Java Runtime Environment (JRE)
