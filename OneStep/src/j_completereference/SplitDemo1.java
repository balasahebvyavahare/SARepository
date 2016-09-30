package j_completereference;

import java.util.ArrayList;
import java.util.List;

public class SplitDemo1 {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = args[0];
		String str1[] = splitAndEscapeQuotes(args[0], "");
	}

	public static String[] splitAndEscapeQuotes(String record, String delimiter) {

		char c = (char) Integer.parseInt(delimiter.substring(2), 16);

		char quote = '"';
		List<String> columns = new ArrayList<String>();
		boolean inQuote = false;
		boolean delimInside = false;
		boolean isPrevQuoted = false;

		int lastStart = 0;
		int i = 0;

		int recordLength = record.length();
		for (i = 0; i < recordLength; i++) {
			if ((i + 1) == recordLength) {

				boolean isDelimiter = (record.charAt(i) == c);

				addToList(record, i, columns, inQuote, delimInside,
						isPrevQuoted, lastStart, isDelimiter, true);

				if (isDelimiter) {

					columns.add("");
				}
				break;
			}
			if (record.charAt(i) == quote) {
				// if the character is quote
				if (inQuote) {
					inQuote = false;
					isPrevQuoted = true;
					continue; // escape
				}
				inQuote = true;
				continue;
			}
			if (record.charAt(i) == c) {
				if (inQuote) {

					delimInside = true;
					continue;
				}
				addToList(record, i, columns, inQuote, delimInside,
						isPrevQuoted, lastStart, true, false);

				delimInside = false;
				isPrevQuoted = false;
				lastStart = i + 1;
			}
		}

		return columns.toArray(new String[columns.size()]);

	}

	/**
	 * Adds the to list.
	 * 
	 * @param column
	 *            the column
	 * @param currentIndex
	 *            the current index
	 * @param columnList
	 *            the column list
	 * @param inQuote
	 *            the in quote
	 * @param delimInside
	 *            the delim inside
	 * @param isPrevQuoted
	 *            the is prev quoted
	 * @param lastStart
	 *            the last start
	 * @param isDelimiter
	 *            the is delimiter
	 * @param isLastChar
	 */
	private static void addToList(String column, int currentIndex,
			List<String> columnList, boolean inQuote, boolean delimInside,
			boolean isPrevQuoted, int lastStart, boolean isDelimiter,
			boolean isLastChar) {

		if (isPrevQuoted && !delimInside) {

			columnList.add(column.substring(lastStart + 1, currentIndex - 1));
		} else if (inQuote && isLastChar) {

			columnList.add(column.substring(lastStart + 1, currentIndex));

		} else {

			if (isDelimiter) {

				columnList.add(column.substring(lastStart, currentIndex));
			} else {

				columnList.add(column.substring(lastStart, currentIndex + 1));
			}
		}
	}

}
