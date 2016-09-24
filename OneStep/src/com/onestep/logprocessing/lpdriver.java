package com.onestep.logprocessing;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.onestep.hadoop.fileLoader.FileLoaderDriver;
import com.onestep.hadoop.fileLoader.FileLoaderMapper;
import com.onestep.hadoop.wordcount.WordcountDriver;

public class lpdriver extends Configured implements Tool {

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
		job.setJarByClass(lpdriver.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		Path inputFilePath = new Path(args[0]);
		Path outputFilePath = new Path(args[1]);

		job.setMapperClass(lpmapper.class);
		job.setReducerClass(lpreducer.class);

		FileInputFormat.addInputPath(job, inputFilePath);
		FileOutputFormat.setOutputPath(job, outputFilePath);

		FileSystem fs = FileSystem.newInstance(getConf());

		if (fs.exists(outputFilePath)) {
			fs.delete(outputFilePath, true);
		}
		return job.waitForCompletion(true) ? 0 : 1;

	}

	public static void main(String args[]) throws Exception {
		lpdriver loadingProblemDriver = new lpdriver();
		int res = ToolRunner.run(loadingProblemDriver, args);
		System.exit(res);
	}

}
