package L4.sorting;

public class Sort {
	public static int getPow(int num, int pow) {
		return pow == 1 ? num : num * getPow(num, --pow);
	}

	public static int getGCD(int num1, int num2) {
		int left;
		if (num1 < num2) {
			left = num2 % num1;
		} else {
			left = num1 % num2;
		}
		return left == 0 ? num2 : getGCD(num1, left);
	}

	public static int binarySearch(int[] sortedArr, int sought) {
		int from = 0;
		int to = sortedArr.length - 1;
		while (from <= to) {
			int cursor = (from + to) / 2;
			var current = sortedArr[cursor];
			if (current == sought) {
				return cursor;
			} else if (current < sought) {
				from = cursor + 1;
			} else {
				to = cursor - 1;
			}
		}
		return -1;
	}

	public static int getMInByDoubleSearch(int[] array) {
		boolean evenLength = array.length % 2 == 0;
		int min = 0;
		int minTemp = 0;
		if (evenLength) {
			for (int i = 0; i < array.length; i += 2) {
				int min1 = Math.min(array[i], array[i + 1]);
				min = min == 0 ? Math.min(minTemp, min1) : min1;
				i += 2;
				if (i < array.length) {
					int min2 = Math.min(array[i], array[i + 1]);
					minTemp = Math.min(min1, min2);
					min = Math.min(minTemp, min);
				} else {
					minTemp = min1;
				}
			}
		}
		return min;
	}

	public static int[] doublePickSort(int[] array) {
		int min = 0;
		int max = 0;
		int end = array.length - 1;
		for (int start = 0; start < end + 1; ) {
			int i = start;
			while (i < end) {
				++i;
				if (array[min] > array[i]) {
					min = i;
				}
				if (array[max] < array[i]) {
					max = i;
				}
			}
			int temp = array[start];
			array[start] = array[min];
			array[min] = temp;
			temp = array[end];
			array[end] = array[max];
			array[max] = temp;
			++start;
			--end;
		}
		return array;
	}

	public static int[] bubbleSort(int[] array) {
		int sorts;
		do {
			sorts = 0;
			for (int i = 0; i < array.length - 1; ++i) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					++sorts;
				}
			}
		} while (sorts != 0);
		return array;
	}

	public static int[] inputSort(int[] array) {
		for (int i = 0; i < array.length - 1; ++i) {
			if (array[i] > array[i + 1]) {
				int temp = array[i + 1];
				for (int j = i; ; --j) {
					if (j < 0 || temp >= array[j]) {
						array[j + 1] = temp;
						break;
					} else {
						array[j + 1] = array[j];
					}
				}
			}
		}
		return array;
	}

	public static int[] quickSort(int[] array) {
		return quickSort(array, 0, array.length - 1);
	}

	private static int[] quickSort(int[] array, int left, int right) {
		int x = (array[left] + array[right]) / 2;
		int i = left;
		int j = right;
		while (array[i] < x) {
			++i;
		}
		while (array[j] > x) {
			--j;
		}
		if (i <= j) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			++i;
			--j;
		}
		if (i < right) {
			quickSort(array, left = i, right);
		}
		if (j > left) {
			quickSort(array, left, j);
		}
		return array;
	}

	private static void exchange(int[] array, int num, int changer) {
		int temp = array[num];
		array[num] = array[changer];
		array[changer] = temp;
	}

	private static void sortByPyramidSmall(int[] array, int ancestor, int stage) {
		if (ancestor <= array.length / 2 - stage) {
			int firstSon = ancestor * 2 + 1;
			int secondSon = ancestor * 2 + 2;
			if (secondSon >= array.length) {
				if (array[firstSon] > array[ancestor]) {
					exchange(array, ancestor, firstSon);
				}
			} else {
				if (array[firstSon] < array[secondSon]) {
					exchange(array, ancestor, secondSon);
				} else {
					if (array[firstSon] > array[ancestor]) {
						exchange(array, ancestor, firstSon);
					}
				}
			}
		}
	}

	public static int[] pyramidSort(int[] array) {
		int stage = 1;
		for (int i = array.length / 2 - stage; i >= 0; --i) {
			int firstSon = i * 2 + 1;
			int secondSon = i * 2 + 2;
			int change = array.length;
			if (secondSon >= array.length) {
				if (array[firstSon] > array[i]) {
					change = firstSon;
					exchange(array, i, change);
				}
			} else {
				if (array[firstSon] < array[secondSon]) {
					change = secondSon;
				} else {
					change = firstSon;
				}
				if (array[change] > array[i]) {
					exchange(array, i, change);
				}
			}
			sortByPyramidSmall(array, change, stage);
		}
		do {
			int i = 0;
			int change;
			int temp = array[0];
			array[0] = array[array.length - stage];
			array[array.length - stage] = temp;
			++stage;
			if (stage >= array.length - 1) {
				break;
			}
			if (array[1] < array[2]) {
				change = 2;
			} else {
				change = 1;
			}
			if (array[change] > array[i]) {
				exchange(array, i, change);
			}
			sortByPyramidSmall(array, change, stage);
		} while (array.length - stage >= 0);
		return array;
	}
}
