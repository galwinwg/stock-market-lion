package sysImplementation;

import java.util.ArrayList;

public class Utilities {

	public static String addDelimiter(String str, char delimeter) {
		String changeChar = "" + delimeter;

		if (str.length() == 1) {
			return str;
		} else {
			return str.charAt(0) + changeChar + addDelimiter(str.substring(1), delimeter);
		}

	}

	public static String getDigits(String str) {

		if (str.length() == 0) {
			return str;
		} else if (Character.isDigit(str.charAt(0))) {
			return str.charAt(0) + getDigits(str.substring(1));
		} else {
			return getDigits(str.substring(1));
		}
	}

	public static void replaceCharacter(char[] array, char target, char replacement) {
		array = auxReplaceCharacter(array, 0, target, replacement);
	}

	private static char[] auxReplaceCharacter(char[] array, int index, char target, char replacement) {
		char[] newArray = new char[array.length];
		newArray = array;

		if (index > array.length - 1) {
			return newArray;
		} else if (array[index] == target) {

			newArray[index] = replacement;
			return auxReplaceCharacter(newArray, index + 1, target, replacement);
		} else {

			return auxReplaceCharacter(newArray, index + 1, target, replacement);
		}
	}

	public static int getSumEven(int[] array) {
		return auxGetSumEven(array, 0);
	}

	private static int auxGetSumEven(int[] array, int index) {

		if (index > array.length - 1) {
			return 0;
		} else if ((array[index] % 2) == 0) {
			return array[index] + auxGetSumEven(array, index + 1);
		} else {
			return auxGetSumEven(array, index + 1);
		}

	}

	public static ArrayList<Integer> getListRowIndices(int[][] array, int rowLength) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		return auxGetListRowIndices(array, temp, 0, rowLength);
	}

	private static ArrayList<Integer> auxGetListRowIndices(int[][] array, ArrayList<Integer> arrayList, int index,
			int rowLength) {

		if (index > array.length - 1) {
			return arrayList;
		} else if (array[index].length == rowLength) {
			arrayList.add(index);
			return auxGetListRowIndices(array, arrayList, index + 1, rowLength);
		} else {
			return auxGetListRowIndices(array, arrayList, index + 1, rowLength);
		}

	}

	public static int replaceCells(char[][] array, int x, int y, char target, char replacement) {

		return auxReplaceCells(array, x, y, target, replacement);

	}

	private static int auxReplaceCells(char[][] array, int x, int y, char target, char replacement) {

		if (!checkValid(array, x, y)) {
			return 0;
		} else if (array[x][y] == target) {
			array[x][y] = replacement;

			return 1 + auxReplaceCells(array, x, y + 1, target, replacement)
					+ auxReplaceCells(array, x, y - 1, target, replacement)
					+ auxReplaceCells(array, x + 1, y, target, replacement)
					+ auxReplaceCells(array, x + 1, y + 1, target, replacement)
					+ auxReplaceCells(array, x + 1, y - 1, target, replacement)
					+ auxReplaceCells(array, x - 1, y, target, replacement)
					+ auxReplaceCells(array, x - 1, y + 1, target, replacement)
					+ auxReplaceCells(array, x - 1, y - 1, target, replacement);

		} else {
			return 0;
		}

	}

	private static boolean checkValid(char[][] array, int x, int y) {
		int rowLength = array.length;

		if (x < rowLength && x >= 0) {
			int colLength = array[x].length;
			if (y < colLength && y >= 0) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

}
