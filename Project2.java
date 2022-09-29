package project2;



public class Project2 {

	public static void main(String[] args) {
		
	}


	public static void insertionSort(int[] a) {
		System.out.println("Start insertion Sort");
		for (int j = 1; j < a.length; j++) {
			int key = a[j];
			int i = j-1;

			while (i >= 0 && a[i]> key) {
				a[i +1] =a[i];
				i = i -1;
			}
			a[i +1]= key;
		}
	}

	public static void mergeSort(int[] a) {
		System.out.println("Start merge Sort");
		sort( a, 0, (a.length-1));

	}

	static void merge(int a[], int left, int middle, int right ){

		int temp1, temp2;
		temp1 = middle - left +1;
		temp2 = right - middle;

		int [] Left = new int[temp1];
		int [] Right = new int[temp2];

		for (int i = 0; i < temp1; ++i) {
			Left[i] = a[left +i];
		}

		for(int j = 0; j < temp2; ++j) {
			Right[j] = a[middle + 1 +j];
		}

		int i, j, key;
		i = 0;
		j = 0;
		key = left;

		while(i < temp1 && j < temp2) {
			if(Left[i] <= Right[j]) {
				a[key] = Left[i];
				i++;
			}else {
				a[key] = Right[j];
				j++;
			}
			key++;
		}

		while (i < temp1) {
			a[key] = Left[i];
			i++;
			key++;
		}
		
		while (j < temp2) {
			a[key] = Right[j];
			j++;
			key++;
		}
		

	}

	static void sort(int arr[], int left, int right)
    {
        if (left < right) {
            int mid =left+ (right-left)/2;
 
            sort(arr, left, mid);
            sort(arr, (mid + 1), right);
 
            merge(arr, left, mid, right);
        }
    }



}

