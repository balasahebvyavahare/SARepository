package com.onestep.hadoop.fileLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.mortbay.log.Log;

public class FileLoaderMapper extends Mapper<LongWritable, Text, Text, Text> {

	private final static IntWritable one = new IntWritable(1);
	private Text word = new Text();

	enum NumberRecords{
		RECORD_COUNT
	}
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String line = value.toString();

		StringTokenizer tokenizer = new StringTokenizer(line ,"|");
		
		ArrayList<String> ArrLis = new ArrayList<String>(value.getLength());
		while(tokenizer.hasMoreTokens())
		{
			ArrLis.add(tokenizer.nextToken());
			
		}
		context.getCounter(NumberRecords.RECORD_COUNT).increment(1);
		String tKey =ArrLis.get(0);
		String tValue = ArrLis.get(1);
		
		
		
		context.write(new Text(tKey), new Text(tValue));
	}

	public void run(Context context) throws IOException, InterruptedException {
		setup(context);
		while (context.nextKeyValue()) {
			map(context.getCurrentKey(), context.getCurrentValue(), context);
		}
		cleanup(context);
	}

}