package com.onestep.logprocessing;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class lpreducer extends Reducer<Text, Text, Text, Text> {

	public void reduce(final Text key, final Iterable<Text> values,
			final Context context) throws IOException, InterruptedException {

		Iterator<Text> iterator = values.iterator();

		Long TotalTime = (long) 0;

		while (iterator.hasNext()) {

			String tempString = iterator.next().toString();

			Long tempLong = new Long(tempString);

			TotalTime = TotalTime + tempLong;
		}

		String checkForPipe = key.toString();
		if (checkForPipe.indexOf('|') > 0) {
			String UserandMultipleID[] = checkForPipe.split(",");
			String User = UserandMultipleID[0];
			String IPList[] =  UserandMultipleID[1].split("\\|");
			
			for(int i = 0 ; i< IPList.length; i++){
				String finalUserandIP = User + "," + IPList[i];
				context.write(new Text(finalUserandIP), new Text(TotalTime.toString()));
			}
				
			
		} else {
			context.write(key, new Text(TotalTime.toString()));
		}

	}

}
