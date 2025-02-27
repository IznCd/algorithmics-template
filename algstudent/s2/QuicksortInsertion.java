package algstudent.s2;

/* This program is used to order n elements with Quicksort */
public class QuicksortInsertion {
	static int[] v;
	/*get the position of the median of the three (left, right and 
	 the element which position is in the center between them, and
	 move the elements to order them */
	public static int median_of_three(int[] a, int left, int right) { 
		int center = (left + right) / 2;
		if (a[left] > a[center])
			Vector.interchange(a, left, center);
		if (a[left] > a[right])
			Vector.interchange(a, left, right);
		if (a[center] > a[right])
			Vector.interchange(a, center, right);
		return center;
	}
	
	public static void quicksort(int[] a, int k) {
		quicksort(a, 0, a.length-1, k);
	}
	
	public static void quicksort(int[] a, int left, int right, int k) {
		if (left < right){ //if there is one element it is not necessary
			if ((right - left) <= k){ 
				Insertion.insertionv2(a, left, right);		
			} else {
				// Use Quicksort for larger subarrays
                int center = median_of_three(a, left, right);
                int pivot = a[center]; // Choose the pivot
                Vector.interchange(a, center, right); // Hide the pivot

                int i = left;
                int j = right - 1;

                do {
                    while (a[i] <= pivot && i < right) i++; // First element > pivot
                    while (a[j] >= pivot && j > left) j--; // First element < pivot
                    if (i < j) Vector.interchange(a, i, j);
                } while (i < j); // End while

                // Place the pivot in its correct position
                Vector.interchange(a, i, right);

                // Recursively sort the left and right subarrays
                quicksort(a, left, i - 1, k);
                quicksort(a, i + 1, right, k);
			} //else
		} //if
	}

//
//	public static void main(String arg[]) {
//		int n = Integer.parseInt(arg[0]); //size of the problem
//		v = new int[n];
//
//		Vector.sorted(v);
//		System.out.println("VECTOR TO BE SORTED");
//		Vector.print(v);
//		quicksort(v);
//		System.out.println("SORTED VECTOR");
//		Vector.print(v);
//
//		Vector.reverseSorted(v);
//		System.out.println("VECTOR TO BE SORTED");
//		Vector.print(v);
//		quicksort(v);
//		System.out.println("SORTED VECTOR");
//		Vector.print(v);
//
//		Vector.randomSorted(v);
//		System.out.println("VECTOR TO BE SORTED");
//		Vector.print(v);
//		quicksort(v);
//		System.out.println("SORTED VECTOR");
//		Vector.print(v);
//	} 

}
