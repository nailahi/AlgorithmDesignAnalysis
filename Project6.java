package project6;


public class Project6 {

	public static void main(String[] args) {
		int[] testArray = {4,27,35,3, 8, 1, 3, 87, 98, 2};
		System.out.print("Intial Print: ");
		print(testArray, testArray.length);
		quicksort(testArray);
		System.out.print("QuickSort Test Print: ");
		print(testArray, testArray.length);
		quicksortHoarePartition(testArray);
		System.out.print("Hoare QuickSort Test Print: ");
		print(testArray, testArray.length);


	}
	public static void quicksort(int[] a ) {
		int high = a.length - 1;
		Swap(a, 0, high);
		partitionQS(a, 0, high);
		quickSort(a, 0, high);
	}


	public static void quicksortHoarePartition(int[] a) { 
		int high = a.length - 1;
		partitionH(a, 0, high);
		sortHP(a, 0, high);

	}


	public static void print(int[] a, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	//make two classes separately, Hoare and regular partion

	static void Swap(int[] a, int num1, int num2){
		int temp = a[num1];
		a[num1] = a[num2];
		a[num2] = temp;
	}


	static int partitionQS(int []a, int low, int high){
		int pivot = a[high];
		int i = (low - 1);

		for (int j = low; j <= high - 1; j++){
			if (a[j] <= pivot){
				i++; 
				Swap(a, i, j);
			}
		}
		Swap(a, i + 1, high);
		return (i + 1);
	}


	static void quickSort(int[] a, int low, int high){
		if (low < high) {
			int partIndex = partitionQS(a, low, high);

			quickSort(a, low, partIndex - 1);
			quickSort(a, partIndex + 1, high);
		}
	}
	
	static int partitionH(int[] a, int low, int high) {
		int pivot = a[low];
		int i = low - 1;
		int j = high + 1;
		while(true) {
			do { i++;
		}while (a[i]< pivot);
			do { j--;
			}while (a[j] > pivot);
			
			if(i >= j) 
				return j;
				int hold = a[i];
				a[i] = a[j];
				a[j] = hold;
			}
	}
	
	static void sortHP (int[]a , int low, int high) {
		if (low < high){
			int partIndex = partitionH( a, low, high);
			sortHP(a, low, partIndex - 1 );
			sortHP(a, partIndex + 1, high);
		}
	}
}