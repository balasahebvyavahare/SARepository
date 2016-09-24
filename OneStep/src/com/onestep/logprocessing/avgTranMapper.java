package com.onestep.logprocessing;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class avgTranMapper extends Mapper<LongWritable, Text, Text, Text> {

	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		IntWritable count = new IntWritable(1);
		
		if (value.toString().length() >=6) {
			String arrEntityAttributes[] = value.toString().split(","); 
			
			if(arrEntityAttributes.length >= 6){
				
				if(arrEntityAttributes[6].equalsIgnoreCase("SUCCESS_NLP_CONVERSION")){
				
				String mapKey = arrEntityAttributes[5];
				
				String mapValue =  arrEntityAttributes[0].substring(0,10).concat(",").concat(count.toString());
				
				context.write(new Text(mapKey), new Text(mapValue));
				
				}
				
				
			}

		}

	}
}
