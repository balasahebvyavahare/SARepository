package com.onestep.logprocessing;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class avgTranReducer extends Reducer<Text, Text, Text, Text> {

	static String StringDate = null;
	static String tempStringDataDate = null;
	static int countOfTransaction = 0;
	static int countOfDays = 1;
	HashSet<String> Dates = new HashSet<String>();

	public void reduce(final Text key, final Iterable<Text> values,
			final Context context) throws IOException, InterruptedException {

		Iterator<Text> iteratortoCountTransaction = values.iterator();
		
		countOfTransaction = 0;

		Dates.removeAll(Dates);
		
		while (iteratortoCountTransaction.hasNext()) {
			Text DateAndCount = iteratortoCountTransaction.next();
		
			countOfTransaction++;

			tempStringDataDate = DateAndCount.toString().substring(0, 10);
			
			Dates.add(tempStringDataDate);
		}
		
		Integer numOfDays = Dates.size();
		
		Float AverageSuccessTransation = (float) (countOfTransaction / numOfDays);

		context.write(key, new Text(AverageSuccessTransation.toString()));
	}

}
