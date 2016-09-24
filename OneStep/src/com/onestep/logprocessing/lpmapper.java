package com.onestep.logprocessing;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class lpmapper extends Mapper<LongWritable, Text, Text, Text> {

	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		
		
		if (value.toString().length() >=6) {
			String arrEntityAttributes[] = value.toString().split(","); 
			
			if(arrEntityAttributes.length >= 6){
				
				Long tempTime = new Long(arrEntityAttributes[4]) - new Long(arrEntityAttributes[3]);    
				
				String mapKey = arrEntityAttributes[5] + "," + arrEntityAttributes[1];
				
				context.write(new Text(mapKey), new Text(tempTime.toString()));
				
			}

			

		}

	}

}
