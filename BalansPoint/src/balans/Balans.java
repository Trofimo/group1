package balans;

public class Balans {

	public int balans(int[] a) {
		int i = 0;
		int j = a.length - 1;
		int sumLeft = 0;
		int sumRight = 0;

		while (i <= j) {

			if (sumLeft < sumRight) {
				sumLeft = sumLeft + a[i];
				i++;
			} else {
				sumRight = sumRight + a[j];
				j--;
			}

		}
		
		System.out.println("i=" + i + "  j=" + j + " L=" + sumLeft + " R=" + sumRight);

		return (sumLeft != sumRight) ? -1 : j;

	}
}