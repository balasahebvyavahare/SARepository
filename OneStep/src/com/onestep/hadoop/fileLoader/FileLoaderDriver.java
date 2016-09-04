package com.onestep.hadoop.fileLoader;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.onestep.hadoop.wordcount.WordcountDriver;
import com.onestep.hadoop.wordcount.WordcountMapper;
import com.onestep.hadoop.wordcount.WordcountReducer;

public class FileLoaderDriver extends Configured implements Tool {

	@Override
	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub I am adding this comment just to check the github functionality

		if (args.length != 2) {
			System.out.println("Usage: [input] [output] xsd,mfnsdf");
			System.exit(-1);
		}

		Job job = Job.getInstance(getConf());
		job.setJobName("wordcount");
		job.setJarByClass(WordcountDriver.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		job.setMapperClass(FileLoaderMapper.class);
		//job.setReducerClass(FileLoaderReducer.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		Path inputFilePath = new Path(args[0]);
		Path outputFilePath = new Path(args[1]);

		FileInputFormat.addInputPath(job, inputFilePath);
		FileOutputFormat.setOutputPath(job, outputFilePath);

		/*
		 * Delete output filepath if already exists
		 */
		FileSystem fs = FileSystem.newInstance(getConf());

		if (fs.exists(outputFilePath)) {
			fs.delete(outputFilePath, true);
		}

		return job.waitForCompletion(true) ? 0 : 1;
	}
	
	public static void main(String args[]) throws Exception
	{
		FileLoaderDriver fileloaderDriver = new FileLoaderDriver();
		int res = ToolRunner.run(fileloaderDriver, args);
		System.exit(res);
	}
	
}
