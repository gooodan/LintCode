public class Code_08_NetherlandsFlag {

	public static int[] patition(int[] arr, int l, int r, int p) {
		less = l - 1;
		more = r + 1;

		while (l < more) {
			if (arr[l] < p) {
				swap(arr, ++less, l++);
			} else if (arr[l] > p) {
				swap(arr, --more, l);
			} else {
				l++;
			}
		}
		return new int[] {less + 1, more - 1};
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}