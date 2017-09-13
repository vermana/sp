package sort;

public class BubbleSort {

	public static void main(String[] args) {

		int arr[] = { 9, 2, 4, 6, 7, 98, 200, 1 };
		
		int Comparisons =0;

		for (int i = 0; i < arr.length; i++)

		{

			for (int j = 0; j < (arr.length - i) - 1; j++)

			{

				Comparisons++;
				if (arr[j] > arr[j + 1]) {
					int a = arr[j];

					arr[j] = arr[j + 1];

					arr[j + 1] = a;
				}
			}

		}

		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);

		
		System.out.println("Total comparison: " + Comparisons);
	}

}
