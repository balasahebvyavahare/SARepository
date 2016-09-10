package j_completereference;

import java.util.ArrayList;
import java.util.List;

public class SplitDemo {
	
	public static void main(String args[]){
		
		
		
		String str = args[0];
		
		String str1[] = splitAndEscapeQuotes(args[0], "");
		
		for(int i = 0 ; i < str1.length ; i++)
			System.out.println(str1[i]);
		
	}
	
	public static String[] splitAndEscapeQuotes(String record, String delimiter) {

		char c = '|';

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
					
					addToList(record, i, columns, inQuote, delimInside,
							isPrevQuoted, lastStart, true, false);
					
					delimInside = false;
					isPrevQuoted = false;
					lastStart = i ;					
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

	
	private static void addToList(String column, int currentIndex,
			List<String> columnList, boolean inQuote, boolean delimInside,
			boolean isPrevQuoted, int lastStart, boolean isDelimiter,
			boolean isLastChar) {

		if (isPrevQuoted && !delimInside) {

			columnList.add(column.substring(lastStart + 1, currentIndex - 1));
		}
		else if(inQuote && delimInside){
			
			 columnList.add(column.substring(lastStart , currentIndex - 2).replace('"', '_'));
			//System.out.print("error case----> " + column + "  lastStart = " +lastStart + "  currentIndex  " + currentIndex);
		}
		else if (inQuote && isLastChar) {

			columnList.add(column.substring(lastStart + 1, currentIndex+1));

		} else {

			if (isDelimiter) {

				columnList.add(column.substring(lastStart, currentIndex));
			} else {

				columnList.add(column.substring(lastStart, currentIndex + 1));
			}
		}
	}

}
