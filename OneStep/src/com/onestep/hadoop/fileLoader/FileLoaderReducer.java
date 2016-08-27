package com.onestep.hadoop.fileLoader;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FileLoaderReducer extends
		Reducer<Text, Text, Text, Text> {

	private Text totalWordCount = new Text();

	@Override
	public void reduce(final Text key, final Iterable<Text> values,
			final Context context) throws IOException, InterruptedException {

		String sum = "not found" ;
		Iterator<Text> iterator = values.iterator();

		while (iterator.hasNext()) {
			sum = iterator.next().toString();
		}

		
		// context.write(key, new IntWritable(sum));
		context.write(new Text(""), new Text(sum));
	}
}
