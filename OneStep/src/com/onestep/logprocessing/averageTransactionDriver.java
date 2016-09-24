package com.onestep.logprocessing;

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



public class averageTransactionDriver extends Configured implements Tool {

	/**
	 * @param args
	 */
	public int run(String args[]) throws Exception {
		//

		if (args.length != 2) {
			System.out.println("Usage: [input] [output] xsd,mfnsdf");
			System.exit(-1);
		}

		Job job = Job.getInstance(getConf());
		job.setJobName("Log Processing Problem 1");
		job.setJarByClass(averageTransactionDriver.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		Path inputFilePath = new Path(args[0]);
		Path outputFilePath = new Path(args[1]);

		job.setMapperClass(avgTranMapper.class);
		job.setReducerClass(avgTranReducer.class);

		FileInputFormat.addInputPath(job, inputFilePath);
		FileOutputFormat.setOutputPath(job, outputFilePath);

		FileSystem fs = FileSystem.newInstance(getConf());

		if (fs.exists(outputFilePath)) {
			fs.delete(outputFilePath, true);
		}
		return job.waitForCompletion(true) ? 0 : 1;

	}

	public static void main(String args[]) throws Exception {
		averageTransactionDriver driver = new averageTransactionDriver();
		int res = ToolRunner.run(driver, args);
		System.exit(res);
	}

}
